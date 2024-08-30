package com.islamux.salam

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun SetupNavGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = "homePage"
    ) {
        composable("homePage") {
            HomePage(navController, modifier)
        }
        composable("khatiraOnePage") {
            KhatiraOnePage(navController, modifier)
        }
    }
}