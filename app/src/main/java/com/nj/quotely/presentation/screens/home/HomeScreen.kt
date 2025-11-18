package com.nj.quotely.presentation.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nj.quotely.R
import com.nj.quotely.data.Quote
import com.nj.quotely.presentation.components.QuotelyTopBar
import com.nj.quotely.presentation.components.QuotesCard
import com.nj.quotely.presentation.components.SectionHeader
import com.nj.quotely.presentation.screens.saved.SavedScreenNavigation
import com.nj.quotely.presentation.ui.theme.Bold20
import com.nj.quotely.presentation.ui.theme.Medium12
import com.nj.quotely.presentation.ui.theme.Normal12

sealed class HomeScreenNavigation {
    object OnBackPressed : HomeScreenNavigation()
    object OnNavigateToExplore : HomeScreenNavigation()
    data class OnNavigateToCategories(val category: String?) : HomeScreenNavigation()
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(),
    onNavigation: (HomeScreenNavigation) -> Unit
) {
    val fullQuotesList = viewModel.quotesList.collectAsStateWithLifecycle()
    val halfQuotesList = fullQuotesList.value.take((fullQuotesList.value.size) / 2)
    Scaffold(topBar = {
        QuotelyTopBar(
            title = stringResource(R.string.text_explore),
            showBackButton = false,
            onBack = {
                onNavigation(HomeScreenNavigation.OnBackPressed)
            }
        )
    }) {
        LazyColumn(
            modifier = modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            item {
                Text(
                    text = stringResource(R.string.text_explore),
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                    style = MaterialTheme.typography.Bold20.copy(fontSize = 24.sp)
                )
                Text(
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                    text = stringResource(R.string.text_awesome_quotes_from_our_community),
                    style = MaterialTheme.typography.Normal12.copy(color = Color.Black.copy(alpha = 0.8f)),
                )
            }

            item {
                Image(
                    painter = painterResource(R.drawable.start),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .height(210.dp),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }

            item {
                SectionHeader(
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                    startText = stringResource(R.string.text_latest_quotes),
                    endText = stringResource(R.string.text_view_all),
                    onNavigate = {
                        onNavigation(HomeScreenNavigation.OnNavigateToExplore)
                    })
            }

            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp)
                ) {
                    items(halfQuotesList) { itemContent ->
                        QuotesCard(Modifier, itemContent)
                        {
                            viewModel.saveItem(it)
                        }
                    }
                }
            }

            item {
                SectionHeader(
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                    startText = stringResource(R.string.text_categories),
                    endText = stringResource(R.string.text_view_all),
                    onNavigate = {
                        onNavigation(HomeScreenNavigation.OnNavigateToCategories(""))
                    })
            }

            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp)
                ) {
                    items(halfQuotesList) { item ->
                        QuotesCategoryComponent(item = item)
                        {
                            onNavigation(HomeScreenNavigation.OnNavigateToCategories(it))
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }

        }
    }
}

@Composable
fun QuotesCategoryComponent(modifier: Modifier = Modifier, item: Quote, onClick: (String) -> Unit) {

    Card(
        modifier = modifier
            .width(100.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable {
                onClick(item.category.displayName)
            },
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Surface(
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape),
                color = item.category.bgColor.copy(alpha = 0.4f)

            ) {
                Icon(
                    item.category.icon,
                    "",
                    Modifier
                        .size(44.dp)
                        .padding(12.dp),
                    tint = item.category.bgColor
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(item.category.displayName, style = MaterialTheme.typography.Medium12)
            Spacer(modifier = Modifier.height(8.dp))

        }

    }


}


