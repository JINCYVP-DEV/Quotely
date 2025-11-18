package com.nj.quotely.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.nj.quotely.navigation.QuotesScreenRoutes
import com.nj.quotely.presentation.screens.categories.CategoryScreen
import com.nj.quotely.presentation.screens.categories.CategoryScreenNavigation
import com.nj.quotely.presentation.screens.explore.ExploreScreen
import com.nj.quotely.presentation.screens.explore.ExploreScreenNavigation
import com.nj.quotely.presentation.screens.home.HomeScreen
import com.nj.quotely.presentation.screens.home.HomeScreenNavigation
import com.nj.quotely.presentation.screens.saved.SavedScreen
import com.nj.quotely.presentation.screens.saved.SavedScreenNavigation

@Composable
fun AppNavGraph(navController: NavHostController, modifier: Modifier) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.HOME.route
    )
    {
        composable(BottomBarScreen.HOME.route) {
            HomeScreen(modifier = modifier) { onNavigation ->
                when (onNavigation) {
                    is HomeScreenNavigation.OnBackPressed -> navController.popBackStack()
                    is HomeScreenNavigation.OnNavigateToExplore -> navController.navigate(
                        QuotesScreenRoutes.Explore.route
                    )

                    is HomeScreenNavigation.OnNavigateToCategories -> {
                        navController.navigate("${QuotesScreenRoutes.Category.route}/${onNavigation.category}")
                    }
                }

            }
        }
        composable(BottomBarScreen.EXPLORE.route) {
            ExploreScreen { onNavigation ->
                when (onNavigation) {
                    is ExploreScreenNavigation.OnBackPressed -> {
                        navController.popBackStack()
                    }
                }
            }
        }

        composable(BottomBarScreen.SAVED.route) {
            SavedScreen { onNavigation ->
                when (onNavigation) {
                    is SavedScreenNavigation.OnBackPressed -> {
                        navController.popBackStack()
                    }
                }

            }
        }
        composable(
            route = QuotesScreenRoutes.Explore.route
        ) {
            ExploreScreen { onNavigation ->
                when (onNavigation) {
                    is ExploreScreenNavigation.OnBackPressed -> {
                        navController.popBackStack()
                    }
                }
            }
        }
        composable(
            route = "${QuotesScreenRoutes.Category.route}/{category}",
            arguments = listOf(
                navArgument(name = "category") {
                    type = NavType.StringType
                    nullable = true
                })
        )
        {
            CategoryScreen { onNavigation ->
                when (onNavigation) {
                    is CategoryScreenNavigation.OnBackPressed -> {
                        navController.popBackStack()
                    }
                }
            }
        }
    }
}