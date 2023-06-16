package com.contusfly.di.modules;

import com.contusfly.fragments.ChatsFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents = FragmentModule_ContributeChatsFragment$app_debug.ChatsFragmentSubcomponent.class
)
public abstract class FragmentModule_ContributeChatsFragment$app_debug {
  private FragmentModule_ContributeChatsFragment$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(ChatsFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ChatsFragmentSubcomponent.Factory builder);

  @Subcomponent
  public interface ChatsFragmentSubcomponent extends AndroidInjector<ChatsFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<ChatsFragment> {}
  }
}
