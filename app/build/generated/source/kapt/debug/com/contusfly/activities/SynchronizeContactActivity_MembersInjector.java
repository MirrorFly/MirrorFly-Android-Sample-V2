// Generated by Dagger (https://dagger.dev).
package com.contusfly.activities;

import com.contusfly.di.factory.AppViewModelFactory;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class SynchronizeContactActivity_MembersInjector implements MembersInjector<SynchronizeContactActivity> {
  private final Provider<AppViewModelFactory> callLogsViewModelFactoryProvider;

  public SynchronizeContactActivity_MembersInjector(
      Provider<AppViewModelFactory> callLogsViewModelFactoryProvider) {
    this.callLogsViewModelFactoryProvider = callLogsViewModelFactoryProvider;
  }

  public static MembersInjector<SynchronizeContactActivity> create(
      Provider<AppViewModelFactory> callLogsViewModelFactoryProvider) {
    return new SynchronizeContactActivity_MembersInjector(callLogsViewModelFactoryProvider);
  }

  @Override
  public void injectMembers(SynchronizeContactActivity instance) {
    injectCallLogsViewModelFactory(instance, callLogsViewModelFactoryProvider.get());
  }

  @InjectedFieldSignature("com.contusfly.activities.SynchronizeContactActivity.callLogsViewModelFactory")
  public static void injectCallLogsViewModelFactory(SynchronizeContactActivity instance,
      AppViewModelFactory callLogsViewModelFactory) {
    instance.callLogsViewModelFactory = callLogsViewModelFactory;
  }
}