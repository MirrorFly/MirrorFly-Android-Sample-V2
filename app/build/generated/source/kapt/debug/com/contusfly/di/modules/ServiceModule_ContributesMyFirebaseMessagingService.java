package com.contusfly.di.modules;

import com.contusfly.MyFirebaseMessagingService;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      ServiceModule_ContributesMyFirebaseMessagingService.MyFirebaseMessagingServiceSubcomponent
          .class
)
public abstract class ServiceModule_ContributesMyFirebaseMessagingService {
  private ServiceModule_ContributesMyFirebaseMessagingService() {}

  @Binds
  @IntoMap
  @ClassKey(MyFirebaseMessagingService.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      MyFirebaseMessagingServiceSubcomponent.Factory builder);

  @Subcomponent
  public interface MyFirebaseMessagingServiceSubcomponent
      extends AndroidInjector<MyFirebaseMessagingService> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<MyFirebaseMessagingService> {}
  }
}
