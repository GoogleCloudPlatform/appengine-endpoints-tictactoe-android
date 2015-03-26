appengine-endpoints-tictactoe-android
=====================================

This application implements a simple client for a Tic Tac Toe game using
Google Cloud Endpoints, App Engine, Java, and Android.

**NOTE:** This sample was written with a Java backend in mind. As a result, 
the generated code will differ slightly than that for the [Python Tic Tac
Toe sample][8]. For the most part this will be immaterial to the sample,
but there are a few key differences:
- The generated schema names in the discovery document are different in Python
  than in Java, even though the hold the same data. This will cause the generated
  classes corresponding to the schema to have different names.
- Python supports enums and uses `'WHEN'` and `'TEXT'` for the `order` field in
  queries, while Java simply uses `"1"` and `"2"`, respectively.
- The Python backend stores the current user for authenticated requests, but does
  not return the user in the score insert response or score list response.

## Products
- [App Engine][1]
- [Android][2]

## Language
- [Java][3]

## APIs
- [Google Cloud Endpoints][4]

## Setup Instructions
1. Open the project in Android Studio.
1. Update the value of `DEFAULT_ROOT_URL` in
   `src/com/appspot/api/services/tictactoe/Tictactoe.java` to point to the
   location where you are hosting a Tic Tac Toe backend (based off of the [Java
   backend example][6]).
1. Update the value of `AUDIENCE` in
   `src/com/google/devrel/samples/ttt/ClientCredentials.java`, replacing the
   string "your_web_client_id" with the web application client ID you
   registered in the [APIs Console][7].
1. Run the application.

[1]: https://developers.google.com/appengine
[2]: http://developer.android.com/index.html
[3]: http://java.com/en/
[4]: https://developers.google.com/appengine/docs/java/endpoints/
[5]: https://developer.android.com/google/play-services/setup.html
[6]: https://github.com/GoogleCloudPlatform/appengine-endpoints-tictactoe-java
[7]: https://code.google.com/apis/console
[8]:  https://github.com/GoogleCloudPlatform/appengine-endpoints-tictactoe-python
