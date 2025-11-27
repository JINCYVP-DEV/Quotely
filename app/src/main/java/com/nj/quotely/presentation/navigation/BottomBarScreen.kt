package com.nj.quotely.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddHome
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(val route: String,val icon: ImageVector,val title: String ) {
    object HOME:BottomBarScreen("home", Icons.Default.AddHome,"Home")
    object EXPLORE:BottomBarScreen("explore", Icons.Default.Camera,"Explore")
    object SAVED:BottomBarScreen("saved", Icons.Default.FavoriteBorder,"Saved")
}