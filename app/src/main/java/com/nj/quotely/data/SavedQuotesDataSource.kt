package com.nj.quotely.data

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

object SavedQuotesDataSource {
    private val _savedItems = MutableStateFlow<List<Quote>>(Quote.getQuotes())
    val savedItems: StateFlow<List<Quote>> = _savedItems.asStateFlow()

    fun onSave(quote: Quote)
    {
        _savedItems.value= _savedItems.value.map { currentQuote->
           if(currentQuote.id==quote.id)
           {
               currentQuote.copy(isSaved = !currentQuote.isSaved)
           }
            else{
                currentQuote
           }
        }
    }

}