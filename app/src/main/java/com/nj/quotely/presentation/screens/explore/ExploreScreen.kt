package com.nj.quotely.presentation.screens.explore

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import com.nj.quotely.R
import com.nj.quotely.data.Quote
import com.nj.quotely.presentation.components.QuotelyTopBar
import com.nj.quotely.presentation.components.SpacerWeight1f
import com.nj.quotely.presentation.ui.theme.Bold12
import com.nj.quotely.presentation.ui.theme.Medium14
import com.nj.quotely.presentation.ui.theme.Medium16

sealed class ExploreScreenNavigation {
    object OnBackPressed : ExploreScreenNavigation()
}

@Composable
fun ExploreScreen(
    viewModel: ExploreViewModel = viewModel(),
    onNavigation: (ExploreScreenNavigation) -> Unit
) {

    val allQuotes = viewModel.quotesList.collectAsStateWithLifecycle()
    Scaffold(topBar = {
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
                    it,
                    onSave = {}
                )
            }
        }
    }

}

@Composable
fun QuoteListItem(item: Quote,onSave:(Quote)-> Unit) {
    Card(
        modifier = Modifier
            .height(150.dp)
            .fillMaxWidth()
            .padding(12.dp)
            .clip(
                shape = RoundedCornerShape(12.dp)
            )

    )
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            item.color, item.color.copy(
                                alpha = .8f
                            )
                        )
                    )
                )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "avatar",
                    tint = Color.White,
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = item.author, style = MaterialTheme.typography.Bold12.copy(color = Color.White))
                SpacerWeight1f()
                Icon(
                    Icons.Default.FavoriteBorder,
                    contentDescription = "save",
                    tint = Color.White,
                    modifier = Modifier.clickable {
                         onSave(item)
                    }
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = item.text,
                style = MaterialTheme.typography.Medium14.copy(color = Color.White),
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}