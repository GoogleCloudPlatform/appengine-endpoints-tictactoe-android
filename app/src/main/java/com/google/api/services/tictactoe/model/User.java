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
 * Warning! This file is generated. Modify at your own risk.
 */

package com.google.api.services.tictactoe.model;

/**
 * Model definition for User.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the tictactoe. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class User extends com.google.api.client.json.GenericJson {

    /**
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private java.lang.String authDomain;

    /**
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private java.lang.String email;

    /**
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private java.lang.String federatedIdentity;

    /**
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private java.lang.String nickname;

    /**
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private java.lang.String userId;

    /**
     * @return value or {@code null} for none
     */
    public java.lang.String getAuthDomain() {
        return authDomain;
    }

    /**
     * @param authDomain authDomain or {@code null} for none
     */
    public User setAuthDomain(java.lang.String authDomain) {
        this.authDomain = authDomain;
        return this;
    }

    /**
     * @return value or {@code null} for none
     */
    public java.lang.String getEmail() {
        return email;
    }

    /**
     * @param email email or {@code null} for none
     */
    public User setEmail(java.lang.String email) {
        this.email = email;
        return this;
    }

    /**
     * @return value or {@code null} for none
     */
    public java.lang.String getFederatedIdentity() {
        return federatedIdentity;
    }

    /**
     * @param federatedIdentity federatedIdentity or {@code null} for none
     */
    public User setFederatedIdentity(java.lang.String federatedIdentity) {
        this.federatedIdentity = federatedIdentity;
        return this;
    }

    /**
     * @return value or {@code null} for none
     */
    public java.lang.String getNickname() {
        return nickname;
    }

    /**
     * @param nickname nickname or {@code null} for none
     */
    public User setNickname(java.lang.String nickname) {
        this.nickname = nickname;
        return this;
    }

    /**
     * @return value or {@code null} for none
     */
    public java.lang.String getUserId() {
        return userId;
    }

    /**
     * @param userId userId or {@code null} for none
     */
    public User setUserId(java.lang.String userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public User set(String fieldName, Object value) {
        return (User) super.set(fieldName, value);
    }

    @Override
    public User clone() {
        return (User) super.clone();
    }

}