package com.nj.quotely.presentation.screens.saved

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.nj.quotely.R
import com.nj.quotely.presentation.components.QuotelyTopBar
sealed class SavedScreenNavigation()
{
    object OnBackPressed:SavedScreenNavigation()
}
@Composable
fun SavedScreen(onNavigation:(SavedScreenNavigation)-> Unit) {
    Scaffold(topBar = {
        QuotelyTopBar(
            title = stringResource(R.string.text_saved),
            showBackButton = true,
            onBack = {
                onNavigation(SavedScreenNavigation.OnBackPressed)
            }
        )
    }) {

    }
}