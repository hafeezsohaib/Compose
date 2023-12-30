package com.kids.kidapp.bottomnavigationbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val tittle: String,
    val icon: ImageVector
) {
    data object HomeScreen : BottomBarScreen(
        route = "Home",
        tittle = "Home",
        icon = Icons.Default.Home
    )

    data object ProfileScreen : BottomBarScreen(
        route = "Profile",
        tittle = "Profile",
        icon = Icons.Default.Person
    )

     object SettingScreen : BottomBarScreen(
        route = "Setting",
        tittle = "Setting",
        icon = Icons.Default.Settings
    )
}