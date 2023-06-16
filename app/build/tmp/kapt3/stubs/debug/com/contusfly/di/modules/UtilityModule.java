package com.contusfly.di.modules;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nH\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/contusfly/di/modules/UtilityModule;", "", "()V", "provideChatViewUtils", "Lcom/contusfly/utils/ChatViewUtils;", "provideConversationUtils", "Lcom/contusfly/utils/ConversationUtils;", "provideFirebaseUtils", "Lcom/contusfly/utils/FirebaseUtils;", "provideMessagingClient", "Lcom/contusfly/chat/MessagingClient;", "application", "Landroid/app/Application;", "provideShareMessagesController", "Lcom/contusfly/chat/ShareMessagesController;", "messagingClient", "providesSharedPreference", "Lcom/contusfly/utils/SharedPreferenceManager;", "app_debug"})
@dagger.Module()
public final class UtilityModule {
    
    public UtilityModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.contusfly.utils.SharedPreferenceManager providesSharedPreference() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.contusfly.utils.FirebaseUtils provideFirebaseUtils() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.contusfly.chat.MessagingClient provideMessagingClient(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.contusfly.utils.ChatViewUtils provideChatViewUtils() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.contusfly.utils.ConversationUtils provideConversationUtils() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.contusfly.chat.ShareMessagesController provideShareMessagesController(@org.jetbrains.annotations.NotNull()
    com.contusfly.chat.MessagingClient messagingClient) {
        return null;
    }
}