package com.contusfly.di.modules

import com.contusfly.MyFirebaseMessagingService
import dagger.Module
import dagger.android.ContributesAndroidInjector
// Dagger requires @Module to be an abstract class, not an interface
@Module
@SuppressWarnings("kotlin:S6526")
abstract class ServiceModule {

    /**
     * Here we attach our Services to Dagger Graph
     */
    @ContributesAndroidInjector
    abstract fun contributesMyFirebaseMessagingService(): MyFirebaseMessagingService

}