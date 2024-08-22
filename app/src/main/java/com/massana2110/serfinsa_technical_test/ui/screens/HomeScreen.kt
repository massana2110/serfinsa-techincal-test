package com.massana2110.serfinsa_technical_test.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.massana2110.serfinsa_technical_test.ui.models.Business
import com.massana2110.serfinsa_technical_test.ui.theme.nunitoFontFamily
import com.massana2110.serfinsa_technical_test.ui.theme.orangePrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onLogoutAction: () -> Unit,
    onAddBusinessAction: () -> Unit
) {
    val affiliatedBusiness = remember {
        mutableStateListOf<Business>()
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onAddBusinessAction() },
                containerColor = orangePrimary,
                contentColor = Color.White
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            }
        },
        topBar = {
            TopAppBar(title = {
                Text(
                    text = "Comercios",
                    fontFamily = nunitoFontFamily,
                    fontWeight = FontWeight.Bold
                )
            }, actions = {
                IconButton(onClick = { onLogoutAction() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                        contentDescription = "Logout"
                    )
                }
            })
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            items(affiliatedBusiness.toList()) {

            }
        }
    }
}

@Composable
fun BussinessItem(modifier: Modifier = Modifier, item: Business) {
    Card {
        Text(text = item.name)
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPrev() {
    HomeScreen(onLogoutAction = {}) {}
}