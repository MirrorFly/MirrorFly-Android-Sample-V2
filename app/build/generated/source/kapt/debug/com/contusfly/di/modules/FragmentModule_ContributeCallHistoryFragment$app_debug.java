package com.contusfly.di.modules;

import com.contusfly.call.calllog.CallHistoryFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      FragmentModule_ContributeCallHistoryFragment$app_debug.CallHistoryFragmentSubcomponent.class
)
public abstract class FragmentModule_ContributeCallHistoryFragment$app_debug {
  private FragmentModule_ContributeCallHistoryFragment$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(CallHistoryFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      CallHistoryFragmentSubcomponent.Factory builder);

  @Subcomponent
  public interface CallHistoryFragmentSubcomponent extends AndroidInjector<CallHistoryFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<CallHistoryFragment> {}
  }
}
