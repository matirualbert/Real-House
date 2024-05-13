package com.example.realhouse.ui.theme.screens.registration

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.realhouse.data.AuthViewModel
import com.example.realhouse.navigation.ROUTE_LOGIN
import com.example.realhouse.ui.theme.Blackmatte
import com.example.realhouse.ui.theme.Bliss
import com.example.realhouse.ui.theme.Pink

@Composable
fun Register(navController: NavHostController) {
        var name by remember { mutableStateOf(TextFieldValue("")) }
        var email by remember { mutableStateOf(TextFieldValue("")) }
        var password by remember { mutableStateOf(TextFieldValue("")) }
        var confirm by remember { mutableStateOf(TextFieldValue("")) }
        val context= LocalContext.current
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Bliss),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = "Sign Up",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Default,
                fontSize = 30.sp)
            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = name, onValueChange = { name = it },
                label = { Text(color = Color.White, text = "Full Name") },
                shape = RoundedCornerShape(30.dp),
                leadingIcon ={ Icon(imageVector = Icons.Default.Person, contentDescription = "email") },
                keyboardOptions = KeyboardOptions . Default . copy (imeAction = ImeAction.Next),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedLeadingIconColor = Pink,
                    unfocusedBorderColor = Pink,
                )
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = email, onValueChange = { email = it },
                label = { Text(color = Color.White, text = "Enter Email") },
                shape = RoundedCornerShape(30.dp),
                leadingIcon ={ Icon(imageVector = Icons.Default.Email, contentDescription = "email") },
                keyboardOptions = KeyboardOptions . Default . copy (imeAction = ImeAction.Next),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedLeadingIconColor = Pink,
                    unfocusedBorderColor = Pink,
                ),
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = password, onValueChange = { password = it },
                label = { Text(color = Color.White, text = "Password") },
                shape = RoundedCornerShape(30.dp),
                leadingIcon ={ Icon(imageVector = Icons.Default.Lock, contentDescription = "password") },
                keyboardOptions = KeyboardOptions . Default . copy (imeAction = ImeAction.Next),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Pink,
                    unfocusedLeadingIconColor = Pink,
                )
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = confirm, onValueChange = { confirm = it },
                label = { Text(color= Color.White ,text = "Confirm Password") },
                shape = RoundedCornerShape(30.dp),
                leadingIcon ={ Icon(imageVector = Icons.Default.Lock, contentDescription = "password") },
                keyboardOptions = KeyboardOptions . Default . copy (imeAction = ImeAction.Next),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Pink,
                    unfocusedLeadingIconColor = Pink,
                )

            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {
                val myregister= AuthViewModel(navController,context)
                myregister.signup(email.text.trim(),password.text.trim(),confirm.text.trim())
            }, modifier = Modifier.size(width = 350.dp, height = 35.dp), colors = ButtonDefaults.buttonColors(Color.Black)) {
                Text(color = Color.White, text = "Sign Up ")
            }
            TextButton(onClick = { navController.navigate(ROUTE_LOGIN)},
                colors = ButtonDefaults.buttonColors(containerColor = Color.Unspecified),
                modifier = Modifier.size(width = 250.dp, height = 35.dp)
            ) {
                Text(text = "Already a user? Login",
                    fontSize = 15.sp,
                    color = Color.Black)
            }
        }

    Spacer(modifier = Modifier.height(20.dp))
    }
@Preview
@Composable
private  fun RegisterPreview() {
    Register(rememberNavController())
}