package com.massana2110.serfinsa_technical_test.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Phone
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.massana2110.serfinsa_technical_test.ui.models.Business
import com.massana2110.serfinsa_technical_test.ui.models.BusinessStates
import com.massana2110.serfinsa_technical_test.ui.theme.nunitoFontFamily
import com.massana2110.serfinsa_technical_test.ui.theme.orangePrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    business: List<Business>,
    onLogoutAction: () -> Unit,
    onAddBusinessAction: () -> Unit
) {
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
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            items(business) { item ->
                BusinessItem(item = item)
            }
        }
    }
}

@Composable
fun BusinessItem(modifier: Modifier = Modifier, item: Business) {
    Card {
        Text(
            text = item.name,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            textAlign = TextAlign.Center,
            fontFamily = nunitoFontFamily,
            fontWeight = FontWeight.Bold
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Phone,
                contentDescription = "",
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = item.contactNumber,
                textAlign = TextAlign.Center,
                fontFamily = nunitoFontFamily
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "",
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = item.contactEmail,
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                fontFamily = nunitoFontFamily,
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = when (item.state) {
                    BusinessStates.ACCEPTED -> Icons.Default.Check
                    BusinessStates.DENIED -> Icons.Default.Clear
                    BusinessStates.REVISION -> Icons.Default.DateRange
                },
                contentDescription = "",
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = when (item.state) {
                    BusinessStates.ACCEPTED -> "Aceptado"
                    BusinessStates.DENIED -> "Denegado"
                    BusinessStates.REVISION -> "En revision"
                },
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                fontFamily = nunitoFontFamily,
            )
        }

        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPrev() {
    HomeScreen(business = listOf(
        Business(
            name = "Banco agricola",
            department = "San Salvador",
            municipality = "San Salvador",
            dui = "000000-0",
            image = null,
            contactNumber = "92938382",
            contactEmail = "lmwciowmwi@gmail.com",
            state = BusinessStates.REVISION
        ),
        Business(
            name = "Banco agricola",
            department = "San Salvador",
            municipality = "San Salvador",
            dui = "000000-0",
            image = null,
            contactNumber = "92938382",
            contactEmail = "lmwciowmwi@gmail.com",
            state = BusinessStates.REVISION
        )
    ), onLogoutAction = {}) {}
}