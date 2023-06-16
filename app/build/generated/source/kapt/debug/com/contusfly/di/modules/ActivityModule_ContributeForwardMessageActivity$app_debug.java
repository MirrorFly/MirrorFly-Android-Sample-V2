package com.contusfly.di.modules;

import com.contusfly.activities.ForwardMessageActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      ActivityModule_ContributeForwardMessageActivity$app_debug.ForwardMessageActivitySubcomponent
          .class
)
public abstract class ActivityModule_ContributeForwardMessageActivity$app_debug {
  private ActivityModule_ContributeForwardMessageActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(ForwardMessageActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ForwardMessageActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface ForwardMessageActivitySubcomponent
      extends AndroidInjector<ForwardMessageActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<ForwardMessageActivity> {}
  }
}
