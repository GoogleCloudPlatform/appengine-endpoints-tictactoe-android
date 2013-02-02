appengine-endpoints-tictactoe-android
=====================================

This application implements a simple client for a Tic Tac Toe game using
Google Cloud Endpoints, App Engine, Java, and Android.

## Products
- [App Engine][1]
- [Android][2]

## Language
- [Java][3]

## APIs
- [Google Cloud Endpoints][4]

## Setup Instructions
1. Import the project into Eclipse.
2. Make sure the following files are added to a `libs` directory in your
   project (they come from the google-api-java-client and are not bundled with
   this sample):
    - google-api-client-1.12.0-beta.jar
    - google-api-client-android-1.12.0-beta.jar
    - google-http-client-1.12.0-beta.jar
    - google-http-client-android-1.12.0-beta.jar
    - google-http-client-gson-1.12.0-beta.jar
    - google-oauth-client-1.12.0-beta.jar
    - gson-2.1.jar
    - guava-jdk5-13.0.jar
    - jsr305-1.3.9.jar
   Later versions of these libraries may work, but it's not guaranteed.
3. Update the value of `DEFAULT_ROOT_URL` in
   `src/com/appspot/api/services/tictactoe/Tictactoe.java` to point to the
   location where you are hosting a Tic Tac Toe backend (based off of the [Java
   backend example][5]).
4. Update the value of `AUDIENCE` in
   `src/com/google/devrel/samples/ttt/ClientCredentials.java`, replacing the
   string "your_web_client_id" with the web application client ID you
   registered in the [APIs Console][6].
5. Run the application.

[1]: https://developers.google.com/appengine
[2]: http://developer.android.com/index.html
[3]: http://java.com/en/
[4]: https://developers.google.com/appengine/docs/java/endpoints/
[5]: https://github.com/GoogleCloudPlatform/appengine-endpoints-tictactoe-java
[6]: https://code.google.com/apis/console
