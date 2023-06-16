package com.contusfly.di.modules;

import com.contusfly.activities.DashboardActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      ActivityModule_ContributeDashBoardActivity$app_debug.DashboardActivitySubcomponent.class
)
public abstract class ActivityModule_ContributeDashBoardActivity$app_debug {
  private ActivityModule_ContributeDashBoardActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(DashboardActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      DashboardActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface DashboardActivitySubcomponent extends AndroidInjector<DashboardActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<DashboardActivity> {}
  }
}
