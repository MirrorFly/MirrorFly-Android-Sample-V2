package com.contusfly.di.modules;

import com.contusfly.activities.SettingsActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      ActivityModule_ContributeSettingsActivity$app_debug.SettingsActivitySubcomponent.class
)
public abstract class ActivityModule_ContributeSettingsActivity$app_debug {
  private ActivityModule_ContributeSettingsActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(SettingsActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      SettingsActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface SettingsActivitySubcomponent extends AndroidInjector<SettingsActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<SettingsActivity> {}
  }
}
