package com.nj.quotely.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.nj.quotely.data.Quote
import com.nj.quotely.presentation.ui.theme.Bold12
import com.nj.quotely.presentation.ui.theme.Medium14


@Composable
fun QuoteListItem(item: Quote, onSave: (Quote) -> Unit) {
    val fillIcon = if (item.isSaved) Icons.Default.Favorite else Icons.Default.FavoriteBorder
    val favoriteTint = if (item.isSaved) Color.Red else Color.White
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
                    tint = Color.Black,
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = item.author,
                    style = MaterialTheme.typography.Bold12.copy(color = Color.White)
                )
                SpacerWeight1f()
                Icon(
                    fillIcon,
                    contentDescription = "save",
                    tint = favoriteTint,
                    modifier = Modifier.clickable(
                        onClick = { onSave(item) },
                        indication = null,
                        interactionSource = MutableInteractionSource()
                    )
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = item.text,
                style = MaterialTheme.typography.Medium14.copy(color = Color.White),
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}