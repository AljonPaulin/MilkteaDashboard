package com.example.milktea.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.milktea.R
import com.example.milktea.component.HomeMenu
import com.example.milktea.component.TopBarHeader
import com.example.milktea.ui.theme.Main
import com.example.milktea.ui.theme.MainColorMilk

@Composable
fun FavoritePage(modifier: Modifier = Modifier, navController: NavController) {
    val scrollState = rememberScrollState()
    Scaffold(
        containerColor = Main,
        topBar = {
            TopBarHeader(name = "Favorites", navController = navController)
        },
        bottomBar = {
            HomeMenu(navController = navController, currentpage = "favorite")
        },
        content = {
            innerPadding->
            FlowRow(
                modifier = Modifier.fillMaxWidth()
                    .verticalScroll(scrollState)
                    .padding(innerPadding),
                horizontalArrangement = Arrangement.SpaceEvenly,
                maxItemsInEachRow = 2
            ) {
                FavorateTea("Brown Sugar Boba", 100, 4.8, 30, navController)
                FavorateTea("Taro Milk Tea", 90, 4.5, 25, navController)
                FavorateTea("Matcha Latte", 110, 4.7, 35, navController)
                FavorateTea("Brown Sugar Boba", 100, 4.8, 30, navController)
                FavorateTea("Taro Milk Tea", 90, 4.5, 25, navController)
                FavorateTea("Matcha Latte", 110, 4.7, 35, navController)
                // Add more as needed
            }
        }
    )
}

@Composable
fun FavorateTea(name: String, price: Int, rating: Double, customerNumbers: Int, navController: NavController) {

    val full_price = price.toString()
    val string_rating = rating.toString()
    val string_customerNumbers = customerNumbers.toString()
    var isHeartClicked by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .height(230.dp)
            .padding(10.dp)
            .width(142.dp),
        colors = CardColors(
            containerColor = MainColorMilk, contentColor = Color.Black,
            disabledContainerColor = MainColorMilk,
            disabledContentColor = Color.Black
        ),

        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        onClick = { navController.navigate(route = "tea_page")
        }
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.Start
        ){
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Tea Image",
                modifier = Modifier.width(140.dp),
                contentScale = ContentScale.FillBounds
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,

                content = {
                    Text(
                    text = name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    lineHeight = 30.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.width(100.dp)
                    )
                    IconButton(
                        onClick = {
                            isHeartClicked = !isHeartClicked
                        },
                        modifier = Modifier.height(20.dp),
                        content = {
                            Icon(
                                imageVector = if (isHeartClicked) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                                contentDescription = "Heart Icon"
                            )
                        }
                    )
                }
            )

            Text(
                text = "⭐$string_rating ($string_customerNumbers)",
                fontSize = 18.sp

            )
            Row (
                modifier = Modifier.fillMaxWidth().padding(start = 5.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ){
                Text(
                    text = "₱$full_price",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp

                )
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Default.AddCircle,
                        contentDescription = "Menu",
                        modifier = Modifier.size(30.dp),
                        tint = Color.Black
                    )
                }

            }

        }
    }

}