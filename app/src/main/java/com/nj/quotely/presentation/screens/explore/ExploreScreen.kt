package com.nj.quotely.presentation.screens.explore

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nj.quotely.R
import com.nj.quotely.presentation.components.QuoteListItem
import com.nj.quotely.presentation.components.QuotelyTopBar
import com.nj.quotely.presentation.screens.saved.SavedScreenViewModel

sealed class ExploreScreenNavigation {
    object OnBackPressed : ExploreScreenNavigation()
}

@Composable
fun ExploreScreen(
    viewModel: SavedScreenViewModel = viewModel(),
    onNavigation: (ExploreScreenNavigation) -> Unit
) {

    val allQuotes = viewModel.allData.collectAsStateWithLifecycle()
    Scaffold(containerColor = Color.White,topBar = {
        QuotelyTopBar(
            title = stringResource(R.string.text_explore),
            showBackButton = false,
            onBack = {
                onNavigation(ExploreScreenNavigation.OnBackPressed)
            }
        )
    }) { innerPadding ->
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(innerPadding)
        ) {
            items(allQuotes.value)
            {
                QuoteListItem(
                    item=it,
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
