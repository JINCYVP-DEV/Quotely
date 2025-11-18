package com.nj.quotely.navigation

sealed class QuotesScreenRoutes(val route: String) {
    data object Explore : QuotesScreenRoutes("explore")
    data object Category : QuotesScreenRoutes("category")
}