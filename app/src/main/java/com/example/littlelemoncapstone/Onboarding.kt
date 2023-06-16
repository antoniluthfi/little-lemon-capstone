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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

val karlaFont = FontFamily(Font(R.font.karla_regular))

@Composable
fun OnboardingForm(navController: NavHostController) {
    val context = LocalContext.current
    val userPreferences = remember {
        UserPreferences(context)
    }

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var showErrorDialog by remember { mutableStateOf(false) }
    var showSuccessDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
            .padding(top = 40.dp)
    ) {
        Text(
            text = "Personal Information",
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = karlaFont,
        )

        Column(modifier = Modifier.padding(top = 40.dp)) {
            Text(
                text = "First Name",
                fontWeight = FontWeight.Bold,
                fontFamily = karlaFont,
                color = colorResource(R.color.primary),
                modifier = Modifier.padding(bottom = 5.dp)
            )
            TextField(
                value = firstName,
                onValueChange = { firstName = it },
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
                keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words)
            )
        }

        Column(modifier = Modifier.padding(top = 30.dp)) {
            Text(
                text = "Last Name",
                fontWeight = FontWeight.Bold,
                fontFamily = karlaFont,
                color = colorResource(R.color.primary),
                modifier = Modifier.padding(bottom = 5.dp)
            )
            TextField(
                value = lastName,
                onValueChange = { lastName = it },
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
                keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words)
            )
        }

        Column(modifier = Modifier.padding(top = 30.dp)) {
            Text(
                text = "Email",
                fontWeight = FontWeight.Bold,
                fontFamily = karlaFont,
                color = colorResource(R.color.primary),
                modifier = Modifier.padding(bottom = 5.dp)
            )
            TextField(
                value = email,
                onValueChange = { email = it },
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
                onClick = {
                    if (firstName.isBlank() || lastName.isBlank() || email.isBlank()) {
                        showErrorDialog = true
                    } else {
                        CoroutineScope(Dispatchers.IO).launch {
                            userPreferences.setUserData(firstName, lastName, email)
                        }

                        showSuccessDialog = true
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(R.color.yellow)
                )
            ) {
                Text(
                    text = "Register",
                    color = Color.Black,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = karlaFont
                )
            }

            if (showErrorDialog) {
                AlertDialog(
                    onDismissRequest = { /*TODO*/ },
                    title = { Text("Failed") },
                    text = { Text("Registration unsuccessful. Please enter all data.") },
                    confirmButton = {
                        Button(
                            onClick = { showErrorDialog = false },
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = colorResource(R.color.yellow)
                            ),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(text = "OK", fontFamily = karlaFont)
                        }
                    })
            }

            if (showSuccessDialog) {
                AlertDialog(
                    onDismissRequest = { /*TODO*/ },
                    title = { Text("Success") },
                    text = { Text("Registration successful!") },
                    confirmButton = {
                        Button(
                            onClick = {
                                showSuccessDialog = false
                                navController.navigate(Home.route)
                            },
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = colorResource(R.color.yellow)
                            ),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(text = "OK", fontFamily = karlaFont)
                        }
                    })
            }
        }
    }
}

@Composable
fun OnboardingScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(bottom = 30.dp)
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
                .background(color = colorResource(R.color.primary)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Let's get to know you",
                fontSize = 30.sp,
                color = Color.White,
                fontFamily = karlaFont
            )
        }

        OnboardingForm(navController)
    }
}
