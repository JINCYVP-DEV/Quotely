package com.nj.quotely.presentation.screens.saved

import androidx.lifecycle.ViewModel
import com.nj.quotely.data.Quote
import com.nj.quotely.data.SavedQuotesDataSource
import kotlinx.coroutines.flow.StateFlow

class SavedScreenViewModel: ViewModel() {

    val savedItems: StateFlow<List<Quote>> = SavedQuotesDataSource.savedItems

    fun savedItems(quote: Quote)
    {
        SavedQuotesDataSource.toggleSaveStatus(quote)
    }
}