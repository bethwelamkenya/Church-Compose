package com.bethwelamkenya.churchcompose.pages

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.bethwelamkenya.churchcompose.ui.layouts.AdminHomePage
import com.bethwelamkenya.churchcompose.ui.theme.ChurchComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChurchComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AdminHomePage()
//                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var account by remember { mutableStateOf("") }
    ConstraintLayout (modifier = Modifier.fillMaxWidth()) {
        // Create references for the composables to constrain
        val (submit, forgotText, forgotLink, accountTypes, accountText, passwordText,
            passwordField, userNameText, userNameField, logInLabel, accountIcon, churchLabel,
            churchIcon) = createRefs()

        Image(
            modifier = Modifier
                .size(75.dp)
                .constrainAs(churchIcon) {
                    top.linkTo(parent.top, 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            alignment = Alignment.Center,
            painter = painterResource(id = R.drawable.church),
            contentDescription = "Church Logo")
        Text(text = "Welcome Back $name!",
            fontSize = 24.sp,
            modifier = Modifier.constrainAs(churchLabel){
                top.linkTo(churchIcon.bottom, 32.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
        Text(text = "Log In",
            fontSize = 24.sp,
            modifier = Modifier.constrainAs(logInLabel){
                top.linkTo(churchLabel.bottom, 32.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
        Icon(
            painterResource(id = R.drawable.contacts), contentDescription = "Account Icon",
            modifier = Modifier
                .constrainAs(accountIcon) {
                    top.linkTo(churchLabel.bottom)
                    bottom.linkTo(userNameText.top)
                    start.linkTo(parent.start, 32.dp)
                }
                .size(40.dp)
        )
        Text(text = "User Name",
            modifier = Modifier.constrainAs(userNameText){
                top.linkTo(logInLabel.bottom, 16.dp)
                start.linkTo(parent.start, 32.dp)
            }
        )
        Text(text = "Password",
            modifier = Modifier.constrainAs(passwordText){
                top.linkTo(userNameField.bottom, 16.dp)
                start.linkTo(parent.start, 32.dp)
            }
        )
        Text(text = "Account Type",
            modifier = Modifier.constrainAs(accountText){
                top.linkTo(passwordField.bottom, 16.dp)
                start.linkTo(parent.start, 32.dp)
            }
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(0.9F)
                .constrainAs(userNameField) {
                    top.linkTo(userNameText.bottom, 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            value = userName,
            onValueChange = { userName = it },
            maxLines = 1,
            singleLine = true,
            label = { Text("Enter your name") }
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(0.9F)
                .constrainAs(passwordField) {
                    top.linkTo(passwordText.bottom, 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            value = password,
            onValueChange = { password = it },
            maxLines = 1,
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            label = { Text("Enter Password") }
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(0.9F)
                .constrainAs(accountTypes) {
                    top.linkTo(accountText.bottom, 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            value = account,
            onValueChange = { account = it },
            maxLines = 1,
            singleLine = true,
            label = { Text("Enter Password") }
        )
        Button(onClick = { logIn() },
            modifier = Modifier
                .constrainAs(submit) {
                    top.linkTo(accountTypes.bottom, 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(forgotText.top, 16.dp)
                }
                .height(75.dp)) {
            Icon(painterResource(id = R.drawable.login_rounded_right), contentDescription = "Account Icon")
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Log In", fontSize = 24.sp)
        }
        Text(text = "Forgot Password?",
            fontSize = 20.sp,
            modifier = Modifier.constrainAs(forgotText) {
                bottom.linkTo(parent.bottom, margin = 32.dp)
                start.linkTo(parent.start, margin = 32.dp)
            }
        )
        Text(text = "Reset Password",
            fontSize = 20.sp,
            modifier = Modifier.constrainAs(forgotLink) {
                end.linkTo(parent.end, margin = 32.dp)
                start.linkTo(forgotText.end, 32.dp)
                bottom.linkTo(parent.bottom, margin = 32.dp)
            },
            color = MaterialTheme.colorScheme.tertiary,
            textDecoration = TextDecoration.Underline
        )
    }
}

fun validateData(){

}

fun logIn(){}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialog(){
    AlertDialog(
        onDismissRequest = { },
        content = {
            Text(text = "Hello There!!")
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ChurchComposeTheme {
        Greeting("Android")
    }
}