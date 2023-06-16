package com.contusfly.di.modules;

import com.contusfly.call.groupcall.ParticipantsListFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      FragmentModule_ContributeParticipantsListFragment$app_debug
          .ParticipantsListFragmentSubcomponent.class
)
public abstract class FragmentModule_ContributeParticipantsListFragment$app_debug {
  private FragmentModule_ContributeParticipantsListFragment$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(ParticipantsListFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ParticipantsListFragmentSubcomponent.Factory builder);

  @Subcomponent
  public interface ParticipantsListFragmentSubcomponent
      extends AndroidInjector<ParticipantsListFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<ParticipantsListFragment> {}
  }
}
