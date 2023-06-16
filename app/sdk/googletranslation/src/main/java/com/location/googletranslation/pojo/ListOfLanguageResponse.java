/*
 * @category ContusFly
 * @copyright Copyright (C) 2018 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.location.googletranslation.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class ListOfLanguageResponse {

    @SerializedName("data")
    private ListOfLanguageData data;

    public ListOfLanguageData getData() {
        return data;
    }

    public void setData(ListOfLanguageData data) {
        this.data = data;
    }
}
