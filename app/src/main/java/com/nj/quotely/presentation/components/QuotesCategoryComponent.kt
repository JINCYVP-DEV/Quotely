package com.nj.quotely.presentation.components
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.nj.quotely.presentation.ui.theme.Medium14

@Composable
fun QuotesCategoryComponent(modifier: Modifier = Modifier) {

    Card(
        modifier = modifier
            .width(100.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable {},
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF1E40AF).copy(alpha = 0.08f))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Surface(
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF1E40AF).copy(alpha = 0.5f))
            ) {
                Icon(
                    Icons.Default.Favorite,
                    "",
                    Modifier
                        .size(44.dp)
                        .padding(12.dp),
                    tint = Color.Blue
                )
            }
            Spacer(modifier = Modifier.height(8.dp))

            Text("Life", style = MaterialTheme.typography.Medium14)
            Spacer(modifier = Modifier.height(8.dp))

        }

    }
}
