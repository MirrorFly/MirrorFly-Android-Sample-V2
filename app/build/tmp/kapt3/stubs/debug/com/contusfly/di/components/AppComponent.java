package com.contusfly.di.components;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/contusfly/di/components/AppComponent;", "", "inject", "", "instance", "Lcom/contusfly/constants/MobileApplication;", "Builder", "app_debug"})
@dagger.Component(dependencies = {com.mirrorflysdk.di.components.SdkComponent.class}, modules = {dagger.android.AndroidInjectionModule.class, com.contusfly.di.modules.ActivityModule.class, com.contusfly.di.modules.ServiceModule.class, com.contusfly.di.modules.ViewModelModule.class, com.contusfly.di.modules.RepoModule.class, com.contusfly.di.modules.FragmentModule.class, com.contusfly.di.modules.UtilityModule.class})
@javax.inject.Singleton
public abstract interface AppComponent {
    
    public abstract void inject(@org.jetbrains.annotations.NotNull
    com.contusfly.constants.MobileApplication instance);
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H\'J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/contusfly/di/components/AppComponent$Builder;", "", "application", "Landroid/app/Application;", "build", "Lcom/contusfly/di/components/AppComponent;", "sdkComponent", "Lcom/mirrorflysdk/di/components/SdkComponent;", "app_debug"})
    @dagger.Component.Builder
    public static abstract interface Builder {
        
        @org.jetbrains.annotations.NotNull
        @dagger.BindsInstance
        public abstract com.contusfly.di.components.AppComponent.Builder application(@org.jetbrains.annotations.NotNull
        android.app.Application application);
        
        @org.jetbrains.annotations.NotNull
        public abstract com.contusfly.di.components.AppComponent.Builder sdkComponent(@org.jetbrains.annotations.NotNull
        com.mirrorflysdk.di.components.SdkComponent sdkComponent);
        
        @org.jetbrains.annotations.NotNull
        public abstract com.contusfly.di.components.AppComponent build();
    }
}