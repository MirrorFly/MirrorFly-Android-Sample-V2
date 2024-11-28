package com.contusfly.di.modules;

import com.contusfly.chatTag.activities.EditTagActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      ActivityModule_ContributeEditTagActivity$app_debug.EditTagActivitySubcomponent.class
)
public abstract class ActivityModule_ContributeEditTagActivity$app_debug {
  private ActivityModule_ContributeEditTagActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(EditTagActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      EditTagActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface EditTagActivitySubcomponent extends AndroidInjector<EditTagActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<EditTagActivity> {}
  }
}
