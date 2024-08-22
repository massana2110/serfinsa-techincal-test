package com.massana2110.serfinsa_technical_test.ui.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.massana2110.serfinsa_technical_test.ui.models.Business
import com.massana2110.serfinsa_technical_test.ui.models.BusinessStates
import com.massana2110.serfinsa_technical_test.ui.theme.nunitoFontFamily
import com.massana2110.serfinsa_technical_test.ui.theme.orangePrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddBusinessScreen(
    modifier: Modifier = Modifier,
    onSaveBusiness: (Business) -> Unit,
    onNavigateBack: () -> Unit
) {
    var nameBusiness by remember { mutableStateOf("") }
    var departmentBusiness by remember { mutableStateOf("") }
    var municipality by remember { mutableStateOf("") }
    var dui by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var image by remember { mutableStateOf<Uri?>(null) }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        image = uri
    }

    Scaffold(topBar = {
        TopAppBar(title = {
            Text(
                text = "Afiliar comercio",
                fontFamily = nunitoFontFamily,
                fontWeight = FontWeight.Bold
            )
        }, navigationIcon = {
            IconButton(onClick = { onNavigateBack() }) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
        })
    }) { pv ->
        Column(
            modifier = Modifier
                .padding(pv)
                .padding(horizontal = 16.dp)
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                maxLines = 1,
                textStyle = TextStyle(fontSize = 13.sp, fontFamily = nunitoFontFamily),
                label = {
                    Text(
                        text = "Nombre del comercio",
                        fontSize = 13.sp,
                        fontFamily = nunitoFontFamily
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.AccountBox,
                        contentDescription = "Nombre comercio"
                    )
                },
                value = nameBusiness,
                onValueChange = { nameBusiness = it })

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                OutlinedTextField(
                    modifier = Modifier.weight(1f),
                    singleLine = true,
                    maxLines = 1,
                    textStyle = TextStyle(fontSize = 13.sp, fontFamily = nunitoFontFamily),
                    label = {
                        Text(
                            text = "Departamento",
                            fontSize = 13.sp,
                            fontFamily = nunitoFontFamily
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = "Nombre comercio"
                        )
                    },
                    value = departmentBusiness,
                    onValueChange = { departmentBusiness = it })

                OutlinedTextField(
                    modifier = Modifier.weight(1f),
                    singleLine = true,
                    maxLines = 1,
                    textStyle = TextStyle(fontSize = 13.sp, fontFamily = nunitoFontFamily),
                    label = {
                        Text(
                            text = "Municipio",
                            fontSize = 13.sp,
                            fontFamily = nunitoFontFamily
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = "Nombre comercio"
                        )
                    },
                    value = municipality,
                    onValueChange = { municipality = it })
            }

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                singleLine = true,
                maxLines = 1,
                textStyle = TextStyle(fontSize = 13.sp, fontFamily = nunitoFontFamily),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                label = {
                    Text(
                        text = "DUI",
                        fontSize = 13.sp,
                        fontFamily = nunitoFontFamily
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.AccountBox,
                        contentDescription = "DUI"
                    )
                },
                value = dui,
                onValueChange = { dui = it })

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                singleLine = true,
                maxLines = 1,
                textStyle = TextStyle(fontSize = 13.sp, fontFamily = nunitoFontFamily),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                label = {
                    Text(
                        text = "Telefono",
                        fontSize = 13.sp,
                        fontFamily = nunitoFontFamily
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Phone,
                        contentDescription = "DUI"
                    )
                },
                value = phoneNumber,
                onValueChange = { phoneNumber = it })

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                singleLine = true,
                maxLines = 1,
                textStyle = TextStyle(fontSize = 13.sp, fontFamily = nunitoFontFamily),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                label = {
                    Text(
                        text = "Correo electrónico",
                        fontSize = 13.sp,
                        fontFamily = nunitoFontFamily
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "DUI"
                    )
                },
                value = email,
                onValueChange = { email = it })

            TextButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                onClick = { launcher.launch("image/*") },
                colors = ButtonDefaults.textButtonColors(
                    contentColor = orangePrimary
                )
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Adjuntar imagen documento", fontFamily = nunitoFontFamily)
            }

            // Image preview
            AnimatedVisibility(visible = image != null) {
                image?.let { img ->
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        AsyncImage(
                            model = img,
                            modifier = Modifier.size(
                                160.dp
                            ),
                            contentDescription = null,
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }

            Button(
                onClick = {
                    val businessToAdd = Business(
                        name = nameBusiness,
                        department = departmentBusiness,
                        municipality = municipality,
                        dui = dui,
                        contactNumber = phoneNumber,
                        contactEmail = email,
                        image = image,
                        state = BusinessStates.REVISION
                    )
                    onSaveBusiness(businessToAdd)
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = orangePrimary)
            ) {
                Text(
                    text = "Guardar",
                    fontFamily = nunitoFontFamily,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun AddBusinessScreenPrev() {
    AddBusinessScreen(onSaveBusiness = {}) {}
}