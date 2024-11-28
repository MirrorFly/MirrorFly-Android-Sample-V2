package com.contusfly.di.modules;

import com.contusfly.activities.SynchronizeContactActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      ActivityModule_ContributeSynchronizeContactActivity$app_debug
          .SynchronizeContactActivitySubcomponent.class
)
public abstract class ActivityModule_ContributeSynchronizeContactActivity$app_debug {
  private ActivityModule_ContributeSynchronizeContactActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(SynchronizeContactActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      SynchronizeContactActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface SynchronizeContactActivitySubcomponent
      extends AndroidInjector<SynchronizeContactActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<SynchronizeContactActivity> {}
  }
}
