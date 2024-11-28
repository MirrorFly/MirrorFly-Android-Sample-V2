package com.contusfly.di.modules;

import com.contusfly.activities.MediaPreviewActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      ActivityModule_ContributeMediaPreviewActivity$app_debug.MediaPreviewActivitySubcomponent.class
)
public abstract class ActivityModule_ContributeMediaPreviewActivity$app_debug {
  private ActivityModule_ContributeMediaPreviewActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(MediaPreviewActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      MediaPreviewActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface MediaPreviewActivitySubcomponent extends AndroidInjector<MediaPreviewActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<MediaPreviewActivity> {}
  }
}
