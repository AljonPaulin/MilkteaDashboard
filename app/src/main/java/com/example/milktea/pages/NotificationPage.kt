package com.example.milktea.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.milktea.component.HomeMenu
import com.example.milktea.component.TopBarHeader
import com.example.milktea.ui.theme.Main

@Composable
fun NotificationPage(modifier: Modifier = Modifier, navController: NavController) {
    Scaffold(
        containerColor = Main,
        topBar = {
            TopBarHeader(navController = navController, name = "Notification")
        },
        bottomBar = {
            HomeMenu(navController = navController, currentpage = "notification")
        },
        content = {
            innerPadding->
            Box(
                modifier = Modifier.padding(innerPadding)
            )
        }
    )
}