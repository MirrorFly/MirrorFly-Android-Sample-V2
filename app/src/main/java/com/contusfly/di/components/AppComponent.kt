package com.contusfly.di.components

import android.app.Application
import com.contusfly.constants.MobileApplication
import com.contusfly.di.modules.*
import com.mirrorflysdk.di.components.SdkComponent
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(dependencies = [SdkComponent::class], modules = [(AndroidInjectionModule::class),
    (ActivityModule::class),
    (ServiceModule::class),
    (ViewModelModule::class),
    (RepoModule::class),
    (FragmentModule::class),
    (UtilityModule::class)])
fun interface AppComponent {

    // Create an instance of the Component
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun sdkComponent(sdkComponent: SdkComponent): Builder
        fun build(): AppComponent
    }

    fun inject(instance: MobileApplication)

}