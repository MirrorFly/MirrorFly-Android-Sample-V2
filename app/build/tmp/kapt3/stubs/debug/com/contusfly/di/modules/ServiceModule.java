package com.contusfly.di.modules;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\'\u00a8\u0006\u0005"}, d2 = {"Lcom/contusfly/di/modules/ServiceModule;", "", "()V", "contributesMyFirebaseMessagingService", "Lcom/contusfly/MyFirebaseMessagingService;", "app_debug"})
@dagger.Module
public abstract class ServiceModule {
    
    public ServiceModule() {
        super();
    }
    
    /**
     * Here we attach our Services to Dagger Graph
     */
    @org.jetbrains.annotations.NotNull
    @dagger.android.ContributesAndroidInjector
    public abstract com.contusfly.MyFirebaseMessagingService contributesMyFirebaseMessagingService();
}