package com.contusfly.di.modules;

import com.contusfly.quickShare.QuickShareActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      ActivityModule_ContributeQuickShareActivity$app_debug.QuickShareActivitySubcomponent.class
)
public abstract class ActivityModule_ContributeQuickShareActivity$app_debug {
  private ActivityModule_ContributeQuickShareActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(QuickShareActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      QuickShareActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface QuickShareActivitySubcomponent extends AndroidInjector<QuickShareActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<QuickShareActivity> {}
  }
}
