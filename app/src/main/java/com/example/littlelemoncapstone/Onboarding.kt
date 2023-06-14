package com.example.littlelemoncapstone

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val karlaFont = FontFamily(Font(R.font.karla_regular))

@Composable
fun Form() {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp)
            .padding(top = 50.dp)
    ) {
        Text(
            text = "Personal Information",
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = karlaFont,
        )

        Column(modifier = Modifier.padding(top = 50.dp)) {
            Text(
                text = "First Name",
                fontWeight = FontWeight.Bold,
                fontFamily = karlaFont,
                color = Color(R.color.primary),
                modifier = Modifier.padding(bottom = 5.dp)
            )
            TextField(
                value = firstName,
                onValueChange = { firstName = it },
                label = { Text(text = "First Name") },
                placeholder = { Text(text = "Type your first name") },
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = Color.Gray,
                        shape = RoundedCornerShape(8.dp)
                    ),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    backgroundColor = Color.White
                ),
            )
        }

        Column(modifier = Modifier.padding(top = 30.dp)) {
            Text(
                text = "Last Name",
                fontWeight = FontWeight.Bold,
                fontFamily = karlaFont,
                color = Color(R.color.primary),
                modifier = Modifier.padding(bottom = 5.dp)
            )
            TextField(
                value = lastName,
                onValueChange = { lastName = it },
                label = { Text(text = "Last Name") },
                placeholder = { Text(text = "Type your last name") },
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = Color.Gray,
                        shape = RoundedCornerShape(8.dp)
                    ),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    backgroundColor = Color.White
                ),
            )
        }

        Column(modifier = Modifier.padding(top = 30.dp)) {
            Text(
                text = "Email",
                fontWeight = FontWeight.Bold,
                fontFamily = karlaFont,
                color = Color(R.color.primary),
                modifier = Modifier.padding(bottom = 5.dp)
            )
            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text(text = "Email") },
                placeholder = { Text(text = "Type your email address") },
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = Color.Gray,
                        shape = RoundedCornerShape(8.dp)
                    ),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    backgroundColor = Color.White
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )
        }

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(R.color.yellow)
                )
            ) {
                Text(text = "Register", color = Color.White, fontFamily = karlaFont)
            }
        }
    }
}

@Composable
fun Onboarding() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .width(250.dp)
                    .aspectRatio(3f)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(color = Color(R.color.primary)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Let's get to know you",
                fontSize = 30.sp,
                color = Color.White,
                fontFamily = karlaFont
            )
        }

        Form()
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingPreview() {
    Onboarding()
}