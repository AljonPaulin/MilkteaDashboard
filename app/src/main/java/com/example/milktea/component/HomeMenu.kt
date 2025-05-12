package com.example.milktea.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.milktea.ui.theme.MainColorMilk

@Composable
fun HomeMenu(modifier: Modifier = Modifier, navController: NavController, currentpage: String) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MainColorMilk)
            .padding(horizontal = 10.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(
                onClick = {
                    navController.navigate(route = "home")
                },
                modifier = Modifier.height(25.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Menu",
                    modifier = Modifier.size(30.dp),
                    tint = if(currentpage == "home") Color.Black else Color.Gray,
                )
            }
            Text("Home", fontWeight = FontWeight.Bold, color = if(currentpage == "home") Color.Black else Color.Gray)
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(
                onClick = {
                    navController.navigate(route = "favorite_page")
                },
                modifier = Modifier.height(25.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Menu",
                    modifier = Modifier.size(30.dp),
                    tint = if(currentpage == "favorite") Color.Black else Color.Gray
                )
            }
            Text("Favorites", fontWeight = FontWeight.Bold, color = if(currentpage == "favorite") Color.Black else Color.Gray)
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(
                onClick = {
                    navController.navigate(route = "cart_page")
                },
            ) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Menu",
                    modifier = Modifier
                        .size(50.dp)
                        .background(if(currentpage == "cart") Color.Black else Color.Gray, shape = RoundedCornerShape(30.dp))
                        .padding(10.dp),
                    tint = Color.White

                )
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(
                onClick = {
                    navController.navigate(route = "setting_page")
                },
                modifier = Modifier.height(25.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Menu",
                    modifier = Modifier.size(30.dp),
                    tint = if(currentpage == "setting") Color.Black else Color.Gray
                )
            }
            Text("Settings", fontWeight = FontWeight.Bold, color = if(currentpage == "setting") Color.Black else Color.Gray)
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(
                onClick = {
                    navController.navigate(route = "profile_page")
                },
                modifier = Modifier.height(25.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Menu",
                    modifier = Modifier.size(30.dp),
                    tint = if(currentpage == "profile") Color.Black else Color.Gray
                )
            }
            Text("Profile", fontWeight = FontWeight.Bold, color = if(currentpage == "profile") Color.Black else Color.Gray)
        }


    }
}