package com.contusfly.di.modules;

import com.contusfly.activities.UserListActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      ActivityModule_ContributeUserListActivity$app_debug.UserListActivitySubcomponent.class
)
public abstract class ActivityModule_ContributeUserListActivity$app_debug {
  private ActivityModule_ContributeUserListActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(UserListActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      UserListActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface UserListActivitySubcomponent extends AndroidInjector<UserListActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<UserListActivity> {}
  }
}
