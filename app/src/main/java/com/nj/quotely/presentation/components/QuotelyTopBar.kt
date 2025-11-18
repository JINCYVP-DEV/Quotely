package com.nj.quotely.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nj.quotely.presentation.ui.theme.Bold20

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuotelyTopBar(title: String, showBackButton: Boolean = false, onBack: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = title,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                style = MaterialTheme.typography.Bold20.copy(fontSize = 26.sp)
            )
        },
        navigationIcon = {
            if (showBackButton)
                Icon(
                    imageVector = Icons.Default.ArrowBackIosNew,
                    contentDescription = "back",
                    modifier = Modifier
                        .size(20.dp)
                        .clickable {
                            onBack()
                        }
                )
        },
    )
}