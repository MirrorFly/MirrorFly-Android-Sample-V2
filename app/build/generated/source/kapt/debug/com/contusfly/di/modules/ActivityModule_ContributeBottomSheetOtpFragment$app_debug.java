package com.contusfly.di.modules;

import com.contusfly.fragments.BottomSheetOtpFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      ActivityModule_ContributeBottomSheetOtpFragment$app_debug.BottomSheetOtpFragmentSubcomponent
          .class
)
public abstract class ActivityModule_ContributeBottomSheetOtpFragment$app_debug {
  private ActivityModule_ContributeBottomSheetOtpFragment$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(BottomSheetOtpFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      BottomSheetOtpFragmentSubcomponent.Factory builder);

  @Subcomponent
  public interface BottomSheetOtpFragmentSubcomponent
      extends AndroidInjector<BottomSheetOtpFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<BottomSheetOtpFragment> {}
  }
}
