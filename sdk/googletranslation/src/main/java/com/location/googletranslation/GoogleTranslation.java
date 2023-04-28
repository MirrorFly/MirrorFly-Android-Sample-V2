/*
 * @category ContusFly
 * @copyright Copyright (C) 2018 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package com.location.googletranslation;

import android.content.Context;

import androidx.annotation.NonNull;

import com.location.googletranslation.pojo.Languages;
import com.location.googletranslation.pojo.ListOfLanguageResponse;
import com.location.googletranslation.pojo.TranslateApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class GoogleTranslation {

    private static GoogleTranslation googleTranslationInstance = null;

    private GoogleTranslationListener listener;

    private GoogleLanguageListListener languageListListener;

    private GoogleTranslation() {

    }

    public static GoogleTranslation getInstance() {
        if (googleTranslationInstance == null) {
            synchronized (GoogleTranslation.class) {
                googleTranslationInstance = new GoogleTranslation();
            }
        }
        return googleTranslationInstance;
    }

    /**
     * This method help to get the translated word or sentence
     *
     * @param context  pass the instance
     * @param sentence pass the word or sentence
     * @param target   pass the targeted language code
     * @param key      pass the google translated key
     * @param listener pass the listener
     */

    public void getTranslatedText(Context context, String sentence, String target,
                                  String key, final GoogleTranslationListener listener) {
        googleTranslationInstance.listener = listener;
        RestClient.getInstance(context).get().getTranslateApi(sentence,
                target, "text", key).enqueue(new Callback<TranslateApiResponse>() {

            @Override
            public void onResponse(@NonNull Call<TranslateApiResponse> call,
                                   @NonNull Response<TranslateApiResponse> response) {
                if (response.body() != null && response.body().getData() != null) {
                    listener.onSuccess(response.body().getData().getTranslations().get(0)
                            .getTranslatedText());
                } else {
                    switch (response.code()) {
                        case 400:
                            listener.onFailed("Can't be translated");
                            break;
                        case 500:
                            listener.onFailed("server broken");
                            break;
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<TranslateApiResponse> call, @NonNull Throwable t) {
                listener.onFailed(t.getMessage());
            }
        });
    }

    /**
     * This method help to get the google supported language list
     * @param context pass the instance
     * @param targetLanguage pass the targeted language code
     * @param key pass the google translated key
     * @param listener pass the listener
     */
    public void getLanguageList(Context context, String targetLanguage, String key,
                                GoogleLanguageListListener listener) {
        googleTranslationInstance.languageListListener = listener;
        RestClient.getInstance(context).get().getListOfLanguage(targetLanguage, key).
                enqueue(new Callback<ListOfLanguageResponse>() {
                    @Override
                    public void
                    onResponse
                            (@NonNull Call<ListOfLanguageResponse> call, @NonNull
                                    Response<ListOfLanguageResponse> response) {
                        if (response.body() != null) {

                            languageListListener.onSuccess(response.body().getData().getLanguages());
                        } else {
                            switch (response.code()) {
                                case 400:
                                    languageListListener.onFailed("Can't be translate");
                                    break;
                                case 500:
                                    languageListListener.onFailed("server broken");
                                    break;
                            }
                        }
                    }

                    @Override
                    public void
                    onFailure
                            (@NonNull Call<ListOfLanguageResponse> call, @NonNull Throwable
                                    t) {
                        languageListListener.onFailed(t.getMessage());
                    }
                });
    }

    /**
     * The interface that has the callback methods to be called after the Retrofit was called
     */
    public interface GoogleTranslationListener {

        /**
         * This method will be called once the API was successfully hit.
         *
         * @param TranslatedText pass the translated text.
         */
        void onSuccess(String TranslatedText);

        /**
         * This method will be called in case of any errors during compression.
         *
         * @param failedReason pass the failure reason.
         */
        void onFailed(String failedReason);
    }

    /**
     * The interface that has the callback methods to be called after the Retrofit was called
     */
    public interface GoogleLanguageListListener {

        /**
         * This method will be called once the API was successfully hit.
         *
         * @param listOfLanguage  void onSuccess(Languages listOfLanguage); The path of the compressed image.
         */
        void onSuccess(List<Languages> listOfLanguage);

        /**
         * This method will be called once the API was failed to hit.
         *
         * @param failedReason The id of the task that failed.
         */
        void onFailed(String failedReason);
    }

}
