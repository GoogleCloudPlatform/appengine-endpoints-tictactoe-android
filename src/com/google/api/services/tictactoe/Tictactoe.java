/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This file was generated.
 *  with google-apis-code-generator 1.3.0 (build: 2013-04-09 19:13:20 UTC)
 *  on 2013-04-11 at 20:44:37 UTC 
 */

package com.google.api.services.tictactoe;

import com.google.api.client.googleapis.GoogleUtils;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.common.base.Preconditions;

/**
 * Service definition for Tictactoe (v1).
 *
 * <p>
 * This is an API
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link TictactoeRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * <p>
 * Upgrade warning: this class now extends {@link AbstractGoogleJsonClient}, whereas in prior
 * version 1.8 it extended {@link com.google.api.client.googleapis.services.GoogleClient}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Tictactoe extends AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    Preconditions.checkState(GoogleUtils.VERSION.equals("1.13.2-beta"),
        "You are currently running with version %s of google-api-client. " +
        "You need version 1.13.2-beta of google-api-client to run version " +
        "1.13.2-beta of the  library.", GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "https://your_app_id.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "tictactoe/v1/";

  /**
   * The default encoded base URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   * @deprecated (scheduled to be removed in 1.13)
   */
  @Deprecated
  public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

  /**
   * Constructor.
   *
   * <p>
   * Use {@link Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport HTTP transport
   * @param jsonFactory JSON factory
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @since 1.7
   */
  public Tictactoe(HttpTransport transport, JsonFactory jsonFactory,
      HttpRequestInitializer httpRequestInitializer) {
    super(transport,
        jsonFactory,
        DEFAULT_ROOT_URL,
        DEFAULT_SERVICE_PATH,
        httpRequestInitializer,
        false);
  }

  /**
   * @param transport HTTP transport
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @param rootUrl root URL of the service
   * @param servicePath service path
   * @param jsonObjectParser JSON object parser
   * @param googleClientRequestInitializer Google request initializer or {@code null} for none
   * @param applicationName application name to be sent in the User-Agent header of requests or
   *        {@code null} for none
   * @param suppressPatternChecks whether discovery pattern checks should be suppressed on required
   *        parameters
   */
  Tictactoe(HttpTransport transport,
      HttpRequestInitializer httpRequestInitializer,
      String rootUrl,
      String servicePath,
      JsonObjectParser jsonObjectParser,
      GoogleClientRequestInitializer googleClientRequestInitializer,
      String applicationName,
      boolean suppressPatternChecks) {
    super(transport,
        httpRequestInitializer,
        rootUrl,
        servicePath,
        jsonObjectParser,
        googleClientRequestInitializer,
        applicationName,
        suppressPatternChecks);
  }

  @Override
  protected void initialize(AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * An accessor for creating requests from the Board collection.
   *
   * <p>The typical use is:</p>
   * <pre>
   *   {@code Tictactoe tictactoe = new Tictactoe(...);}
   *   {@code Tictactoe.Board.List request = tictactoe.board().list(parameters ...)}
   * </pre>
   *
   * @return the resource collection
   */
  public Board board() {
    return new Board();
  }

  /**
   * The "board" collection of methods.
   */
  public class Board {

    /**
     * Create a request for the method "board.getmove".
     *
     * This request holds the parameters needed by the the tictactoe server.  After setting any optional
     * parameters, call the {@link Getmove#execute()} method to invoke the remote operation.
     *
     * @param content the {@link com.google.api.services.tictactoe.model.Board}
     * @return the request
     */
    public Getmove getmove(com.google.api.services.tictactoe.model.Board content) throws java.io.IOException {
      Getmove result = new Getmove(content);
      initialize(result);
      return result;
    }

    public class Getmove extends TictactoeRequest<com.google.api.services.tictactoe.model.Board> {

      private static final String REST_PATH = "board";

      /**
       * Create a request for the method "board.getmove".
       *
       * This request holds the parameters needed by the the tictactoe server.  After setting any
       * optional parameters, call the {@link Getmove#execute()} method to invoke the remote operation.
       * <p> {@link Getmove#initialize(AbstractGoogleClientRequest)} must be called to initialize this
       * instance immediately after invoking the constructor. </p>
       *
       * @param content the {@link com.google.api.services.tictactoe.model.Board}
       * @since 1.13
       */
      protected Getmove(com.google.api.services.tictactoe.model.Board content) {
        super(Tictactoe.this, "POST", REST_PATH, content, com.google.api.services.tictactoe.model.Board.class);
      }

      @Override
      public Getmove setAlt(String alt) {
        return (Getmove) super.setAlt(alt);
      }

      @Override
      public Getmove setFields(String fields) {
        return (Getmove) super.setFields(fields);
      }

      @Override
      public Getmove setKey(String key) {
        return (Getmove) super.setKey(key);
      }

      @Override
      public Getmove setOauthToken(String oauthToken) {
        return (Getmove) super.setOauthToken(oauthToken);
      }

      @Override
      public Getmove setPrettyPrint(Boolean prettyPrint) {
        return (Getmove) super.setPrettyPrint(prettyPrint);
      }

      @Override
      public Getmove setQuotaUser(String quotaUser) {
        return (Getmove) super.setQuotaUser(quotaUser);
      }

      @Override
      public Getmove setUserIp(String userIp) {
        return (Getmove) super.setUserIp(userIp);
      }

    }

  }

  /**
   * An accessor for creating requests from the Scores collection.
   *
   * <p>The typical use is:</p>
   * <pre>
   *   {@code Tictactoe tictactoe = new Tictactoe(...);}
   *   {@code Tictactoe.Scores.List request = tictactoe.scores().list(parameters ...)}
   * </pre>
   *
   * @return the resource collection
   */
  public Scores scores() {
    return new Scores();
  }

  /**
   * The "scores" collection of methods.
   */
  public class Scores {

    /**
     * Create a request for the method "scores.insert".
     *
     * This request holds the parameters needed by the the tictactoe server.  After setting any optional
     * parameters, call the {@link Insert#execute()} method to invoke the remote operation.
     *
     * @param content the {@link com.google.api.services.tictactoe.model.Score}
     * @return the request
     */
    public Insert insert(com.google.api.services.tictactoe.model.Score content) throws java.io.IOException {
      Insert result = new Insert(content);
      initialize(result);
      return result;
    }

    public class Insert extends TictactoeRequest<com.google.api.services.tictactoe.model.Score> {

      private static final String REST_PATH = "score";

      /**
       * Create a request for the method "scores.insert".
       *
       * This request holds the parameters needed by the the tictactoe server.  After setting any
       * optional parameters, call the {@link Insert#execute()} method to invoke the remote operation.
       * <p> {@link Insert#initialize(AbstractGoogleClientRequest)} must be called to initialize this
       * instance immediately after invoking the constructor. </p>
       *
       * @param content the {@link com.google.api.services.tictactoe.model.Score}
       * @since 1.13
       */
      protected Insert(com.google.api.services.tictactoe.model.Score content) {
        super(Tictactoe.this, "POST", REST_PATH, content, com.google.api.services.tictactoe.model.Score.class);
      }

      @Override
      public Insert setAlt(String alt) {
        return (Insert) super.setAlt(alt);
      }

      @Override
      public Insert setFields(String fields) {
        return (Insert) super.setFields(fields);
      }

      @Override
      public Insert setKey(String key) {
        return (Insert) super.setKey(key);
      }

      @Override
      public Insert setOauthToken(String oauthToken) {
        return (Insert) super.setOauthToken(oauthToken);
      }

      @Override
      public Insert setPrettyPrint(Boolean prettyPrint) {
        return (Insert) super.setPrettyPrint(prettyPrint);
      }

      @Override
      public Insert setQuotaUser(String quotaUser) {
        return (Insert) super.setQuotaUser(quotaUser);
      }

      @Override
      public Insert setUserIp(String userIp) {
        return (Insert) super.setUserIp(userIp);
      }

    }
    /**
     * Create a request for the method "scores.list".
     *
     * This request holds the parameters needed by the the tictactoe server.  After setting any optional
     * parameters, call the {@link List#execute()} method to invoke the remote operation.
     *
     * @return the request
     */
    public List list() throws java.io.IOException {
      List result = new List();
      initialize(result);
      return result;
    }

    public class List extends TictactoeRequest<com.google.api.services.tictactoe.model.ScoreCollection> {

      private static final String REST_PATH = "score";

      /**
       * Create a request for the method "scores.list".
       *
       * This request holds the parameters needed by the the tictactoe server.  After setting any
       * optional parameters, call the {@link List#execute()} method to invoke the remote operation. <p>
       * {@link List#initialize(AbstractGoogleClientRequest)} must be called to initialize this instance
       * immediately after invoking the constructor. </p>
       *
       * @since 1.13
       */
      protected List() {
        super(Tictactoe.this, "GET", REST_PATH, null, com.google.api.services.tictactoe.model.ScoreCollection.class);
      }

      @Override
      public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
        return super.executeUsingHead();
      }

      @Override
      public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
        return super.buildHttpRequestUsingHead();
      }

      @Override
      public List setAlt(String alt) {
        return (List) super.setAlt(alt);
      }

      @Override
      public List setFields(String fields) {
        return (List) super.setFields(fields);
      }

      @Override
      public List setKey(String key) {
        return (List) super.setKey(key);
      }

      @Override
      public List setOauthToken(String oauthToken) {
        return (List) super.setOauthToken(oauthToken);
      }

      @Override
      public List setPrettyPrint(Boolean prettyPrint) {
        return (List) super.setPrettyPrint(prettyPrint);
      }

      @Override
      public List setQuotaUser(String quotaUser) {
        return (List) super.setQuotaUser(quotaUser);
      }

      @Override
      public List setUserIp(String userIp) {
        return (List) super.setUserIp(userIp);
      }

      @com.google.api.client.util.Key
      private String limit;

      /**

       */
      public String getLimit() {
        return limit;
      }

      public List setLimit(String limit) {
        this.limit = limit;
        return this;
      }

      @com.google.api.client.util.Key
      private String order;

      /**

       */
      public String getOrder() {
        return order;
      }

      public List setOrder(String order) {
        this.order = order;
        return this;
      }

    }

  }

  /**
   * Builder for {@link Tictactoe}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   *
   * @since 1.3.0
   */
  public static final class Builder extends AbstractGoogleJsonClient.Builder {

    /**
     * Returns an instance of a new builder.
     *
     * @param transport HTTP transport
     * @param jsonFactory JSON factory
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Builder(HttpTransport transport, JsonFactory jsonFactory,
        HttpRequestInitializer httpRequestInitializer) {
      super(
          transport,
          jsonFactory,
          DEFAULT_ROOT_URL,
          DEFAULT_SERVICE_PATH,
          httpRequestInitializer,
          false);
    }

    /** Builds a new instance of {@link Tictactoe}. */
    @Override
    public Tictactoe build() {
      return new Tictactoe(getTransport(),
          getHttpRequestInitializer(),
          getRootUrl(),
          getServicePath(),
          getObjectParser(),
          getGoogleClientRequestInitializer(),
          getApplicationName(),
          getSuppressPatternChecks());
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      return (Builder) super.setRootUrl(rootUrl);
    }

    @Override
    public Builder setServicePath(String servicePath) {
      return (Builder) super.setServicePath(servicePath);
    }

    @Override
    public Builder setHttpRequestInitializer(HttpRequestInitializer httpRequestInitializer) {
      return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      return (Builder) super.setApplicationName(applicationName);
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
    }

    /**
     * Set the {@link TictactoeRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setTictactoeRequestInitializer(
        TictactoeRequestInitializer tictactoeRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(tictactoeRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
