package com.nj.quotely.presentation.screens.saved

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nj.quotely.R
import com.nj.quotely.presentation.components.QuoteListItem
import com.nj.quotely.presentation.components.QuotelyTopBar
sealed class SavedScreenNavigation() {
    object OnBackPressed : SavedScreenNavigation()
}

@Composable
fun SavedScreen(viewModel: SavedScreenViewModel= viewModel(), onNavigation: (SavedScreenNavigation) -> Unit) {

    val savedQuotes =viewModel.savedItems.collectAsStateWithLifecycle()
    Scaffold(
        topBar = {
            QuotelyTopBar(
                title = stringResource(R.string.text_saved),
                showBackButton = false,
                onBack = {

                })
        }
    )
    { innerPadding ->
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(innerPadding)
        ) {
            items(savedQuotes.value)
            {
                QuoteListItem(
                    it,
                    onSave = {
                        viewModel.onSaveItem(it)
                    }
                )
            }
            item {
                Spacer(modifier = Modifier.height(66.dp))
            }
        }
    }
}