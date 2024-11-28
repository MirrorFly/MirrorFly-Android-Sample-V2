package com.contusfly.di.modules;

import com.contusfly.activities.ImagePreviewActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      ActivityModule_ContributeImagePreviewActivity$app_debug.ImagePreviewActivitySubcomponent.class
)
public abstract class ActivityModule_ContributeImagePreviewActivity$app_debug {
  private ActivityModule_ContributeImagePreviewActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(ImagePreviewActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ImagePreviewActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface ImagePreviewActivitySubcomponent extends AndroidInjector<ImagePreviewActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<ImagePreviewActivity> {}
  }
}
