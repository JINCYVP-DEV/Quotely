package com.nj.quotely.data

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.collections.plus

object SavedQuotesDataSource {
    private val _savedItems = MutableStateFlow<List<Quote>>(emptyList())
    val savedItems: StateFlow<List<Quote>> = _savedItems.asStateFlow()

    fun toggleSaveStatus(quote: Quote) {
        if (isQuoteSaved(quote.id)) {
            removeSaved(quote)
        } else {
            addQuote(quote)
        }
    }
    fun addQuote(quote: Quote)
    {
        if (!isQuoteSaved(quote.id))
        {
            _savedItems.update {currentList->
                val updatedQuote = quote.copy(isSaved =true)
                currentList+updatedQuote
            }
        }
    }
    fun isQuoteSaved(quoteId: Int): Boolean
    {
        return  _savedItems.value.any {
            it.id==quoteId
        }
    }
    fun removeSaved(quote: Quote){
        if (isQuoteSaved(quoteId = quote.id))
        {
            _savedItems.update { currentList->
                currentList.filter { it.id != quote.id }
            }
        }
    }
}