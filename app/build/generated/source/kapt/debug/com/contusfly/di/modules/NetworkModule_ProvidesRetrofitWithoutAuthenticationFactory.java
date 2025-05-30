// Generated by Dagger (https://dagger.dev).
package com.contusfly.di.modules;

import com.google.gson.Gson;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class NetworkModule_ProvidesRetrofitWithoutAuthenticationFactory implements Factory<Retrofit> {
  private final NetworkModule module;

  private final Provider<String> baseUrlProvider;

  private final Provider<OkHttpClient> okhttpClientProvider;

  private final Provider<Gson> gsonProvider;

  private final Provider<Retrofit.Builder> retrofitBuilderProvider;

  public NetworkModule_ProvidesRetrofitWithoutAuthenticationFactory(NetworkModule module,
      Provider<String> baseUrlProvider, Provider<OkHttpClient> okhttpClientProvider,
      Provider<Gson> gsonProvider, Provider<Retrofit.Builder> retrofitBuilderProvider) {
    this.module = module;
    this.baseUrlProvider = baseUrlProvider;
    this.okhttpClientProvider = okhttpClientProvider;
    this.gsonProvider = gsonProvider;
    this.retrofitBuilderProvider = retrofitBuilderProvider;
  }

  @Override
  public Retrofit get() {
    return providesRetrofitWithoutAuthentication(module, baseUrlProvider.get(), okhttpClientProvider.get(), gsonProvider.get(), retrofitBuilderProvider.get());
  }

  public static NetworkModule_ProvidesRetrofitWithoutAuthenticationFactory create(
      NetworkModule module, Provider<String> baseUrlProvider,
      Provider<OkHttpClient> okhttpClientProvider, Provider<Gson> gsonProvider,
      Provider<Retrofit.Builder> retrofitBuilderProvider) {
    return new NetworkModule_ProvidesRetrofitWithoutAuthenticationFactory(module, baseUrlProvider, okhttpClientProvider, gsonProvider, retrofitBuilderProvider);
  }

  public static Retrofit providesRetrofitWithoutAuthentication(NetworkModule instance,
      String baseUrl, OkHttpClient okhttpClient, Gson gson, Retrofit.Builder retrofitBuilder) {
    return Preconditions.checkNotNullFromProvides(instance.providesRetrofitWithoutAuthentication(baseUrl, okhttpClient, gson, retrofitBuilder));
  }
}
