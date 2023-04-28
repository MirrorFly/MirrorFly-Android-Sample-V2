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
public class LanguageDetectionResponse {

    @SerializedName("data")
    private LanguageDetection languageDetection;

    public LanguageDetection getLanguageDetection() {
        return languageDetection;
    }

    public void setLanguageDetection(LanguageDetection languageDetection) {
        this.languageDetection = languageDetection;
    }
}
