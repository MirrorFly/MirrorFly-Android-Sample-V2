package com.contusfly.di.modules;

import com.contusfly.chatTag.activities.ChatTagActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      ActivityModule_ContributeChatTagActivity$app_debug.ChatTagActivitySubcomponent.class
)
public abstract class ActivityModule_ContributeChatTagActivity$app_debug {
  private ActivityModule_ContributeChatTagActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(ChatTagActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ChatTagActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface ChatTagActivitySubcomponent extends AndroidInjector<ChatTagActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<ChatTagActivity> {}
  }
}
