package com.example.milktea.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.text.font.FontFamily
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
fun CartPage(modifier: Modifier = Modifier, navController: NavController) {
    val scrollState = rememberScrollState()

    Scaffold(
        containerColor = Main,
        topBar = {
            TopBarHeader(name = "My Cart", navController = navController)
        },
        bottomBar = {
            HomeMenu(navController = navController, currentpage = "cart")
        },
        content = {
            innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(innerPadding)
                    .padding(vertical = 10.dp),
                content = {
                    Column(
                        modifier = Modifier.verticalScroll(scrollState),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        content = {
                            OrderDrinkCard("Brown Sugar Boba", 100, 4.8, 30)
                            OrderDrinkCard("Brown Sugar Boba", 100, 4.8, 30)
                            OrderDrinkCard("Brown Sugar Boba", 100, 4.8, 30)
                            OrderDrinkCard("Brown Sugar Boba", 100, 4.8, 30)
                            OrderDrinkCard("Brown Sugar Boba", 100, 4.8, 30)
                            TaxInfo()
                            Button(
                                onClick = {
                                    navController.navigate(route = "checkout_page")
                                },
                                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 10.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                                content = {
                                    Text("CHECK OUT", color = Color.White)
                                }
                            )
                        }
                    )

                }
            )
        }
    )
}

@Composable
fun OrderDrinkCard(name: String, price: Int, rating: Double, customerNumbers: Int) {
    val full_price = price.toString()
    val string_rating = rating.toString()
    val string_customerNumbers = customerNumbers.toString()
    var count by remember { mutableStateOf(0) }

    Card(
        modifier = Modifier
            .height(105.dp)
            .padding(horizontal = 25.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(contentColor = Color.Black),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Tea Image",
                modifier = Modifier.width(120.dp),
                contentScale = ContentScale.FillBounds
            )
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = MainColorMilk)
                    .padding(10.dp),
                horizontalAlignment = Alignment.Start
            ){
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    content = {
                        Text(
                            text = name,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            lineHeight = 30.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.width(150.dp)
                        )
                        IconButton(
                            onClick = { },
                            modifier = Modifier.height(20.dp),
                            content = {
                                Icon(
                                    imageVector = Icons.Default.Clear,
                                    contentDescription = "Delete Button"
                                )
                            }
                        )
                    }
                )


                Text(
                    text = "Medium, Less Ice, 75% sugar, extra boba+ puding",
                    fontSize = 11.sp,
                    maxLines = 2,
                    lineHeight = 15.sp

                )
                Row (
                    modifier = Modifier.fillMaxWidth().padding( end = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically

                ){
                    Text(
                        text = "₱$full_price",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp

                    )
                    Row(
                        modifier = Modifier.width(100.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ){
                        OutlinedButton(
                            onClick = { if(count > 0) count-- },
                            contentPadding = PaddingValues(1.dp),
                            modifier = Modifier.size(25.dp),
                            colors = ButtonDefaults.buttonColors(contentColor = Color.Black, containerColor = Color.Transparent, ),
                            border = BorderStroke(1.dp, Color.Black)
                        ) {
                            Text("-", fontWeight = FontWeight.Bold)
                        }
                        Text(count.toString(), fontWeight = FontWeight.Bold)
                        OutlinedButton(
                            onClick = { count++ },
                            contentPadding = PaddingValues(1.dp),
                            modifier = Modifier.size(25.dp),
                            colors = ButtonDefaults.buttonColors(contentColor = Color.Black, containerColor = Color.Transparent, ),
                            border = BorderStroke(1.dp, Color.Black)
                        ) {
                            Text("+", fontWeight = FontWeight.Bold)
                        }
                    }

                }

            }
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun TaxInfo(modifier: Modifier = Modifier) {
    Box(
        content = {
            Column(
                modifier = Modifier.padding(horizontal = 20.dp),
                content = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 5.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        content = {
                            Text(
                                text = "Subtotal",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black

                            )
                            Text(
                                text = "₱150.0",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                        }
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 5.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        content = {
                            Text(
                                text = "Tax",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black

                            )
                            Text(
                                text = "₱40.0",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                        }
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 5.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        content = {
                            Text(
                                text = "Delivery Fee",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black

                            )
                            Text(
                                text = "₱50.0",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                        }
                    )
                    Spacer(modifier = Modifier
                        .fillMaxWidth()
                        .border(width = 1.dp, color = Color.Black)
                        .height(1.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        content = {
                            Text(
                                text = "Total",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black

                            )
                            Text(
                                text = "₱50.0",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                        }
                    )
                }
            )
        }
    )

}