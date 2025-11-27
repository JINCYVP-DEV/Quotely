package com.nj.quotely.presentation.screens.categories

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.nj.quotely.data.Quote
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CategoriesViewModel(savedStateHandle: SavedStateHandle): ViewModel() {
    val category: String? = savedStateHandle.get("category")

    private val allQuotes: List<Quote> =  Quote.getQuotes()
    private var _filteredQuotes: MutableStateFlow<List<Quote>> = MutableStateFlow(emptyList())
    val filteredQuotes : StateFlow<List<Quote>> = _filteredQuotes.asStateFlow()

    private var _categories: MutableStateFlow<List<String>> = MutableStateFlow(emptyList())
    val categories : StateFlow<List<String>> = _categories.asStateFlow()

    init {
        _categories.value = allQuotes.map { it.category.displayName }.distinct()

        filterCategory(categoryName =  if(!category.isNullOrEmpty()) category else _categories.value[0])
    }

    fun filterCategory(categoryName: String)
    {
        if (categoryName.isNotEmpty())
        {
            val filteredList= allQuotes.filter { quote->
                quote.category.displayName.contains(categoryName)
            }
            _filteredQuotes.value=filteredList
        }else{
            _filteredQuotes.value= allQuotes
        }
    }
}