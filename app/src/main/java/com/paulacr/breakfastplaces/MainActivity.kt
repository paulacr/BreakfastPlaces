package com.paulacr.breakfastplaces

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.paulacr.breakfastplaces.photo.Picture
import com.paulacr.breakfastplaces.ui.theme.BreakfastPlacesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "start") {
                composable("start") { Extracted { navController.navigate("picture") } }
                composable("picture") { Picture() }
            }
        }
    }

    @Composable
    private fun Extracted(openCamera: () -> Unit) {
        BreakfastPlacesTheme {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                Greeting("Android", openCamera)
            }
        }
    }
}

@Composable
fun Greeting(name: String, openCamera: () -> Unit) {

    Column {
        Text(text = "Hello $name!")

        Button(onClick = openCamera) {
            Text(text = "Take picture")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BreakfastPlacesTheme {
        Greeting("Android", {})
    }
}