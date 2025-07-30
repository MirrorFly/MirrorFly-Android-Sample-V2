package com.contusfly.di.modules

import com.contusfly.MyFirebaseMessagingService
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ServiceModule {

    /**
     * Here we attach our Services to Dagger Graph
     */
    @ContributesAndroidInjector
    abstract fun contributesMyFirebaseMessagingService(): MyFirebaseMessagingService

}