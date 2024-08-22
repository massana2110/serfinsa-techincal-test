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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.massana2110.serfinsa_technical_test.ui.models.Business
import com.massana2110.serfinsa_technical_test.ui.screens.AddBusinessScreen
import com.massana2110.serfinsa_technical_test.ui.screens.HomeScreen
import com.massana2110.serfinsa_technical_test.ui.screens.LoginScreen
import com.massana2110.serfinsa_technical_test.ui.theme.SerfinsatechnicaltestTheme

sealed class Screen(val route: String) {
    data object Login : Screen("login")
    data object Home : Screen("home")
    data object Business : Screen("business")
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SerfinsatechnicaltestTheme {
                val navController = rememberNavController()
                val business = remember {
                    mutableStateListOf<Business>()
                }

                NavHost(navController = navController, startDestination = Screen.Login.route) {
                    composable(Screen.Login.route) {
                        LoginScreen(
                            onLoginAction = { navController.navigate(Screen.Home.route) }
                        )
                    }
                    composable(Screen.Home.route) {
                        HomeScreen(
                            business = business,
                            onLogoutAction = { navController.navigateUp() },
                            onAddBusinessAction = { navController.navigate(Screen.Business.route) })
                    }
                    composable(Screen.Business.route) {
                        AddBusinessScreen {
                            business.add(it)
                            navController.navigateUp()
                        }
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