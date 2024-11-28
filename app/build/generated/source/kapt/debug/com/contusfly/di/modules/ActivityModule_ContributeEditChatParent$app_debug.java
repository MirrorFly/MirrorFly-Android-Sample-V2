package com.contusfly.di.modules;

import com.contusfly.activities.parent.EditChatParent;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents = ActivityModule_ContributeEditChatParent$app_debug.EditChatParentSubcomponent.class
)
public abstract class ActivityModule_ContributeEditChatParent$app_debug {
  private ActivityModule_ContributeEditChatParent$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(EditChatParent.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      EditChatParentSubcomponent.Factory builder);

  @Subcomponent
  public interface EditChatParentSubcomponent extends AndroidInjector<EditChatParent> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<EditChatParent> {}
  }
}
