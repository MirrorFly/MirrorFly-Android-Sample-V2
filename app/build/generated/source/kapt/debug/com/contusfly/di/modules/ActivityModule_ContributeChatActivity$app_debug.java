package com.contusfly.di.modules;

import com.contusfly.activities.ChatActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents = ActivityModule_ContributeChatActivity$app_debug.ChatActivitySubcomponent.class
)
public abstract class ActivityModule_ContributeChatActivity$app_debug {
  private ActivityModule_ContributeChatActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(ChatActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ChatActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface ChatActivitySubcomponent extends AndroidInjector<ChatActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<ChatActivity> {}
  }
}
