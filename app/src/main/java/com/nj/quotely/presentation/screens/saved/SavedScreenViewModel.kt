package com.nj.quotely.presentation.screens.saved

import androidx.lifecycle.ViewModel
import com.nj.quotely.data.Quote
import com.nj.quotely.data.SavedQuotesDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SavedScreenViewModel: ViewModel() {

    private var _savedItems: MutableStateFlow<List<Quote>> = MutableStateFlow(emptyList())
    val savedItems: StateFlow<List<Quote>> =_savedItems.asStateFlow()
    val allData: StateFlow<List<Quote>> = SavedQuotesDataSource.savedItems


    init {
        _savedItems.value=  SavedQuotesDataSource.savedItems.value.filter { it.isSaved }
    }

    fun onSaveItem(quote: Quote)
    {
      SavedQuotesDataSource.onSave(quote)
    }
}