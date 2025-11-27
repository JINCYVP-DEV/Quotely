package com.nj.quotely.presentation.screens.explore

import androidx.lifecycle.ViewModel
import com.nj.quotely.data.Quote
import com.nj.quotely.data.SavedQuotesDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ExploreViewModel: ViewModel() {
    private var _quotesList: MutableStateFlow<List<Quote>> = MutableStateFlow(Quote.getQuotes())
    val quotesList: StateFlow<List<Quote>> = _quotesList.asStateFlow()

    fun onSave(quote: Quote)
    {
        SavedQuotesDataSource.toggleSaveStatus(quote = quote)
    }
}