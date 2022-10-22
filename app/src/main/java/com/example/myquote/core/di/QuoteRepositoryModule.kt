package com.example.myquote.core.di

import com.example.myquote.data.QuoteRepositoryImpl
import com.example.myquote.data.local.QuoteLocalDataSource
import com.example.myquote.data.local.QuoteLocalDataSourceImpl
import com.example.myquote.domain.QuoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class QuoteRepositoryModule {

    @Binds
    abstract fun bindQuoteRepository(quoteRepositoryImpl: QuoteRepositoryImpl):
            QuoteRepository

    @Binds
    abstract fun bindQuoteLocalDataSource(quoteLocalDataSourceImpl: QuoteLocalDataSourceImpl):
            QuoteLocalDataSource

}