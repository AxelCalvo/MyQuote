package com.example.myquote.core.di

import android.content.Context
import com.example.myquote.QuotesApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ContextModule {
    @Provides
    @Singleton
    fun provideContext(application: QuotesApp): Context {
        return application.applicationContext
    }

}