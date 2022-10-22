package com.example.myquote.domain

import com.example.myquote.domain.model.QuoteModel
import kotlinx.coroutines.flow.Flow

interface QuoteRepository {
    suspend fun getQuoteRandom(): Flow<QuoteModel>
    suspend fun getQuote(quoteId:Int): Flow<QuoteModel>
}