package com.nj.quotely.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AllInclusive
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(val route: String,val icon: ImageVector,val title: String ) {
    object HOME:BottomBarScreen("home", Icons.Default.Dashboard,"Home")
    object EXPLORE:BottomBarScreen("explore", Icons.Default.AllInclusive,"Explore")
    object SAVED:BottomBarScreen("saved", Icons.Default.FavoriteBorder,"Saved")
}