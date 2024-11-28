package com.contusfly.di.modules;

import com.contusfly.call.calllog.CallHistoryDetailActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      ActivityModule_ContributeCallHistoryDetailActivity$app_debug
          .CallHistoryDetailActivitySubcomponent.class
)
public abstract class ActivityModule_ContributeCallHistoryDetailActivity$app_debug {
  private ActivityModule_ContributeCallHistoryDetailActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(CallHistoryDetailActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      CallHistoryDetailActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface CallHistoryDetailActivitySubcomponent
      extends AndroidInjector<CallHistoryDetailActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<CallHistoryDetailActivity> {}
  }
}
