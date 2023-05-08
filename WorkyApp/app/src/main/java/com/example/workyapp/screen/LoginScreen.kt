package com.example.workyapp.screen

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.workyapp.R
import com.example.workyapp.navigation.Navigation
import com.example.workyapp.ui.theme.AquaBlue
import com.example.workyapp.ui.theme.ButtonBlue
import com.example.workyapp.ui.theme.DeepBlue


@Composable
fun LoginScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column {
            LogoSection()
            EmailPasswordSection()
            LogResButtonSection(navController)
        }
    }
}

@Composable
fun LogoSection() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.baseline_school_24),
            contentDescription = "",
            modifier = Modifier
                .padding(top = 50.dp)
                .size(height = 150.dp, width = 150.dp)
        )
        Text(
            text = "Worky",
            color = Color.White,
            style = MaterialTheme.typography.h4
        )
    }
}

@Composable
fun EmailPasswordSection() {
    val tfEmail = remember { mutableStateOf("") }
    val tfPassword = remember { mutableStateOf("") }
    OutlinedTextField(
        singleLine = true,
        maxLines = 1,
        value = tfEmail.value,
        onValueChange = {
            tfEmail.value = it
        },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_email),
                contentDescription = "",
                tint = Color.White
            )
        },
        label = {
            Text(text = "Email...", color = Color.Gray)

        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color.White,
            focusedLabelColor = AquaBlue
        )
    )
    OutlinedTextField(
        singleLine = true,
        maxLines = 1,
        value = tfPassword.value,
        onValueChange = {
            tfPassword.value = it
        },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_password),
                contentDescription = "",
                tint = Color.White
            )
        },
        label = {
            Text(text = "Password...")
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color.White,
            focusedLabelColor = AquaBlue
        )
    )
}

@Composable
fun LogResButtonSection(navController: NavController) {
    Row(
        modifier = Modifier
            .padding(top = 5.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        OutlinedButton(modifier = Modifier
            .padding(bottom = 10.dp)
            .width(200.dp)
            .height(50.dp),
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(4.dp, ButtonBlue),
            onClick = { navController.navigate("homeScreen") }
        ) {
            Text(text = "Login", color = Color.Blue, style = MaterialTheme.typography.h1)
        }

    }
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text(text = "Don't have an account ? ")
        TextButton(onClick = {navController.navigate("registerScreen")}) {
            Text(text = "Sign Up")
        }
    }
}

