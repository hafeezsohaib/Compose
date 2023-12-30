package com.kids.kidapp.bottomnavigationbar

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kids.kidapp.screens.HomeScreen
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
            HomeScreen()
        }
        composable(route = BottomBarScreen.SettingScreen.route) {
            SettingScreen()
        }
        composable(route = BottomBarScreen.ProfileScreen.route) {
            ProfileScreen()
        }
    }

}