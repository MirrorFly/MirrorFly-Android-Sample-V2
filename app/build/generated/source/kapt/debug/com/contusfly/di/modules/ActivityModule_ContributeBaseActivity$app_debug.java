package com.contusfly.di.modules;

import com.contusfly.activities.BaseActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents = ActivityModule_ContributeBaseActivity$app_debug.BaseActivitySubcomponent.class
)
public abstract class ActivityModule_ContributeBaseActivity$app_debug {
  private ActivityModule_ContributeBaseActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(BaseActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      BaseActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface BaseActivitySubcomponent extends AndroidInjector<BaseActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<BaseActivity> {}
  }
}
