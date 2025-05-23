// Generated by Dagger (https://dagger.dev).
package com.contusfly.di.modules;

import com.mirrorflysdk.flynetwork.BackupApiCalls;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class NetworkModule_ProvidesApiCallsWithAuthenticationForBackupFactory implements Factory<BackupApiCalls> {
  private final NetworkModule module;

  private final Provider<Retrofit> retrofitProvider;

  public NetworkModule_ProvidesApiCallsWithAuthenticationForBackupFactory(NetworkModule module,
      Provider<Retrofit> retrofitProvider) {
    this.module = module;
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public BackupApiCalls get() {
    return providesApiCallsWithAuthenticationForBackup(module, retrofitProvider.get());
  }

  public static NetworkModule_ProvidesApiCallsWithAuthenticationForBackupFactory create(
      NetworkModule module, Provider<Retrofit> retrofitProvider) {
    return new NetworkModule_ProvidesApiCallsWithAuthenticationForBackupFactory(module, retrofitProvider);
  }

  public static BackupApiCalls providesApiCallsWithAuthenticationForBackup(NetworkModule instance,
      Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(instance.providesApiCallsWithAuthenticationForBackup(retrofit));
  }
}
