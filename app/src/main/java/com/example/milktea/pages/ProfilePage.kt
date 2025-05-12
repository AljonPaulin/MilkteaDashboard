package com.example.milktea.pages

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.milktea.component.HomeMenu
import com.example.milktea.component.TopBarHeader
import com.example.milktea.ui.theme.ColorBtn
import com.example.milktea.ui.theme.Main
import com.example.milktea.ui.theme.MainColorMilk

@Composable
fun ProfilePage(modifier: Modifier = Modifier, navController: NavController) {
    Scaffold(
        containerColor = Main,
        topBar = {
            TopBarHeader(navController = navController, name = "Profile")
        },
        bottomBar = {
            HomeMenu(navController = navController, currentpage = "profile")

        },
        content = {
                innerPadding ->
            Box(
                modifier = Modifier.padding(innerPadding),
                content = {
                    ProfileMenu(navController = navController)
                }

            )
        }
    )
}

@Composable
fun ProfileMenu(modifier: Modifier = Modifier , navController: NavController){

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        content = {
            Column(
                modifier = Modifier.height(490.dp).padding(vertical = 10.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                content = {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .background(color = MainColorMilk, shape = RoundedCornerShape(10.dp))
                            .padding(horizontal = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        content = {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "User",
                                modifier = Modifier.size(60.dp).background(color = ColorBtn).padding(horizontal = 10.dp)
                            )
                            Column(
                                modifier = Modifier.fillMaxWidth().
                                            height(90.dp),
                                verticalArrangement = Arrangement.Center,
                                content = {
                                    Text("John Smith",
                                        fontSize = 18.sp,
                                        modifier = Modifier.padding(horizontal = 20.dp)
                                    )
                                    Text("jhohnsmith@gmail.com",
                                        fontSize = 12.sp,
                                        modifier = Modifier.padding(horizontal = 20.dp)
                                    )
                                }
                            )
                        }
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .background(color = MainColorMilk, shape = RoundedCornerShape(10.dp))
                            .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        content = {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                content = {
                                    Icon(
                                        imageVector = Icons.Default.Person,
                                        contentDescription = "User"
                                    )
                                    Text("Edit Profile",
                                        fontSize = 18.sp,
                                        modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp)
                                    )
                                }
                            )
                            IconButton(
                                onClick = {
                                },
                                content = {
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                        contentDescription = "User"
                                    )
                                }
                            )
                        }
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .background(color = MainColorMilk, shape = RoundedCornerShape(10.dp))
                            .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        content = {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                content = {
                                    Icon(
                                        imageVector = Icons.Default.LocationOn,
                                        contentDescription = "Address"
                                    )
                                    Text("Delivery Address",
                                        fontSize = 18.sp,
                                        modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp)
                                    )
                                }
                            )
                            IconButton(
                                onClick = {
                                },
                                content = {
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                        contentDescription = "User"
                                    )
                                }
                            )
                        }
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .background(color = MainColorMilk, shape = RoundedCornerShape(10.dp))
                            .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        content = {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                content = {
                                    Icon(
                                        imageVector = Icons.Default.MailOutline,
                                        contentDescription = "Payment"
                                    )
                                    Text("Payment Methods",
                                        fontSize = 18.sp,
                                        modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp)
                                    )
                                }
                            )
                            IconButton(
                                onClick = {
                                },
                                content = {
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                        contentDescription = "User"
                                    )
                                }
                            )
                        }
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .background(color = MainColorMilk, shape = RoundedCornerShape(10.dp))
                            .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        content = {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                content = {
                                    Icon(
                                        imageVector = Icons.Default.DateRange,
                                        contentDescription = "History"
                                    )
                                    Text("Order History",
                                        fontSize = 18.sp,
                                        modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp)
                                    )
                                }
                            )
                            IconButton(
                                onClick = {
                                },
                                content = {
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                        contentDescription = "User"
                                    )
                                }
                            )
                        }
                    )
                    Button(
                        onClick = {
                            navController.navigate(route = "home")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                        content = {
                            Text("Sign Out",
                                color = Color.White,
                                modifier = Modifier.padding(vertical = 7.dp)
                            )
                        }
                    )
                }
            )


        }
    )
}