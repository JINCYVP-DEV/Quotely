package com.nj.quotely.presentation.screens.categories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nj.quotely.presentation.components.QuotelyTopBar
import com.nj.quotely.presentation.components.QuotesCard

sealed class CategoryScreenNavigation {
    object OnBackPressed : CategoryScreenNavigation()

}

@Composable
fun CategoryScreen(
    viewModel: CategoriesViewModel = viewModel(),
    onNavigation: (CategoryScreenNavigation) -> Unit
) {
    val allQuotes = viewModel.allQuotes.collectAsStateWithLifecycle()
    Scaffold(topBar = {
        QuotelyTopBar(
            title = stringResource(com.nj.quotely.R.string.text_explore),
            showBackButton = true,
            onBack = {
                onNavigation(CategoryScreenNavigation.OnBackPressed)
            }
        )
    }) {
        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(allQuotes.value)
            {
               // CategoryItem(it)
            }
        }
    }
}