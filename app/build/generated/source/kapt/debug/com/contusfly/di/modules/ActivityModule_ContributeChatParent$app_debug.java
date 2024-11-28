package com.contusfly.di.modules;

import com.contusfly.activities.parent.ChatParent;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = ActivityModule_ContributeChatParent$app_debug.ChatParentSubcomponent.class)
public abstract class ActivityModule_ContributeChatParent$app_debug {
  private ActivityModule_ContributeChatParent$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(ChatParent.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ChatParentSubcomponent.Factory builder);

  @Subcomponent
  public interface ChatParentSubcomponent extends AndroidInjector<ChatParent> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<ChatParent> {}
  }
}
