package com.kids.kidapp.bottomnavigationbar

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kids.kidapp.screens.DetailsScreen
import com.kids.kidapp.screens.HomeScreen
import com.kids.kidapp.screens.PreviewBoxWithText
import com.kids.kidapp.screens.ProfileScreen
import com.kids.kidapp.screens.SettingScreen


@Composable
fun BottomNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.HomeScreen.route
    )
    {
        composable(route = BottomBarScreen.HomeScreen.route) {
            PreviewBoxWithText(navController)
        }
        composable(route = BottomBarScreen.SettingScreen.route) {
            SettingScreen()
        }
        composable(route = BottomBarScreen.ProfileScreen.route) {
            ProfileScreen()
        }
        composable("detailsScreen/{itemName}") { backStackEntry ->
            val itemName = backStackEntry.arguments?.getString("itemName") ?: ""
            DetailsScreen(itemName,"9810649581",navController)
        }
    }

}