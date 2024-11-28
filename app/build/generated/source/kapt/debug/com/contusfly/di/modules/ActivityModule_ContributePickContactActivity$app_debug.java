package com.contusfly.di.modules;

import com.contusfly.activities.PickContactActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      ActivityModule_ContributePickContactActivity$app_debug.PickContactActivitySubcomponent.class
)
public abstract class ActivityModule_ContributePickContactActivity$app_debug {
  private ActivityModule_ContributePickContactActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(PickContactActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      PickContactActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface PickContactActivitySubcomponent extends AndroidInjector<PickContactActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<PickContactActivity> {}
  }
}
