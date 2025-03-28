// Generated by Dagger (https://dagger.dev).
package com.contusfly.activities;

import com.mirrorflysdk.flynetwork.ApiCalls;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class PinActivity_MembersInjector implements MembersInjector<PinActivity> {
  private final Provider<ApiCalls> apiCallsProvider;

  public PinActivity_MembersInjector(Provider<ApiCalls> apiCallsProvider) {
    this.apiCallsProvider = apiCallsProvider;
  }

  public static MembersInjector<PinActivity> create(Provider<ApiCalls> apiCallsProvider) {
    return new PinActivity_MembersInjector(apiCallsProvider);
  }

  @Override
  public void injectMembers(PinActivity instance) {
    injectApiCalls(instance, apiCallsProvider.get());
  }

  @InjectedFieldSignature("com.contusfly.activities.PinActivity.apiCalls")
  public static void injectApiCalls(PinActivity instance, ApiCalls apiCalls) {
    instance.apiCalls = apiCalls;
  }
}
