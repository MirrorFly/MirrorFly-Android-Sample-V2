package com.contusfly.di.modules;

import com.contusfly.activities.NewContactsActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      ActivityModule_ContributeNewContactsActivity$app_debug.NewContactsActivitySubcomponent.class
)
public abstract class ActivityModule_ContributeNewContactsActivity$app_debug {
  private ActivityModule_ContributeNewContactsActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(NewContactsActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      NewContactsActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface NewContactsActivitySubcomponent extends AndroidInjector<NewContactsActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<NewContactsActivity> {}
  }
}
