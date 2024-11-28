package com.contusfly.di.modules;

import com.contusfly.fragments.RecentChatListFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      FragmentModule_ContributeRecentChatListFragment$app_debug.RecentChatListFragmentSubcomponent
          .class
)
public abstract class FragmentModule_ContributeRecentChatListFragment$app_debug {
  private FragmentModule_ContributeRecentChatListFragment$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(RecentChatListFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      RecentChatListFragmentSubcomponent.Factory builder);

  @Subcomponent
  public interface RecentChatListFragmentSubcomponent
      extends AndroidInjector<RecentChatListFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<RecentChatListFragment> {}
  }
}
