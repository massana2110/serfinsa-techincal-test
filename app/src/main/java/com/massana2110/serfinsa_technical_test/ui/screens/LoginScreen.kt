package com.massana2110.serfinsa_technical_test.ui.screens

import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.massana2110.serfinsa_technical_test.R
import com.massana2110.serfinsa_technical_test.ui.theme.darkNeutral1
import com.massana2110.serfinsa_technical_test.ui.theme.darkNeutral2
import com.massana2110.serfinsa_technical_test.ui.theme.darkNeutral3
import com.massana2110.serfinsa_technical_test.ui.theme.grayNeutral
import com.massana2110.serfinsa_technical_test.ui.theme.grayNeutral2
import com.massana2110.serfinsa_technical_test.ui.theme.nunitoFontFamily
import com.massana2110.serfinsa_technical_test.ui.theme.orangePrimary
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }

    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.serfinsa_logo),
            contentDescription = "Serfinsa",
            modifier = Modifier.size(250.dp)
        )

        Text(
            text = "¡Bienvenido!",
            fontSize = 30.sp,
            fontFamily = nunitoFontFamily,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(32.dp))
        LoginInput(
            value = email,
            placeHolder = "example@correo.com",
            label = "Correo electrónico",
            onTextChanged = { email = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        Spacer(modifier = Modifier.height(16.dp))
        LoginInput(
            value = password,
            label = "Contraseña",
            placeHolder = "●●●●●●●●●",
            onTextChanged = { password = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = {
                coroutineScope.launch {
                    isLoading = true
                    if (loginAction(email, password)) {
                        delay(3000)
                        isLoading = false
                    } else {
                        isLoading = false
                        Toast.makeText(context, "Error al iniciar sesion", Toast.LENGTH_SHORT).show()
                    }
                }
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = orangePrimary)
        ) {
            if (!isLoading) {
                Text(
                    text = "Iniciar sesión",
                    fontFamily = nunitoFontFamily,
                    fontWeight = FontWeight.Bold
                )
            } else {
                CircularProgressIndicator(modifier = Modifier.size(24.dp), color = Color.White)
            }
        }
    }
}

fun loginAction(email: String, password: String): Boolean {
    return if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) false
    else if (password.isEmpty()) false
    else true
}

@Composable
fun LoginInput(
    value: String,
    modifier: Modifier = Modifier,
    placeHolder: String,
    label: String,
    onTextChanged: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    var inputBorderWithValue by remember {
        mutableStateOf(grayNeutral2)
    }
    var inputContainerWithValue by remember {
        mutableStateOf(Color(0xFFF0F2F5))
    }

    Column(modifier = modifier) {
        Text(
            text = label,
            fontFamily = nunitoFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = grayNeutral,
        )
        Surface(
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, inputBorderWithValue), // Change the color as needed
            color = inputContainerWithValue,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            TextField(
                value = value,
                onValueChange = {
                    onTextChanged(it)
                    if (it.isBlank()) {
                        inputBorderWithValue = grayNeutral
                        inputContainerWithValue = Color(0xFFF0F2F5)
                    } else {
                        inputBorderWithValue = orangePrimary
                        inputContainerWithValue = grayNeutral2
                    }
                },
                placeholder = { Text(text = placeHolder, color = darkNeutral3) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                maxLines = 1,
                keyboardOptions = keyboardOptions,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedPlaceholderColor = grayNeutral2,
                    unfocusedPlaceholderColor = grayNeutral2,
                ),
                visualTransformation = visualTransformation
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    LoginScreen()
}