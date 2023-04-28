package com.contusfly.di.modules

import android.app.Application
import com.contusfly.chat.MessagingClient
import com.contusfly.chat.ShareMessagesController
import com.contusfly.utils.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UtilityModule {

    //Application instance is provided by BindInstance inside the Builder of the Component

    @Provides
    @Singleton
    fun providesSharedPreference(): SharedPreferenceManager {
        return SharedPreferenceManager
    }

    @Provides
    @Singleton
    fun provideFirebaseUtils(): FirebaseUtils {
        return FirebaseUtils()
    }

    @Provides
    @Singleton
    fun provideMessagingClient(application: Application): MessagingClient {
        return MessagingClient(application)
    }

    @Provides
    @Singleton
    fun provideChatViewUtils(): ChatViewUtils {
        return ChatViewUtils()
    }

    @Provides
    @Singleton
    fun provideConversationUtils(): ConversationUtils {
        return ConversationUtils()
    }

    @Provides
    @Singleton
    fun provideShareMessagesController(messagingClient: MessagingClient): ShareMessagesController {
        return ShareMessagesController(messagingClient)
    }
}