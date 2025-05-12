package com.example.milktea.pages

import android.net.Uri
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.milktea.R
import com.example.milktea.component.HomeMenu
import com.example.milktea.ui.theme.Main
import com.example.milktea.ui.theme.MainColorMilk
import kotlinx.coroutines.launch

@Composable
fun Homepage(modifier: Modifier = Modifier, navController: NavController) {
    val categoryList = listOf("Classic", "Fruit Tea", "Juice Tea", "Smoothies", "Shake" )
    val pagerState = rememberPagerState(pageCount = { categoryList.size })
    val lazyListState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold (
        containerColor = Main,
        topBar ={
            SearchBar(navController = navController)
        },
        bottomBar = {
            HomeMenu(navController = navController, currentpage = "home")
        },
        content = {
            innerPadding->
            Box (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ){
                Column {
                    Text("Categories",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black, fontSize = 25.sp,
                        modifier = Modifier.padding(start = 20.dp))
                    //DONE CATEGORIES
                    LazyRow(
                        state = lazyListState,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween

                    ) {
                        items(categoryList.size) { index ->
                            val context = LocalContext.current
                            val name = categoryList[index].lowercase().substringBefore(" ")
                            val resId = remember(name) {
                                context.resources.getIdentifier(name, "drawable", context.packageName)
                            }

                            Card (
                                onClick = {
                                    coroutineScope.launch {
                                        pagerState.animateScrollToPage(index)
                                    }
                                    navController.navigate(route = "category_page/${categoryList[index]}")
                                },
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.Transparent
                                ),
                                modifier = Modifier.width(90.dp),
                            ){
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 10.dp),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Icon(
                                        painter = painterResource(id = resId),
                                        contentDescription = "Menu",
                                        modifier = Modifier
                                            .size(50.dp)
                                            .background(
                                                MainColorMilk,
                                                shape = RoundedCornerShape(30.dp)
                                            )
                                            .padding(10.dp)

                                    )
                                    Text(categoryList[index])
                                }
                            }
                        }
                    }
                    // POPULAR DRINK
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text("Popular Drinks",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black, fontSize = 25.sp)
                        TextButton(
                            onClick = {
                                navController.navigate(route = "popular_drinks_page")
                            }
                        ) {
                            Text("See all", color = Color.Black)
                        }
                    }
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        TeaBox("Brown Sugar Boba", 100, 4.8, 30, navController)
                        TeaBox("Taro Milk Tea", 50, 4.0, 67, navController)
                    }

                    //
                    // PREVIOUS DRINK
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text("Recently Viewed",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black, fontSize = 25.sp)
                        TextButton(
                            onClick = {
                                navController.navigate(route = "recent_page")
                            }
                        ) {
                            Text("See all", color = Color.Black)
                        }
                    }
                    PreviousTeaBox("Brown Sugar Boba", 100, 4.8, 30, navController)


                }
            }
        }
    )
}

@Composable
private fun SearchBar(modifier: Modifier = Modifier, navController: NavController) {

    var expanded by remember { mutableStateOf(false) }
    var query by remember { mutableStateOf("") }

    Row (
        modifier = Modifier.fillMaxWidth()
            .padding(10.dp, 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween

    ){
        Text("" +
                "TeaHouse",
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            color = Color.Black, fontSize = 30.sp, modifier = Modifier.padding(horizontal = 10.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(55.dp)
        ) {
            AnimatedVisibility(visible = expanded) {
                TextField(
                    value = query,
                    onValueChange = { query = it },
                    modifier = Modifier
                        .width(130.dp),
                    placeholder = { Text("Search...") },
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = MainColorMilk,
                        unfocusedContainerColor = MainColorMilk,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedPlaceholderColor = Color.Gray,
                        unfocusedPlaceholderColor = Color.Gray,
                        disabledPlaceholderColor = Color.Gray,
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                        disabledTextColor = Color.Black,
                        cursorColor = Color.Black
                    ),
                    shape = RoundedCornerShape(50)
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .padding(16.dp)
                    .height(55.dp)
            ){
                IconButton(
                    onClick = { expanded = !expanded },
                    modifier = Modifier
                        .size(25.dp)
                ) {
                    Icon(
                        imageVector = if (expanded) Icons.Default.Close else Icons.Default.Search,
                        contentDescription = "Search",
                        modifier = Modifier
                            .size(40.dp)
                    )
                }
            }
            IconButton(
                    onClick = {
                        navController.navigate(route = "notification_page")
                    },
            modifier = Modifier
                .width(40.dp)
                .padding(2.dp)
            ) {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Menu Button",
                tint = Color.Black,
                modifier = Modifier.size(40.dp)

            )
        }


        }

    }
}


//NOT USABLE
@Composable
private fun CategoryBtn(name : String, pagerState: PagerState, categories: List<String>) {
    val currentPage = pagerState.currentPage
    val category = categories[currentPage]

    Spacer(modifier = Modifier.width(10.dp))
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = if (category == name) Color.Black else Color.Gray
        ),
        modifier = Modifier.width(100.dp)
    ) {
        Text(name)
    }
}

@Composable
fun TeaBox(name: String, price: Int, rating: Double, customerNumbers: Int, navController: NavController) {

    val full_price = price.toString()
    val string_rating = rating.toString()
    val string_customerNumbers = customerNumbers.toString()

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
                Text(
                    text = name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    lineHeight = 30.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.width(140.dp)
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

@Composable
private fun PreviousTeaBox(name: String, price: Int, rating: Double, customerNumbers: Int , navController: NavController) {

    val full_price = price.toString()
    val string_rating = rating.toString()
    val string_customerNumbers = customerNumbers.toString()

    Card(
        onClick = {
            navController.navigate(route = "tea_page")
        },
        modifier = Modifier
            .height(100.dp)
            .padding(horizontal = 25.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Tea Image",
                modifier = Modifier.width(140.dp),
                contentScale = ContentScale.FillBounds
            )
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MainColorMilk)
                    .padding(10.dp),
                horizontalAlignment = Alignment.Start
            ){

                Text(
                    text = name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    lineHeight = 30.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.width(200.dp),
                    color = Color.Black


                )
                Text(
                    text = "⭐$string_rating ($string_customerNumbers)",
                    fontSize = 18.sp,
                    color = Color.Black

                )
                Row (
                    modifier = Modifier.fillMaxWidth().padding(start = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically

                ){
                    Text(
                        text = "₱$full_price",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Black

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

}

