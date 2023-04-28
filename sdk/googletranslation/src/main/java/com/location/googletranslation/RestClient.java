/*
 * @category ContusFly
 * @copyright Copyright (C) 2018 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.location.googletranslation;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class RestClient {

    /**
     * The reference to Api class to load the api urls as per the request
     */
    private static Api api;

    /**
     * Context of the activity
     */
    private static Context mContext;

    /**
     * Set up the rest client
     */
    private static RestClient restClient;

    /**
     * Retrofit instance
     */
    private static Retrofit retrofit;

    /**
     * The rest client parametrized constructor used to initialize the class
     *
     * @param context The context of the activity
     */
    private RestClient(Context context) {
        mContext = context;
        setupRestClient();
    }

    /**
     * To build the client and converter to rest adapter.
     */
    private static void setupRestClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = builder
                // .addInterceptor(new SessionRequestInterceptor(mContext))
                .addInterceptor(logging)
                .followRedirects(false)
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(20, TimeUnit.SECONDS).build();

        //The Gson Builder which converts the json response into objects and classes
        Gson gson = new GsonBuilder().create();

        //The rest adapter which is used to build the base url
        retrofit = new Retrofit.Builder()
                .baseUrl(ServerUrls.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        api = retrofit.create(Api.class);
    }

    /**
     * Returns a new instance of this rest client.
     *
     * @param context Instance of the class
     * @return rest client
     */
    public static RestClient getInstance(Context context) {
        if (restClient == null) {
            restClient = new RestClient(context);
        }
        return restClient;
    }

    /**
     * Returns the api interface.
     *
     * @return api
     */
    public Api get() {
        return api;
    }

}