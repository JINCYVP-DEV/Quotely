package com.nj.quotely.presentation.screens.saved

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nj.quotely.R
import com.nj.quotely.presentation.components.QuoteListItem
import com.nj.quotely.presentation.components.QuotelyTopBar
import com.nj.quotely.presentation.ui.theme.Normal16

sealed class SavedScreenNavigation() {
    object OnBackPressed : SavedScreenNavigation()
}

@Composable
fun SavedScreen(viewModel: SavedScreenViewModel= viewModel(), onNavigation: (SavedScreenNavigation) -> Unit) {

    val savedQuotes =viewModel.savedItems.collectAsStateWithLifecycle()
    Scaffold(containerColor = Color.White,
        topBar = {
            QuotelyTopBar(
                title = stringResource(R.string.text_saved),
                showBackButton = false,
                onBack = {

                })
        }
    )
    { innerPadding ->
        if (savedQuotes.value.isEmpty())
        {
            EmptyScreen()
        }
        else
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(innerPadding)
        ) {
            items(savedQuotes.value)
            {
                QuoteListItem(
                    item = it,
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

@Composable
fun EmptyScreen() {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Text(
            text = stringResource(R.string.text_no_saved_items),
            style = MaterialTheme.typography.Normal16
        )
    }
}