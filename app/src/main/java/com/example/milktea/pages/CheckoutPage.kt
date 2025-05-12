package com.example.milktea.pages

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.widget.Toast
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.UiComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.milktea.R
import com.example.milktea.component.HomeMenu
import com.example.milktea.ui.theme.ColorBtn
import com.example.milktea.ui.theme.Main
import com.example.milktea.ui.theme.MainColorMilk
import org.w3c.dom.Text

@Composable
fun CheckoutPage(modifier: Modifier = Modifier, navController: NavController) {

    val scrollState = rememberScrollState()

    Scaffold(
        containerColor = Main,
        topBar = {
            CheckTopBar(navController = navController)
        },
        bottomBar = {
            HomeMenu(navController = navController, currentpage = "checkout")
        },
        content = {
            innerPadding->
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                content = {
                    Column(
                        modifier = Modifier.verticalScroll(scrollState),
                        content = {
                            Address()
                            PaymentMethod(navController = navController)
                            OrderSummary("Brown Sugar Boba")
                            ListTax()
                            Button(
                                onClick = {
                                    navController.navigate(route = "home")
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 20.dp, vertical = 10.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                                content = {
                                    Text("Place Order", color = Color.White)
                                }
                            )
                        }
                    )

                }
            )
        }
    )
}

@SuppressLint("RestrictedApi")
@Composable
fun CheckTopBar(modifier: Modifier = Modifier, navController: NavController) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(MainColorMilk)
    ){
        IconButton(
            onClick = {
                navController.popBackStack()
            }
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Check out button",
                modifier = Modifier.size(30.dp),
                tint = Color.Black
            )
        }
        Text(
            text = "Checkout",
            fontSize = 20.sp,
        )
    }
}

@Composable
fun ListTax(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .background(color = MainColorMilk, shape = RoundedCornerShape(10.dp)),
        content = {
            Column(
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
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
                        .border(width = 1.dp, color = Color.Gray)
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

@Composable
fun OrderSummary(name: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 10.dp)
            .background(color = MainColorMilk, shape = RoundedCornerShape(10.dp)),
        content = {
            Column{
                Text("Order Summary",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp)
                )
                OrderItem(name = "Brown Sugar Boba", price = 10.0)
                OrderItem(name = "Brown Sugar Boba", price = 10.0)
                OrderItem(name = "Brown Sugar Boba", price = 10.0)
            }
        }
    )

}

@Composable
fun OrderItem(modifier: Modifier = Modifier, name: String, price: Double) {

    val full_price = price.toString()

    Card(
        modifier = Modifier
            .height(80.dp)
            .padding(horizontal = 25.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        shape = RoundedCornerShape(0.dp)


    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Tea Image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .width(100.dp)
                    .height(76.dp)
            )
            Column (
                modifier = Modifier
                    .width(140.dp)
                    .padding(10.dp),
                horizontalAlignment = Alignment.Start
            ){
                Text(
                    text = name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    lineHeight = 30.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.width(130.dp)
                )
                Text(
                    text = "Medium, Less Ice, 75% sugar, extra boba+ puding",
                    fontSize = 10.sp,
                    maxLines = 2,
                    lineHeight = 15.sp,
                    modifier = Modifier.width(150.dp)
                )
            }
            Text(
                text = "₱$full_price",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
            )
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun PaymentMethod(modifier: Modifier = Modifier , navController: NavController){

    val context = LocalContext.current
    var showDialog by remember { mutableStateOf(false) }
    var payment_method by remember { mutableStateOf("GCASH") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .background(color = MainColorMilk, shape = RoundedCornerShape(10.dp)),
        content = {
            Column(
                horizontalAlignment = Alignment.Start
            ){
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    content = {
                        Text("Payment Method",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp)
                        )
                        TextButton(
                            onClick = {
                                showDialog = true
                            },
                            content = {
                                Text("Change", fontSize = 13.sp, color = Color.Black)
                            }
                        )
                    }
                )
                Text(payment_method,
                    maxLines = 2,
                    modifier = Modifier
                        .padding(start = 20.dp, bottom = 20.dp)
                        .width(300.dp)
                )
            }
            if (showDialog) {
                AlertDialog(
                    textContentColor = Color.Black,
                    titleContentColor = Color.Black,
                    containerColor = MainColorMilk,
                    onDismissRequest = { showDialog = false },
                    title = { Text("Select Payment Method") },
                    text = {
                        Column(
                            content = {
                                TextButton(
                                    onClick = {
                                        payment_method = "GCASH"
                                    },
                                    colors = ButtonColors(
                                        containerColor = if (payment_method == "GCASH") ColorBtn else Color.Transparent,
                                        contentColor = Color.Black,
                                        disabledContentColor = Color.Black,
                                        disabledContainerColor = Color.Transparent),
                                    content = {
                                        Text("GCASH",
                                            fontSize = 18.sp,
                                            modifier = Modifier.fillMaxWidth().padding(10.dp))
                                    }
                                )
                                TextButton(
                                    onClick = {
                                        payment_method = "PAYMAYA"
                                    },
                                    colors = ButtonColors(
                                        containerColor = if (payment_method == "PAYMAYA") ColorBtn else Color.Transparent,
                                        contentColor = Color.Black,
                                        disabledContentColor = Color.Black,
                                        disabledContainerColor = Color.Transparent),
                                    content = {
                                        Text("PAYMAYA",
                                            fontSize = 18.sp,
                                            modifier = Modifier.fillMaxWidth().padding(10.dp))
                                    }
                                )
                                TextButton(
                                    onClick = {
                                        payment_method = "COD"
                                    },
                                    colors = ButtonColors(
                                        containerColor = if (payment_method == "COD") ColorBtn else Color.Transparent,
                                        contentColor = Color.Black,
                                        disabledContentColor = Color.Black,
                                        disabledContainerColor = Color.Transparent),
                                    content = {
                                        Text("CASH ON DELIVERY",
                                            fontSize = 18.sp,
                                            modifier = Modifier.fillMaxWidth().padding(10.dp))
                                    }
                                )


                            }
                        )

                    },
                    confirmButton = {
                        Button(
                            onClick = {
                                showDialog = false
                                Toast.makeText(context, "Payment Change SuccessFully", Toast.LENGTH_SHORT).show()
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Red,
                            ),
                        ) {
                            Text("Ok")
                        }
                    },
                    dismissButton = {
                        Button(
                            onClick = { showDialog = false },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Gray,
                            ),
                        ) {
                            Text("Cancel")
                        }
                    }
                )
            }
        }
    )
}

@Composable
fun Address(modifier: Modifier = Modifier) {

    val context = LocalContext.current
    var showDialog by remember { mutableStateOf(false) }
    var address by remember { mutableStateOf("") }

    Spacer(modifier = Modifier.height(10.dp))
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .background(color = MainColorMilk, shape = RoundedCornerShape(10.dp)),
        content = {
            Column(
                horizontalAlignment = Alignment.Start
            ){
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    content = {
                        Text("Delivery Address",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp)
                        )
                        TextButton(
                            onClick = {
                                showDialog = true
                            },
                            content = {
                                Text("Change", fontSize = 13.sp, color = Color.Black)
                            }
                        )
                    }
                )
                Text(address,
                    maxLines = 2,
                    modifier = Modifier
                        .padding(start = 20.dp, bottom = 20.dp)
                        .width(300.dp)
                )
            }

            if (showDialog) {
                AlertDialog(
                    textContentColor = Color.Black,
                    titleContentColor = Color.Black,
                    containerColor = MainColorMilk,
                    onDismissRequest = { showDialog = false },
                    title = { Text("Enter Your Full Address") },
                    text = {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),

                            content = {

                                OutlinedTextField(
                                    colors = TextFieldDefaults.colors(
                                        unfocusedContainerColor = Color.Transparent,
                                        focusedContainerColor = Color.Transparent,
                                        focusedLabelColor = Color.Black,
                                        unfocusedLabelColor = Color.Black,
                                        focusedIndicatorColor = Color.Black,
                                        unfocusedIndicatorColor = Color.Black,
                                        focusedTextColor =  Color.Black,
                                        unfocusedTextColor =  Color.Black,
                                        cursorColor =  Color.Black
                                    ),
                                    value = address,
                                    onValueChange = {address = it },
                                    label = { Text("Full Address") },
                                    placeholder = { Text("e.g., 123 Main St, City, ZIP") },
                                    modifier = Modifier.fillMaxWidth(),
                                    singleLine = false,
                                    maxLines = 4
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                            }
                        )

                    },
                    confirmButton = {
                        Button(
                            onClick = {
                                showDialog = false
                                Toast.makeText(context, "Address Change SuccessFully", Toast.LENGTH_SHORT).show()
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Red,
                            ),
                        ) {
                            Text("Ok")
                        }
                    },
                    dismissButton = {
                        Button(
                            onClick = { showDialog = false },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Gray,
                            ),
                        ) {
                            Text("Cancel")
                        }
                    }
                )
            }
        }
    )
    Spacer(modifier = Modifier.height(10.dp))

}
