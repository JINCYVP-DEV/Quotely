package com.nj.quotely.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nj.quotely.presentation.ui.theme.Medium16

@Composable
fun SectionHeader(
    modifier: Modifier = Modifier,
    startText: String,
    endText: String,
    onNavigate: () -> Unit = {}
) {

    Row(
        modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            startText,
            style = MaterialTheme.typography.Medium16,
        )

        Text(
            endText, style = MaterialTheme.typography.Medium16, modifier = Modifier.clickable {
                onNavigate()
            })
    }

}