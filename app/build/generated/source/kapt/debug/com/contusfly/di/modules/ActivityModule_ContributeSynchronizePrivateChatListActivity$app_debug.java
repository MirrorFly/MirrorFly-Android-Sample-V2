package com.contusfly.di.modules;

import com.contusfly.privateChat.PrivateChatListActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      ActivityModule_ContributeSynchronizePrivateChatListActivity$app_debug
          .PrivateChatListActivitySubcomponent.class
)
public abstract class ActivityModule_ContributeSynchronizePrivateChatListActivity$app_debug {
  private ActivityModule_ContributeSynchronizePrivateChatListActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(PrivateChatListActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      PrivateChatListActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface PrivateChatListActivitySubcomponent
      extends AndroidInjector<PrivateChatListActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<PrivateChatListActivity> {}
  }
}
