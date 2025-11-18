package com.nj.quotely.presentation.screens.categories

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.nj.quotely.data.Quote
import com.nj.quotely.presentation.components.QuotelyTopBar
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CategoriesViewModel(private val savedStateHandle: SavedStateHandle): ViewModel() {
    val category: String? = savedStateHandle.get<String>("category")
    private var _allQuotes: MutableStateFlow<List<Quote>> = MutableStateFlow(Quote.getQuotes())
    val allQuotes : StateFlow<List<Quote>> = _allQuotes.asStateFlow()
    private val fullListOfQuotes: List<Quote> =  Quote.getQuotes()

    fun filter(categoryName: String)
    {
        if (categoryName.isNotEmpty())
        {
            val filteredList= fullListOfQuotes.filter { quote->
                quote.category.equals(categoryName)
            }
            _allQuotes.value=filteredList
        }else{
            _allQuotes.value= fullListOfQuotes
        }
    }
}