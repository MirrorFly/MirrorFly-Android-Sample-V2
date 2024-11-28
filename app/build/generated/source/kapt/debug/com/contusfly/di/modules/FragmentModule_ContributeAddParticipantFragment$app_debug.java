package com.contusfly.di.modules;

import com.contusfly.call.groupcall.AddParticipantFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      FragmentModule_ContributeAddParticipantFragment$app_debug.AddParticipantFragmentSubcomponent
          .class
)
public abstract class FragmentModule_ContributeAddParticipantFragment$app_debug {
  private FragmentModule_ContributeAddParticipantFragment$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(AddParticipantFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      AddParticipantFragmentSubcomponent.Factory builder);

  @Subcomponent
  public interface AddParticipantFragmentSubcomponent
      extends AndroidInjector<AddParticipantFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<AddParticipantFragment> {}
  }
}
