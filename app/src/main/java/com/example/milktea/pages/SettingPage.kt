package com.example.milktea.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.milktea.R
import com.example.milktea.component.HomeMenu
import com.example.milktea.component.TopBarHeader
import com.example.milktea.ui.theme.Main
import com.example.milktea.ui.theme.MainColorMilk

@Composable
fun SettingPage(modifier: Modifier = Modifier,navController: NavController) {
    Scaffold(
        containerColor = Main,
        topBar = {
            TopBarHeader(navController = navController, name = "Settings")
        },
        bottomBar = {
            HomeMenu(navController = navController, currentpage = "setting")

        },
        content = {
            innerPadding ->
            Box(
                modifier = Modifier.padding(innerPadding),
                content = {
                    Column(
                        content = {
                            AccountSetting(navController = navController)
                            SupportSetting(navController = navController)
                        }
                    )

                }

            )
        }
    )
}

@Composable
fun AccountSetting(modifier: Modifier = Modifier , navController: NavController){
    var isOn by remember { mutableStateOf(false) }
    val icon = if (isOn) R.drawable.ic_toogle_on else R.drawable.ic_toogle_off
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        content = {
            Column(
                modifier = Modifier.height(195.dp).padding(vertical = 10.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                content = {
                    Text(
                        "Account Settings",
                        fontSize = 22.sp,
                        modifier = Modifier.fillMaxWidth()
                            .background(color = MainColorMilk, shape = RoundedCornerShape(10.dp))
                            .padding(20.dp),
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
                                        imageVector = Icons.Default.Notifications,
                                        contentDescription = "notification"
                                    )
                                    Text("Notification",
                                        fontSize = 18.sp,
                                        modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp)
                                    )
                                }
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                content = {
                                    Text(text = if (isOn) "ON" else "OFF",
                                        fontSize = 15.sp,
                                        modifier = Modifier.padding(vertical = 10.dp, )
                                    )
                                    IconButton(onClick = { isOn = !isOn }) {
                                        Icon(
                                            painter = painterResource(id = icon),
                                            contentDescription = if (isOn) "Toggle On" else "Toggle Off",
                                            modifier = Modifier.size(50.dp),

                                            )
                                    }
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
                                    Text("Language",
                                        fontSize = 18.sp,
                                        modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp)
                                    )
                                }
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                content = {
                                    Text("English",
                                        fontSize = 15.sp,
                                        modifier = Modifier.padding(vertical = 10.dp, )
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

                        }
                    )


                }
            )


        }
    )
}
@Composable
fun SupportSetting(modifier: Modifier = Modifier , navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        content = {
            Column(
                modifier = Modifier.height(200.dp).padding(vertical = 5.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                content = {
                    Text(
                        "Support",
                        fontSize = 22.sp,
                        modifier = Modifier.fillMaxWidth()
                            .background(color = MainColorMilk, shape = RoundedCornerShape(10.dp))
                            .padding(20.dp),
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
                                        imageVector = Icons.Default.Info,
                                        contentDescription = "notification"
                                    )
                                    Text("Help Center",
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
                                        contentDescription = "User",
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
                                    Text("Terms & Privacy",
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
                }
            )


        }
    )
}