package com.nj.quotely.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nj.quotely.data.Quote
import com.nj.quotely.data.QuoteCategory
import com.nj.quotely.data.SavedQuotesDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel() : ViewModel() {
    val quotesList: StateFlow<List<Quote>> = SavedQuotesDataSource.savedItems
    private val _categoryList = MutableStateFlow<List<QuoteCategory>>(emptyList())
    val categoryList: StateFlow<List<QuoteCategory>> = _categoryList.asStateFlow()

    init {
        viewModelScope.launch {
            quotesList.collect { updatedList ->
                _categoryList.value = updatedList.map { it.category }.distinct()
            }
        }
    }

    fun onSave(quote: Quote) {
        SavedQuotesDataSource.onSave(quote = quote)
    }
}
