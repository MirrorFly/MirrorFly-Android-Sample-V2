package com.contusfly.di.modules;

import com.contusfly.activities.PinActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents = ActivityModule_ContributePinActivity$app_debug.PinActivitySubcomponent.class
)
public abstract class ActivityModule_ContributePinActivity$app_debug {
  private ActivityModule_ContributePinActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(PinActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      PinActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface PinActivitySubcomponent extends AndroidInjector<PinActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<PinActivity> {}
  }
}
