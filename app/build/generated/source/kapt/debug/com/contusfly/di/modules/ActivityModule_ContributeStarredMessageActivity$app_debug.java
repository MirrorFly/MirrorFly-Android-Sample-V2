package com.contusfly.di.modules;

import com.contusfly.activities.StarredMessageActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      ActivityModule_ContributeStarredMessageActivity$app_debug.StarredMessageActivitySubcomponent
          .class
)
public abstract class ActivityModule_ContributeStarredMessageActivity$app_debug {
  private ActivityModule_ContributeStarredMessageActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(StarredMessageActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      StarredMessageActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface StarredMessageActivitySubcomponent
      extends AndroidInjector<StarredMessageActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<StarredMessageActivity> {}
  }
}
