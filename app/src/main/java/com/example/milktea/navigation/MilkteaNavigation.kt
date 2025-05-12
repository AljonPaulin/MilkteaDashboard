package com.example.milktea.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.milktea.pages.CartPage
import com.example.milktea.pages.CategoryPage
import com.example.milktea.pages.CheckoutPage
import com.example.milktea.pages.FavoritePage
import com.example.milktea.pages.Homepage
import com.example.milktea.pages.NotificationPage
import com.example.milktea.pages.PopularDrinksPage
import com.example.milktea.pages.ProfilePage
import com.example.milktea.pages.RecentPage
import com.example.milktea.pages.SettingPage
import com.example.milktea.pages.TeaPage
import com.example.milktea.pages.WelcomePage

@Composable
fun MilkteaNavigation(modifier: Modifier = Modifier){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home", builder = {
        composable(route = "welcome"){
            WelcomePage(modifier, navController)
        }
        composable(route = "home"){
            Homepage(modifier, navController)
        }
        composable(route = "tea_page"){
            TeaPage(modifier, navController)
        }
        composable(route = "favorite_page"){
            FavoritePage(modifier, navController)
        }
        composable(route = "cart_page"){
            CartPage(modifier, navController)
        }
        composable(route = "checkout_page"){
            CheckoutPage(modifier, navController)
        }
        composable(route = "popular_drinks_page"){
            PopularDrinksPage(modifier, navController)
        }
        composable(route = "recent_page"){
           RecentPage(modifier, navController)
        }
        composable(route = "notification_page"){
            NotificationPage(modifier, navController)
        }
        composable(route = "setting_page"){
            SettingPage(modifier, navController)
        }
        composable(route = "category_page/{name}"){ backStackEntry->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            CategoryPage(modifier, navController, name)
        }
        composable(route = "profile_page"){
            ProfilePage(modifier, navController)
        }
    })
}


