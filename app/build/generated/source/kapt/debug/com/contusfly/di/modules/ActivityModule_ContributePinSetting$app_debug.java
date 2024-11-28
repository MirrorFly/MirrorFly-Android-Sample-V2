package com.contusfly.di.modules;

import com.contusfly.activities.PinSetting;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = ActivityModule_ContributePinSetting$app_debug.PinSettingSubcomponent.class)
public abstract class ActivityModule_ContributePinSetting$app_debug {
  private ActivityModule_ContributePinSetting$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(PinSetting.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      PinSettingSubcomponent.Factory builder);

  @Subcomponent
  public interface PinSettingSubcomponent extends AndroidInjector<PinSetting> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<PinSetting> {}
  }
}
