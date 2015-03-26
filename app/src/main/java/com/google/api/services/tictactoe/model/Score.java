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
 * Model definition for Score.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the tictactoe. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class Score extends com.google.api.client.json.GenericJson {

    /**
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key @com.google.api.client.json.JsonString
    private java.lang.Long id;

    /**
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private java.lang.String outcome;

    /**
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private com.google.api.client.util.DateTime played;

    /**
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private User player;

    /**
     * @return value or {@code null} for none
     */
    public java.lang.Long getId() {
        return id;
    }

    /**
     * @param id id or {@code null} for none
     */
    public Score setId(java.lang.Long id) {
        this.id = id;
        return this;
    }

    /**
     * @return value or {@code null} for none
     */
    public java.lang.String getOutcome() {
        return outcome;
    }

    /**
     * @param outcome outcome or {@code null} for none
     */
    public Score setOutcome(java.lang.String outcome) {
        this.outcome = outcome;
        return this;
    }

    /**
     * @return value or {@code null} for none
     */
    public com.google.api.client.util.DateTime getPlayed() {
        return played;
    }

    /**
     * @param played played or {@code null} for none
     */
    public Score setPlayed(com.google.api.client.util.DateTime played) {
        this.played = played;
        return this;
    }

    /**
     * @return value or {@code null} for none
     */
    public User getPlayer() {
        return player;
    }

    /**
     * @param player player or {@code null} for none
     */
    public Score setPlayer(User player) {
        this.player = player;
        return this;
    }

    @Override
    public Score set(String fieldName, Object value) {
        return (Score) super.set(fieldName, value);
    }

    @Override
    public Score clone() {
        return (Score) super.clone();
    }

}
