package com.nj.quotely.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nj.quotely.data.Quote
import com.nj.quotely.data.QuoteCategory
import com.nj.quotely.data.SavedQuotesDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
// Remove the import for asStateFlow if you used it
// import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.SharingStarted // Import this
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.stateIn // Import this
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel() : ViewModel() {
    private var _allList: MutableStateFlow<List<Quote>> = MutableStateFlow(Quote.getQuotes())
    val quotesList: StateFlow<List<Quote>> = _allList
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
        SavedQuotesDataSource.toggleSaveStatus(quote = quote)
        _allList.value = _allList.value.map { currentQuote ->
            if (currentQuote.id == quote.id) {
                currentQuote.copy(isSaved = !currentQuote.isSaved)
            } else {
                currentQuote
            }
        }
    }
}
