package com.google.devrel.samples.ttt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import android.accounts.AccountManager;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.tictactoe.Tictactoe;
import com.google.api.services.tictactoe.model.Board;
import com.google.api.services.tictactoe.model.Score;
import com.google.api.services.tictactoe.model.ScoreCollection;

/**
 * Main activity for the application, it handles the game UI and auth and
 * spawns tasks to Endpoints.
 */
public class TictactoeActivity extends Activity {
  private static final Level LOGGING_LEVEL = Level.ALL;

  private static final String TAG = "TicTacToeSample";

  static final String PREF_ACCOUNT_NAME = "accountName";
  static final int REQUEST_GOOGLE_PLAY_SERVICES = 0;
  static final int REQUEST_ACCOUNT_PICKER = 1;
  static final String PREF_AUTH_TOKEN = "authToken";

  /**
   * Preference object where the app stores the name of the preferred user.
   */
  SharedPreferences settings;
  String accountName;

  /**
   * Credentials object that maintains tokens to send to the backend.
   */
  GoogleAccountCredential credential;

  boolean signedIn = false;
  boolean waitingForMove = false;

  /**
   * Service object that manages requests to the backend.
   */
  Tictactoe service;

  private static final int[] BOARD_BUTTONS = {
    R.id.topLeft, R.id.topMiddle, R.id.topRight,
    R.id.middleLeft, R.id.middleMiddle, R.id.middleRight,
    R.id.bottomLeft, R.id.bottomMiddle, R.id.bottomRight
  };

  private static final int NOT_DONE = 0;
  private static final int WON = 1;
  private static final int LOST = 2;
  private static final int TIE = 3;
  private static final String[] STATUS_STRINGS = {
    "NOT_DONE",
    "WON",
    "LOST",
    "TIE"
  };

  /**
   * Handles logic for clicking the sign in button.
   *
   * @param v current view within the application, for rendering updates
   */
  public void signIn(View v) {
    if (!this.signedIn) {
      chooseAccount();
    } else {
      forgetAccount();
      setSignInEnablement(true);
      setBoardEnablement(false);
      setAccountLabel("(not signed in)");
    }
  }

  private void chooseAccount() {
    startActivityForResult(credential.newChooseAccountIntent(), REQUEST_ACCOUNT_PICKER);
  }

  private void setAccountName(String accountName) {
    SharedPreferences.Editor editor = settings.edit();
    editor.putString(PREF_ACCOUNT_NAME, accountName);
    editor.commit();
    credential.setSelectedAccountName(accountName);
    this.accountName = accountName;
  }

  private void onSignIn() {
    this.signedIn = true;
    this.waitingForMove = true;
    setSignInEnablement(false);
    setBoardEnablement(true);
    setAccountLabel(this.accountName);
    queryScores();
  }

  private void forgetAccount() {
    this.signedIn = false;
    SharedPreferences.Editor editor2 = settings.edit();
    editor2.remove(PREF_AUTH_TOKEN);
    editor2.commit();
  }

  /**
   * Handles filling in a square on the board.
   *
   * @param v current view within the application, for rendering updates
   */
  public void clickSquare(View v) {
    Button button = (Button) v;
    if (waitingForMove && button.getText().equals("-")) {
      button.setText("X");
      waitingForMove = false;
      final String boardString = getBoardString();

      int status = checkForVictory(boardString);
      if (status == NOT_DONE) {
        getComputerMove(boardString);
      } else {
        handleFinish(status);
      }
    }
  }

  /**
   * Handles resetting of the game board.
   *
   * @param v current view within the application, for rendering updates
   */
  public void resetGame(View v) {
    setBoardFilling("---------");
    TextView victory = (TextView) findViewById(R.id.victory);
    victory.setText("");
    waitingForMove = true;
  }

  /**
   * Gets the computer's move, spawning an AsyncTask to make the request.
   *
   * @param boardString state of the board
   */
  private void getComputerMove(final String boardString) {
    Board board = new Board();
    board.setState(boardString);
    new GetComputerMoveTask().execute(board);
  }

  /**
   * Handles the request to the Board Endpoint, to get the computer's move,
   * without blocking the UI.
   */
  private class GetComputerMoveTask extends AsyncTask<Board, Board, Board> {
    @Override
    protected Board doInBackground(Board... boards) {
      Board newBoard = null;
      try {
        newBoard = service.board().getmove(boards[0]).execute();
        return newBoard;
      } catch (IOException e) {
        Log.d("TicTacToe", e.getMessage(), e);
      }
      return newBoard;
    }

    @Override
    protected void onPostExecute(Board board) {
      setBoardFilling(board.getState());

      int status = checkForVictory(board.getState());
      if (status != 0) {
        handleFinish(status);
      } else {
        waitingForMove = true;
      }
    }
  }

  /**
   * Stores the game outcome on the server, spawning an AsyncTask to make the
   * request.
   *
   * @param status outcome of the game
   */
  private void sendResultToServer(int status) {
    Score score = new Score();
    score.setOutcome(STATUS_STRINGS[status]);
    new SendResultToServerTask().execute(score);
  }

  /**
   * Handles the request to the Score Endpoint, to save a score, without
   * blocking the UI.
   */
  private class SendResultToServerTask extends AsyncTask<Score, Void, Void> {
    @Override
    protected Void doInBackground(Score... scores) {
      try {
        service.scores().insert(scores[0]).execute();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
      queryScores();
    }
  }

  /**
   * Queries for previous game outcomes for the current player, spawning an
   * AsyncTask to make the request.
   */
  private void queryScores() {
    new QueryScoresTask(this).execute();
  }

  /**
   * Handles the request to the Score Endpoint, to retrieve scores, without
   * blocking the UI.
   */
  private class QueryScoresTask extends AsyncTask<Void, Void, ScoreCollection> {
    Activity activity;

    public QueryScoresTask(Activity activity) {
      this.activity = activity;
    }

    @Override
    protected ScoreCollection doInBackground(Void... unused) {
      ScoreCollection scores = null;
      try {
        scores = service.scores().list().execute();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return scores;
    }

    @Override
    protected void onPostExecute(ScoreCollection scores) {
      ListView gameHistory = (ListView) findViewById(R.id.gameHistory);
      ArrayList<String> values = new ArrayList<String>();
      ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity,
          android.R.layout.simple_list_item_1, android.R.id.text1, values);
      if (scores != null && scores.getItems() != null) {
        for (Score score : scores.getItems()) {
          values.add(score.getOutcome());
        }
        gameHistory.setAdapter(adapter);
      }
    }
  }

  private void setBoardEnablement(boolean state) {
    for (int i : BOARD_BUTTONS) {
      setItemEnablement(i, state);
    }
    setItemEnablement(R.id.restartButton, state);
    setItemEnablement(R.id.victory, state);
    setItemEnablement(R.id.gameHistory, state);
    setItemEnablement(R.id.previousGames, state);
  }

  private void setItemEnablement(int id, boolean state) {
    View item = findViewById(id);
    if (state) {
      item.setVisibility(View.VISIBLE);
    } else {
      item.setVisibility(View.INVISIBLE);
    }
  }

  private void setBoardFilling(String boardString) {
    for (int i = 0; i < BOARD_BUTTONS.length; i++) {
      Button button = (Button) findViewById(BOARD_BUTTONS[i]);
      button.setText(boardString.subSequence(i, i+1));
    }
  }

  private void setSignInEnablement(boolean state) {
    Button button = (Button) findViewById(R.id.signin);
    if (state) {
      button.setText("Sign In");
    } else {
      button.setText("Sign Out");
    }
  }

  private void setAccountLabel(String label) {
    TextView userLabel = (TextView) findViewById(R.id.userLabel);
    userLabel.setText(label);
  }

  private int checkForVictory(String board) {
    int status = 0;

    // Check rows and columns.
    for (int i = 0; i < 3; i++) {
      String rowString = getStringsAtPositions(board, i*3, (i*3)+1, (i*3)+2);
      status |= checkSectionVictory(rowString);

      String colString = getStringsAtPositions(board, i, i+3, i+6);
      status |= checkSectionVictory(colString);
    }

    // Check top-left to bottom-right.
    String diagonal = getStringsAtPositions(board, 0, 4, 8);
    status |= checkSectionVictory(diagonal);

    // Check top-right to bottom-left.
    diagonal = getStringsAtPositions(board, 2, 4, 6);
    status |= checkSectionVictory(diagonal);

    if (status == 0) {
      if (board.indexOf("-") == -1) {
        return TIE;
      }
    }

    return status;
  }

  private int checkSectionVictory(String section) {
    char a = section.charAt(0);
    char b = section.charAt(1);
    char c = section.charAt(2);
    if (a == b && a == c) {
      if (a == 'X') {
        return WON;
      } else if (a == 'O') {
        return LOST;
      }
    }
    return NOT_DONE;
  }

  private void handleFinish(int status) {
    TextView victory = (TextView) findViewById(R.id.victory);
    if (status == WON) {
      victory.setText("You win!");
    } else if (status == LOST) {
      victory.setText("You lost!");
    } else {
      victory.setText("You tied!");
    }
    sendResultToServer(status);
  }

  private String getBoardString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i : BOARD_BUTTONS) {
      Button button = (Button) findViewById(i);
      stringBuilder.append(button.getText());
    }
    return stringBuilder.toString();
  }

  private String getStringsAtPositions(String string, int first, int second,
      int third) {
    return new StringBuilder().append(string.charAt(first))
                              .append(string.charAt(second))
                              .append(string.charAt(third))
                              .toString();
  }

  /**
   * Called when the activity is first created. It displays the UI, checks
   * for the account previously chosen to sign in (if available), and
   * configures the service object.
   */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    settings = getSharedPreferences(TAG, 0);
    credential = GoogleAccountCredential.usingAudience(this, ClientCredentials.AUDIENCE);
    setAccountName(settings.getString(PREF_ACCOUNT_NAME, null));

    Tictactoe.Builder builder = new Tictactoe.Builder(
        AndroidHttp.newCompatibleTransport(), new GsonFactory(),
        credential);
    service = builder.build();

    if (credential.getSelectedAccountName() != null) {
      onSignIn();
    }

    Logger.getLogger("com.google.api.client").setLevel(LOGGING_LEVEL);
  }

  @Override
  protected void onResume() {
    super.onResume();
    checkGooglePlayServicesAvailable();
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    switch (requestCode) {
      case REQUEST_ACCOUNT_PICKER:
        if (data != null && data.getExtras() != null) {
          String accountName = data.getExtras().getString(AccountManager.KEY_ACCOUNT_NAME);
          if (accountName != null) {
            setAccountName(accountName);
            SharedPreferences.Editor editor = settings.edit();
            editor.putString(PREF_ACCOUNT_NAME, accountName);
            editor.commit();
            onSignIn();
          }
        }
        break;
    }
  }

  /**
   * Check that Google Play services APK is installed and up to date.
   */
  private boolean checkGooglePlayServicesAvailable() {
    final int connectionStatusCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
    if (GooglePlayServicesUtil.isUserRecoverableError(connectionStatusCode)) {
      showGooglePlayServicesAvailabilityErrorDialog(connectionStatusCode);
      return false;
    }
    return true;
  }

  /**
   * Called if the device does not have Google Play Services installed.
   */
  void showGooglePlayServicesAvailabilityErrorDialog(final int connectionStatusCode) {
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        Dialog dialog = GooglePlayServicesUtil.getErrorDialog(
            connectionStatusCode, TictactoeActivity.this, REQUEST_GOOGLE_PLAY_SERVICES);
        dialog.show();
      }
    });
  }
}
