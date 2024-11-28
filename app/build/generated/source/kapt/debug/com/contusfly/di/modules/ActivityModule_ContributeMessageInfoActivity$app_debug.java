package com.contusfly.di.modules;

import com.contusfly.activities.MessageInfoActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      ActivityModule_ContributeMessageInfoActivity$app_debug.MessageInfoActivitySubcomponent.class
)
public abstract class ActivityModule_ContributeMessageInfoActivity$app_debug {
  private ActivityModule_ContributeMessageInfoActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(MessageInfoActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      MessageInfoActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface MessageInfoActivitySubcomponent extends AndroidInjector<MessageInfoActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<MessageInfoActivity> {}
  }
}
