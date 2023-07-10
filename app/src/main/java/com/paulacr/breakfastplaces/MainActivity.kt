package com.paulacr.breakfastplaces

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.paulacr.breakfastplaces.photo.Picture
import com.paulacr.breakfastplaces.ui.theme.BreakfastPlacesTheme
import dagger.hilt.android.AndroidEntryPoint

private const val NAV_ROUTE_START = "start"
private const val NAV_ROUTE_PICTURE = "picture"

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BreakfastPlacesTheme {
                val navController = rememberNavController()
                NavHost(navController = navController)
            }
        }
    }
}

@Composable
fun NavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NAV_ROUTE_START) {
        composable(NAV_ROUTE_START) {
            SavePlaceScreen {
                navController.navigate(
                    NAV_ROUTE_PICTURE
                )
            }
        }
        composable(NAV_ROUTE_PICTURE) { Picture() }
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

@Composable
private fun SavePlaceScreen(openCameraScreen: () -> Unit) {
    Greeting("Android", openCameraScreen)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BreakfastPlacesTheme {
        Greeting("Android", {})
    }
}