package com.contusfly.di.modules;

import com.contusfly.activities.EditMessageActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      ActivityModule_ContributeEditMessageActivity$app_debug.EditMessageActivitySubcomponent.class
)
public abstract class ActivityModule_ContributeEditMessageActivity$app_debug {
  private ActivityModule_ContributeEditMessageActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(EditMessageActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      EditMessageActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface EditMessageActivitySubcomponent extends AndroidInjector<EditMessageActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<EditMessageActivity> {}
  }
}
