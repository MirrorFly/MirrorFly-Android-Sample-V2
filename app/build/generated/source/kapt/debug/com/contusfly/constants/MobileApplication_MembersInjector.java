// Generated by Dagger (https://dagger.dev).
package com.contusfly.constants;

import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class MobileApplication_MembersInjector implements MembersInjector<MobileApplication> {
  private final Provider<DispatchingAndroidInjector<Object>> activityInjectorProvider;

  public MobileApplication_MembersInjector(
      Provider<DispatchingAndroidInjector<Object>> activityInjectorProvider) {
    this.activityInjectorProvider = activityInjectorProvider;
  }

  public static MembersInjector<MobileApplication> create(
      Provider<DispatchingAndroidInjector<Object>> activityInjectorProvider) {
    return new MobileApplication_MembersInjector(activityInjectorProvider);
  }

  @Override
  public void injectMembers(MobileApplication instance) {
    injectActivityInjector(instance, activityInjectorProvider.get());
  }

  @InjectedFieldSignature("com.contusfly.constants.MobileApplication.activityInjector")
  public static void injectActivityInjector(MobileApplication instance,
      DispatchingAndroidInjector<Object> activityInjector) {
    instance.activityInjector = activityInjector;
  }
}