package com.contusfly.network


import com.google.gson.GsonBuilder
import com.mirrorflysdk.flycommons.Constants
import com.mirrorflysdk.flycommons.SharedPreferenceManager
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
object RetrofitClientNetwork {

    val retrofit: UiApiCalls by lazy {
        val builder = OkHttpClient.Builder()
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val client: OkHttpClient = builder
                .addInterceptor(logging)
                .addInterceptor(UikitRequestTokenInterceptor())
                .authenticator(UikitTokenAuthenticator())
                .followRedirects(false)
                .build()
        val gson = GsonBuilder().create()



        Retrofit.Builder()
                .baseUrl(SharedPreferenceManager.instance.getString(Constants.BASE_URL))
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(UiApiCalls::class.java)
    }
}