package com.nj.quotely.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nj.quotely.data.Quote
import com.nj.quotely.presentation.ui.theme.Normal14
import com.nj.quotely.presentation.ui.theme.Normal8

@Composable
fun QuotesCard(modifier: Modifier = Modifier, item: Quote,onSave:(Quote)-> Unit) {

    Card(
        modifier = modifier
            .width(200.dp)
            .height(240.dp)
            .clip(RoundedCornerShape(16.dp))
    )
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                          item.color,
                            item.color.copy(alpha = 0.7f)
                        )
                    )
                )
                .padding(20.dp)
        ) {

            Row(verticalAlignment = Alignment.CenterVertically) {
                CircleShapeComponent(0.04f)
                SpacerWeight1f()
                Icon(
                    Icons.Default.Share,
                    contentDescription = "ic_share",
                    tint = Color.White
                )
                Icon(
                    Icons.Default.FavoriteBorder,
                    contentDescription = "save",
                    tint = Color.White,
                    modifier = Modifier.clickable{
                        onSave(item)
                    }
                )
            }
            SpacerWeight1f()
            Text(
                item.text,
                style = MaterialTheme.typography.Normal14.copy(
                    color = Color.White,
                    lineHeight = 16.sp
                ),
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                item.author,
                style = MaterialTheme.typography.Normal8.copy(
                    color = Color.White,
                    lineHeight = 16.sp,
                    fontStyle = FontStyle.Italic
                ),
                modifier = Modifier.padding(4.dp)
            )

        }

    }
}

