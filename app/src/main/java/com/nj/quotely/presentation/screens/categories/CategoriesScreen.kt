package com.nj.quotely.presentation.screens.categories

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nj.quotely.presentation.components.QuoteListItem
import com.nj.quotely.presentation.components.QuotelyTopBar
import kotlinx.coroutines.launch

sealed class CategoryScreenNavigation {
    object OnBackPressed : CategoryScreenNavigation()

}

@Composable
fun CategoryScreen(
    viewModel: CategoriesViewModel = viewModel(),
    onNavigation: (CategoryScreenNavigation) -> Unit
) {
    val allQuotes = viewModel.filteredQuotes.collectAsStateWithLifecycle()
    val categories = viewModel.categories.collectAsStateWithLifecycle()
    val selectedCategory = viewModel.category
    val listState = rememberLazyListState()

    Scaffold(topBar = {
        QuotelyTopBar(
            title = stringResource(com.nj.quotely.R.string.text_explore),
            showBackButton = true,
            onBack = {
                onNavigation(CategoryScreenNavigation.OnBackPressed)
            }
        )
    }) { inn ->
        var selectedIndex by remember { mutableIntStateOf(0) }
            if (!selectedCategory.isNullOrEmpty()) {
                val index = categories.value.indexOf(selectedCategory)
                if (index!=-1)
                {
                    selectedIndex= index
                }
            }

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(inn)) {

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth(),
                state =listState,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                itemsIndexed(categories.value) { index, items ->

                    val isSelected = index == selectedIndex

                    Text(
                        text = items,
                        modifier = Modifier
                            .clickable {
                                selectedIndex = index
                                viewModel.filterCategory(categories.value[index])
                            }
                            .background(
                                if (isSelected) Color.Green.copy(alpha = .1f) else Color.White,
                                shape = RoundedCornerShape(12.dp)
                            )
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                        color = Color.Black
                    )
                }
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                items(allQuotes.value)
                {
                    QuoteListItem(
                        it,
                        onSave = {}
                    )
                }
            }
        }
    }
}
