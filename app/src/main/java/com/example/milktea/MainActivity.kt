package com.example.milktea

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.milktea.navigation.MilkteaNavigation
import com.example.milktea.ui.theme.MilkteaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MilkteaTheme {
                MilkteaNavigation()
            }
        }
    }
}
