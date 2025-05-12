package com.example.milktea.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.milktea.R

@Composable
fun WelcomePage(modifier: Modifier = Modifier , navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Background Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
        Column (
            modifier = Modifier.align(Alignment.Center).padding(horizontal = 10.dp)
        ){
            Moto(moto = "Milk Tea That")
            Moto(moto = "Tastes Like Hype")
            StartBtn(navController)
        }
    }
}

@Composable
private fun StartBtn(navController: NavController) {
    Button(
        onClick = { navController.navigate(route = "home") },
        colors = ButtonDefaults.buttonColors(Color.Black),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("ORDER NOW")
    }
}

@Composable
private fun Moto(modifier: Modifier = Modifier, moto : String) {
    Text(
        moto,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )
}

