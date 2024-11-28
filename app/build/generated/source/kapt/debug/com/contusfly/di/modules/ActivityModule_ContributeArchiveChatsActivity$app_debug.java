package com.contusfly.di.modules;

import com.contusfly.activities.ArchivedChatsActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      ActivityModule_ContributeArchiveChatsActivity$app_debug.ArchivedChatsActivitySubcomponent
          .class
)
public abstract class ActivityModule_ContributeArchiveChatsActivity$app_debug {
  private ActivityModule_ContributeArchiveChatsActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(ArchivedChatsActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ArchivedChatsActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface ArchivedChatsActivitySubcomponent
      extends AndroidInjector<ArchivedChatsActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<ArchivedChatsActivity> {}
  }
}
