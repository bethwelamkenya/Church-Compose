package com.bethwelamkenya.churchcompose.pages

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.bethwelamkenya.churchcompose.ui.layouts.admin.AdminHomePage
import com.bethwelamkenya.churchcompose.ui.layouts.admin.AdminMainPage
import com.bethwelamkenya.churchcompose.ui.layouts.admin.ToolBar
import com.bethwelamkenya.churchcompose.ui.theme.ChurchComposeTheme

class AdminActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChurchComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    val status = if (checkInternetConnectivity(LocalContext.current)){
        ""
    } else{
        " Not"
    }
    Column {
        ToolBar("Bethwel", " $status")
        Text(text = "Hello $name!")
        AdminMainPage()
    }
}

private fun checkInternetConnectivity(context: Context): Boolean{
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
        val network = connectivityManager.activeNetwork ?: return false
        val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false
        return when{
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            else -> false
        }
    } else{
        val networkInfo = connectivityManager.activeNetworkInfo ?: return false
        return networkInfo.isConnected
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ChurchComposeTheme {
        Greeting2("Android")
    }
}