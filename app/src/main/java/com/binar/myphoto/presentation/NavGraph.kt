package com.binar.myphoto.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.binar.myphoto.presentation.screen.DetailScreen
import com.binar.myphoto.presentation.screen.FavoriteScreen
import com.binar.myphoto.presentation.screen.HomeScreen
import com.binar.myphoto.presentation.screen.SearchResultScreen


@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(navController)
        }
        composable(route = BottomBarScreen.Favorite.route) {
            FavoriteScreen(navController)
        }

        composable("detail_screen/{photoId}"){ DetailScreen(it.arguments?.getString("photoId"))}

        composable("search_screen/{text}"){ SearchResultScreen(navController,it.arguments?.getString("text"))}

    }
}