package com.massana2110.serfinsa_technical_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.massana2110.serfinsa_technical_test.ui.screens.AddBusinessScreen
import com.massana2110.serfinsa_technical_test.ui.screens.HomeScreen
import com.massana2110.serfinsa_technical_test.ui.screens.LoginScreen
import com.massana2110.serfinsa_technical_test.ui.theme.SerfinsatechnicaltestTheme

sealed class Screen(val route: String) {
    data object Login: Screen("login")
    data object Home: Screen("home")
    data object Business: Screen("business")
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SerfinsatechnicaltestTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = Screen.Login.route) {
                    composable(Screen.Login.route) {
                        LoginScreen(
                            onLoginAction = { navController.navigate(Screen.Home.route) }
                        )
                    }
                    composable(Screen.Home.route) {
                        HomeScreen { navController.navigateUp() }
                    }
                    composable(Screen.Business.route) {
                        AddBusinessScreen()
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun ScreenPreview() {
    SerfinsatechnicaltestTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            LoginScreen(modifier = Modifier.padding(innerPadding)) {}
        }
    }
}