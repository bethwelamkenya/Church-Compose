package com.bethwelamkenya.churchcompose.pages

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.startActivity
import com.bethwelamkenya.churchcompose.R
import com.bethwelamkenya.churchcompose.database.DatabaseAdapter
import com.bethwelamkenya.churchcompose.ui.layouts.admin.AdminHomePage
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
//                    AdminHomePage()
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    val context = LocalContext.current
    val accounts = arrayOf("Admin", "Member", "Admin")
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var account by remember { mutableStateOf(accounts[0]) }
    var enabled by remember { mutableStateOf(false) }
    var expanded by remember { mutableStateOf(false) }
    var iconPath by remember { mutableStateOf(R.drawable.visible) }
    var visibility by remember { mutableStateOf(VisualTransformation {
        TransformedText(
            AnnotatedString('\u2022'.toString().repeat(password.length)),
            OffsetMapping.Identity
        )
    }) }
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
            onValueChange = {
                userName = it
                enabled = if (accounts.indexOf(account) == 1){
                    userName.isNotEmpty()
                } else{
                    password.isNotEmpty() && userName.isNotEmpty()
                }
                            },
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
            onValueChange = { 
                password = it
                enabled = if (accounts.indexOf(account) == 1){
                    userName.isNotEmpty()
                } else{
                    password.isNotEmpty() && userName.isNotEmpty()
                }
                            },
            maxLines = 1,
            singleLine = true,
            visualTransformation = visibility,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            label = { Text("Enter Password") },
            trailingIcon = {
                Icon(painter = painterResource(iconPath),
                    contentDescription = "See Password",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable(enabled = password.isNotEmpty(), onClick = {
                            if (visibility == VisualTransformation.None) {
                                visibility = PasswordVisualTransformation()
                                iconPath = R.drawable.visible
                            } else {
                                visibility = VisualTransformation.None
                                iconPath = R.drawable.invisible
                            }
                        })
                )
            }
        )
        Box(modifier = Modifier.constrainAs(accountTypes) {
                top.linkTo(accountText.bottom, 16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp), verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable{
                    expanded = !expanded
                }
            ){
                Text(text = account)
                Icon(painter = painterResource(id = R.drawable.expand_arrow), contentDescription = "Expand", modifier = Modifier.size(20.dp))
            }
            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = !expanded }) {
                accounts.forEach {
                    DropdownMenuItem(text = { Text(text = it) }, onClick = {
                        account = it
                        expanded = !expanded
                    })
                }
            }

        }
        Button(onClick = { logIn(userName, password, account, context) },
            enabled = enabled,
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

fun logIn(userName: String, password: String, account: String, context: Context) {
    val adapter = DatabaseAdapter(context)
    when (account){
        "Admin" -> {
            if (adapter.getAdmin(userName, password) != null){
                val intent = Intent(context, AdminActivity::class.java)
                ActivityCompat.startActivity(context, intent, null)
            } else{
                Toast.makeText(context, "Invalid Details Passed", Toast.LENGTH_SHORT).show()
            }
        }
        "Developer" -> {
            if (userName == "bethu" && password == "9852"){
                val intent = Intent(context, AdminActivity::class.java)
                ActivityCompat.startActivity(context, intent, null)
            } else{
                Toast.makeText(context, "Invalid Details Passed", Toast.LENGTH_SHORT).show()
            }
        }
        else -> {
            if (adapter.getMember(userName).size == 0){
                val intent = Intent(context, AdminActivity::class.java)
                ActivityCompat.startActivity(context, intent, null)
            } else{
                Toast.makeText(context, "Invalid Details Passed", Toast.LENGTH_SHORT).show()
            }

        }
    }
}


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