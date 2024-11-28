package com.contusfly.di.modules;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0007J0\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J \u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0011H\u0007J\u0012\u0010 \u001a\u00020\b2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010!\u001a\u00020\u001cH\u0007J\b\u0010\"\u001a\u00020#H\u0007J,\u0010$\u001a\u00020\u00062\b\b\u0001\u0010%\u001a\u00020\n2\b\b\u0001\u0010&\u001a\u00020\u00172\u0006\u0010\'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020#H\u0007J,\u0010)\u001a\u00020\u00062\b\b\u0001\u0010%\u001a\u00020\n2\b\b\u0001\u0010&\u001a\u00020\u00172\u0006\u0010\'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020#H\u0007J,\u0010*\u001a\u00020\u00062\b\b\u0001\u0010%\u001a\u00020\n2\b\b\u0001\u0010&\u001a\u00020\u00172\u0006\u0010\'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020#H\u0007J\b\u0010+\u001a\u00020\u001eH\u0007\u00a8\u0006,"}, d2 = {"Lcom/contusfly/di/modules/NetworkModule;", "", "()V", "providesApiCallsWithAuthenticationForBackup", "Lcom/mirrorflysdk/flynetwork/BackupApiCalls;", "retrofit", "Lretrofit2/Retrofit;", "providesApiCallsWithoutAuthentication", "Lcom/mirrorflysdk/flynetwork/ApiCalls;", "providesBaseUrl", "", "context", "Landroid/content/Context;", "providesBaseUrlForBackup", "providesGson", "Lcom/google/gson/Gson;", "providesHttpLoggingInterceptor", "Lokhttp3/logging/HttpLoggingInterceptor;", "providesNetworkInterceptor", "Lcom/facebook/stetho/okhttp3/StethoInterceptor;", "providesOkHttpClientBuilder", "Lokhttp3/OkHttpClient$Builder;", "providesOkhttpClientWithAuthentication", "Lokhttp3/OkHttpClient;", "okhttpBuilder", "stethoInterceptor", "loggingInterceptor", "requestTokenInterceptor", "Lcom/contusfly/network/UikitRequestTokenInterceptor;", "tokenAuthenticator", "Lcom/contusfly/network/UikitTokenAuthenticator;", "providesOkhttpClientWithoutAuthentication", "providesRApiCallsWithAuthentication", "providesRequestTokenInterceptor", "providesRetrofitBuilder", "Lretrofit2/Retrofit$Builder;", "providesRetrofitWithAuthentication", "baseUrl", "okhttpClient", "gson", "retrofitBuilder", "providesRetrofitWithAuthenticationForBackup", "providesRetrofitWithoutAuthentication", "providesTokenAuthenticator", "app_debug"})
@dagger.Module
public final class NetworkModule {
    
    public NetworkModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Named(value = "baseUrl")
    @dagger.Provides
    public final java.lang.String providesBaseUrl(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Named(value = "backup")
    @dagger.Provides
    public final java.lang.String providesBaseUrlForBackup(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final retrofit2.Retrofit.Builder providesRetrofitBuilder() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final okhttp3.logging.HttpLoggingInterceptor providesHttpLoggingInterceptor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final com.google.gson.Gson providesGson() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final com.contusfly.network.UikitRequestTokenInterceptor providesRequestTokenInterceptor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final com.contusfly.network.UikitTokenAuthenticator providesTokenAuthenticator() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final com.facebook.stetho.okhttp3.StethoInterceptor providesNetworkInterceptor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final okhttp3.OkHttpClient.Builder providesOkHttpClientBuilder() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Named(value = "auth")
    @dagger.Provides
    public final okhttp3.OkHttpClient providesOkhttpClientWithAuthentication(@org.jetbrains.annotations.NotNull
    okhttp3.OkHttpClient.Builder okhttpBuilder, @org.jetbrains.annotations.NotNull
    com.facebook.stetho.okhttp3.StethoInterceptor stethoInterceptor, @org.jetbrains.annotations.NotNull
    okhttp3.logging.HttpLoggingInterceptor loggingInterceptor, @org.jetbrains.annotations.NotNull
    com.contusfly.network.UikitRequestTokenInterceptor requestTokenInterceptor, @org.jetbrains.annotations.NotNull
    com.contusfly.network.UikitTokenAuthenticator tokenAuthenticator) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Named(value = "open")
    @dagger.Provides
    public final okhttp3.OkHttpClient providesOkhttpClientWithoutAuthentication(@org.jetbrains.annotations.NotNull
    okhttp3.OkHttpClient.Builder okhttpBuilder, @org.jetbrains.annotations.NotNull
    com.facebook.stetho.okhttp3.StethoInterceptor stethoInterceptor, @org.jetbrains.annotations.NotNull
    okhttp3.logging.HttpLoggingInterceptor loggingInterceptor) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Named(value = "auth")
    @dagger.Provides
    public final retrofit2.Retrofit providesRetrofitWithAuthentication(@org.jetbrains.annotations.NotNull
    @javax.inject.Named(value = "baseUrl")
    java.lang.String baseUrl, @org.jetbrains.annotations.NotNull
    @javax.inject.Named(value = "auth")
    okhttp3.OkHttpClient okhttpClient, @org.jetbrains.annotations.NotNull
    com.google.gson.Gson gson, @org.jetbrains.annotations.NotNull
    retrofit2.Retrofit.Builder retrofitBuilder) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Named(value = "open")
    @dagger.Provides
    public final retrofit2.Retrofit providesRetrofitWithoutAuthentication(@org.jetbrains.annotations.NotNull
    @javax.inject.Named(value = "baseUrl")
    java.lang.String baseUrl, @org.jetbrains.annotations.NotNull
    @javax.inject.Named(value = "open")
    okhttp3.OkHttpClient okhttpClient, @org.jetbrains.annotations.NotNull
    com.google.gson.Gson gson, @org.jetbrains.annotations.NotNull
    retrofit2.Retrofit.Builder retrofitBuilder) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Named(value = "backup")
    @dagger.Provides
    public final retrofit2.Retrofit providesRetrofitWithAuthenticationForBackup(@org.jetbrains.annotations.NotNull
    @javax.inject.Named(value = "backup")
    java.lang.String baseUrl, @org.jetbrains.annotations.NotNull
    @javax.inject.Named(value = "auth")
    okhttp3.OkHttpClient okhttpClient, @org.jetbrains.annotations.NotNull
    com.google.gson.Gson gson, @org.jetbrains.annotations.NotNull
    retrofit2.Retrofit.Builder retrofitBuilder) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final com.mirrorflysdk.flynetwork.ApiCalls providesRApiCallsWithAuthentication(@org.jetbrains.annotations.NotNull
    @javax.inject.Named(value = "auth")
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Named(value = "open")
    @dagger.Provides
    public final com.mirrorflysdk.flynetwork.ApiCalls providesApiCallsWithoutAuthentication(@org.jetbrains.annotations.NotNull
    @javax.inject.Named(value = "open")
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final com.mirrorflysdk.flynetwork.BackupApiCalls providesApiCallsWithAuthenticationForBackup(@org.jetbrains.annotations.NotNull
    @javax.inject.Named(value = "backup")
    retrofit2.Retrofit retrofit) {
        return null;
    }
}