package com.contusfly.di.modules;

import com.contusfly.activities.ContactSelectionActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      ActivityModule_ContributeContactSelectionActivity$app_debug
          .ContactSelectionActivitySubcomponent.class
)
public abstract class ActivityModule_ContributeContactSelectionActivity$app_debug {
  private ActivityModule_ContributeContactSelectionActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(ContactSelectionActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ContactSelectionActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface ContactSelectionActivitySubcomponent
      extends AndroidInjector<ContactSelectionActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<ContactSelectionActivity> {}
  }
}
