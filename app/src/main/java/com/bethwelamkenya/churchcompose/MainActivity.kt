package com.bethwelamkenya.churchcompose

import android.media.Image
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    var userName = ""
    var password = ""
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Image(painter = painterResource(id = R.drawable.church), contentDescription = "Church Logo")
        Text(text = "Welcome Back $name!")
        Spacer(modifier = Modifier.height(10.dp))
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "User Name")
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            modifier = Modifier.height(10.dp),
            value = userName,
            onValueChange = { userName = it },
            label = { Text("Enter your name") }
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Password")
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Enter Password") }
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { login() }) {
            Text(text = name)
        }
    }
}

fun validateData(){

}

fun login(){

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ChurchComposeTheme {
        Greeting("Android")
    }
}