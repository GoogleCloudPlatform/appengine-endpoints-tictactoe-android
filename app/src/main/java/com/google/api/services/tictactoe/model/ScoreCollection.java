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
 * Model definition for ScoreCollection.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the tictactoe. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class ScoreCollection extends com.google.api.client.json.GenericJson {

    /**
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private java.util.List<Score> items;

    /**
     * @return value or {@code null} for none
     */
    public java.util.List<Score> getItems() {
        return items;
    }

    /**
     * @param items items or {@code null} for none
     */
    public ScoreCollection setItems(java.util.List<Score> items) {
        this.items = items;
        return this;
    }

    @Override
    public ScoreCollection set(String fieldName, Object value) {
        return (ScoreCollection) super.set(fieldName, value);
    }

    @Override
    public ScoreCollection clone() {
        return (ScoreCollection) super.clone();
    }

}