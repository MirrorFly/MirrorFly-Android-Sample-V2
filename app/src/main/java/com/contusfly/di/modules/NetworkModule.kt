package com.contusfly.di.modules

import android.content.Context
import com.contusfly.network.UikitRequestTokenInterceptor
import com.contusfly.network.UikitTokenAuthenticator
import com.mirrorflysdk.flycommons.Constants
import com.mirrorflysdk.flynetwork.ApiCalls
import com.mirrorflysdk.flynetwork.BackupApiCalls
import com.mirrorflysdk.BuildConfig
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named

@Module
class NetworkModule {

    //Application instance is provided by BindInstance inside the Builder of the Component

    @Provides
    @Named("baseUrl")
    fun providesBaseUrl(context: Context): String = Constants.getBaseUrl()

    @Provides
    @Named("backup")
    fun providesBaseUrlForBackup(context: Context): String = Constants.getBackupBaseUrl(context)

    @Provides
    fun providesRetrofitBuilder(): Retrofit.Builder = Retrofit.Builder()

    @Provides
    fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @Provides
    fun providesGson(): Gson = GsonBuilder().create()

    @Provides
    fun providesRequestTokenInterceptor(): UikitRequestTokenInterceptor = UikitRequestTokenInterceptor()

    @Provides
    fun providesTokenAuthenticator(): UikitTokenAuthenticator = UikitTokenAuthenticator()

    @Provides
    fun providesNetworkInterceptor(): StethoInterceptor = StethoInterceptor()

    @Provides
    fun providesOkHttpClientBuilder(): OkHttpClient.Builder = OkHttpClient.Builder()

    @Provides
    @Named("auth")
    fun providesOkhttpClientWithAuthentication(okhttpBuilder: OkHttpClient.Builder, stethoInterceptor: StethoInterceptor,
                                               loggingInterceptor: HttpLoggingInterceptor, requestTokenInterceptor: UikitRequestTokenInterceptor,
                                               tokenAuthenticator: UikitTokenAuthenticator): OkHttpClient {
        return okhttpBuilder.addNetworkInterceptor(stethoInterceptor).addInterceptor(requestTokenInterceptor)
                .authenticator(tokenAuthenticator).connectTimeout(15, TimeUnit.SECONDS).readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS).followRedirects(false).build()
    }

    @Provides
    @Named("open")
    fun providesOkhttpClientWithoutAuthentication(okhttpBuilder: OkHttpClient.Builder, stethoInterceptor: StethoInterceptor,
                                                  loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        if (BuildConfig.DEBUG) {
            okhttpBuilder.addInterceptor(loggingInterceptor)
        }
        return okhttpBuilder.addNetworkInterceptor(stethoInterceptor).connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS)
                .followRedirects(false).build()
    }

    @Provides
    @Named("auth")
    fun providesRetrofitWithAuthentication(@Named("baseUrl") baseUrl: String,
                                           @Named("auth") okhttpClient: OkHttpClient, gson: Gson,
                                           retrofitBuilder: Retrofit.Builder): Retrofit {
        return retrofitBuilder
                .baseUrl(baseUrl)
                .client(okhttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
    }

    @Provides
    @Named("open")
    fun providesRetrofitWithoutAuthentication(@Named("baseUrl") baseUrl: String,
                                              @Named("open") okhttpClient: OkHttpClient, gson: Gson,
                                              retrofitBuilder: Retrofit.Builder): Retrofit {
        return retrofitBuilder
                .baseUrl(baseUrl)
                .client(okhttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
    }

    @Provides
    @Named("backup")
    fun providesRetrofitWithAuthenticationForBackup(@Named("backup") baseUrl: String,
                                                    @Named("auth") okhttpClient: OkHttpClient, gson: Gson,
                                                    retrofitBuilder: Retrofit.Builder): Retrofit {
        return retrofitBuilder
                .baseUrl(baseUrl)
                .client(okhttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
    }

    @Provides
    fun providesRApiCallsWithAuthentication(@Named("auth") retrofit: Retrofit): ApiCalls {
        return retrofit.create(ApiCalls::class.java)
    }

    @Provides
    @Named("open")
    fun providesApiCallsWithoutAuthentication(@Named("open") retrofit: Retrofit): ApiCalls {
        return retrofit.create(ApiCalls::class.java)
    }

    @Provides
    fun providesApiCallsWithAuthenticationForBackup(@Named("backup") retrofit: Retrofit): BackupApiCalls {
        return retrofit.create(BackupApiCalls::class.java)
    }


}