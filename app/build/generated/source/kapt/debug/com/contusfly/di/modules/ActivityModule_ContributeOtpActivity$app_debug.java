package com.contusfly.di.modules;

import com.contusfly.activities.OtpActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents = ActivityModule_ContributeOtpActivity$app_debug.OtpActivitySubcomponent.class
)
public abstract class ActivityModule_ContributeOtpActivity$app_debug {
  private ActivityModule_ContributeOtpActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(OtpActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      OtpActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface OtpActivitySubcomponent extends AndroidInjector<OtpActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<OtpActivity> {}
  }
}
