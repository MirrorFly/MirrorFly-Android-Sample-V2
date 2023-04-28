/*
 * @category ContusFly
 * @copyright Copyright (C) 2018 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package com.location.googletranslation;

import com.location.googletranslation.pojo.LanguageDetectionResponse;
import com.location.googletranslation.pojo.ListOfLanguageResponse;
import com.location.googletranslation.pojo.TranslateApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public interface Api {

    @GET("v2")
    Call<TranslateApiResponse> getTranslateApi(@Query("q") String sentence, @Query("target")
            String target, @Query("format") String format, @Query("key") String key);

    @GET("v2/languages")
    Call<ListOfLanguageResponse> getListOfLanguage(@Query("target") String target, @Query("key")
            String key);

    @GET("v2/detect")
    Call<LanguageDetectionResponse> getDetectedLanguage(@Query("q") String text, @Query("key")
            String key);

}
