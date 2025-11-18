package com.nj.quotely.presentation.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun RowScope.SpacerWeight1f() {
    Spacer(modifier = Modifier.weight(1f))
}

@Composable
fun ColumnScope.SpacerWeight1f() {
    Spacer(modifier = Modifier.weight(1f))
}

