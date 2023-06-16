package com.contusfly.di.modules;

import com.contusfly.fragments.BlockedContactsFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      FragmentModule_ContributeBlockedContactsFragment$app_debug.BlockedContactsFragmentSubcomponent
          .class
)
public abstract class FragmentModule_ContributeBlockedContactsFragment$app_debug {
  private FragmentModule_ContributeBlockedContactsFragment$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(BlockedContactsFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      BlockedContactsFragmentSubcomponent.Factory builder);

  @Subcomponent
  public interface BlockedContactsFragmentSubcomponent
      extends AndroidInjector<BlockedContactsFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<BlockedContactsFragment> {}
  }
}
