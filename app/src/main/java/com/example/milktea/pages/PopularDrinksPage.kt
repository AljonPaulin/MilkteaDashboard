package com.example.milktea.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.milktea.component.HomeMenu
import com.example.milktea.component.TopBarHeader
import com.example.milktea.ui.theme.Main

@Composable
fun PopularDrinksPage(modifier: Modifier = Modifier, navController: NavController) {
    val scrollState = rememberScrollState()
    Scaffold(
        containerColor = Main,
        topBar = {
            TopBarHeader(navController = navController, name = "Popular Drinks")
        },
        bottomBar = {
            HomeMenu(navController = navController, currentpage = "popular drinks")
        },
        content = {
            innerPadding ->
            FlowRow(
                modifier = Modifier.fillMaxWidth()
                    .verticalScroll(scrollState)
                    .padding(innerPadding),
                horizontalArrangement = Arrangement.SpaceEvenly,
                maxItemsInEachRow = 2
            ) {
                TeaBox("Brown Sugar Boba", 100, 4.8, 30, navController)
                TeaBox("Taro Milk Tea", 90, 4.5, 25, navController)
                TeaBox("Matcha Latte", 110, 4.7, 35, navController)
                TeaBox("Brown Sugar Boba", 100, 4.8, 30, navController)
                TeaBox("Taro Milk Tea", 90, 4.5, 25, navController)
                TeaBox("Matcha Latte", 110, 4.7, 35, navController)
                // Add more as needed
            }
        }
    )
}