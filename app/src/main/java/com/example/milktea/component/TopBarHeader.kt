package com.example.milktea.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.milktea.ui.theme.MainColorMilk

@Composable
fun TopBarHeader(modifier: Modifier = Modifier, name: String, navController: NavController) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
            .background(MainColorMilk)
    ){
        IconButton(
            onClick = {
                navController.navigate(route = "home")
            }
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = name,
                modifier = Modifier.size(30.dp),
                tint = Color.Black
            )
        }
        Text(
            text = name,
            fontSize = 20.sp,
        )
    }
}