package com.contusfly.di.modules

import com.contusfly.repository.MessageRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoModule {

    @Provides
    @Singleton
    fun provideMessageRepository(): MessageRepository {
        return MessageRepository()
    }

}