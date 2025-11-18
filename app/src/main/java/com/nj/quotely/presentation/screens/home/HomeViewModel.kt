package com.nj.quotely.presentation.screens.home

import androidx.lifecycle.ViewModel
import com.nj.quotely.data.Quote
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : ViewModel() {
    private var _quotesList: MutableStateFlow<List<Quote>> = MutableStateFlow(Quote.getQuotes())
    val quotesList: StateFlow<List<Quote>> = _quotesList.asStateFlow()

    private val _savedItems = MutableStateFlow<List<Quote>>(emptyList())
    val savedItems: StateFlow<List<Quote>> = _savedItems.asStateFlow()

    fun saveItem(quote: Quote) {
        if (!_savedItems.value.contains(quote)) {
            _savedItems.value += quote
        }
        else{
            _savedItems.value -= quote
        }
    }
}