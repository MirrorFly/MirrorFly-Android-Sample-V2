package com.contusfly.di.modules;

import com.contusfly.activities.ProfileStartActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      ActivityModule_ContributeProfileStartActivity$app_debug.ProfileStartActivitySubcomponent.class
)
public abstract class ActivityModule_ContributeProfileStartActivity$app_debug {
  private ActivityModule_ContributeProfileStartActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(ProfileStartActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ProfileStartActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface ProfileStartActivitySubcomponent extends AndroidInjector<ProfileStartActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<ProfileStartActivity> {}
  }
}
