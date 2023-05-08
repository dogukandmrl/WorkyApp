package com.example.workyapp.screen

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
fun RegisterScreen(navController: NavController) {
    Row(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column {
            LogoSection()
            TextFieldSection()
            ButtonSection(navController)
        }

    }
}

@Composable
fun TextFieldSection() {
    val tfEmailSignUp = remember { mutableStateOf("") }
    val tfPasswordSignUp = remember { mutableStateOf("") }
    val tfPasswordConfirm = remember { mutableStateOf("") }
    OutlinedTextField(
        singleLine = true,
        maxLines = 1,
        value = tfEmailSignUp.value,
        onValueChange = {
            tfEmailSignUp.value = it
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
        value = tfPasswordSignUp.value,
        onValueChange = {
            tfPasswordSignUp.value = it
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
            Text(text = "Password...", color = Color.Gray)

        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color.White,
            focusedLabelColor = AquaBlue
        )

    )
    OutlinedTextField(
        singleLine = true,
        maxLines = 1,
        value = tfPasswordConfirm.value,
        onValueChange = {
            tfPasswordConfirm.value = it
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
            Text(text = "Email...", color = Color.Gray)

        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color.White,
            focusedLabelColor = AquaBlue
        )
    )
}

@Composable
fun ButtonSection(navController: NavController) {
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
            onClick = { navController.navigate("loginScreen") }
        ) {
            Text(text = "Register", color = Color.Blue, style = MaterialTheme.typography.h1)
        }

    }
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text(text = "Already have an account ? ")
        TextButton(onClick = {navController.navigate("loginScreen") }) {
            Text(text = "Sign In")
        }
    }
}