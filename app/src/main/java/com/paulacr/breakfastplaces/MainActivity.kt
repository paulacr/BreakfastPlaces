package com.paulacr.breakfastplaces

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.IntegerRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.paulacr.breakfastplaces.photo.Picture
import com.paulacr.breakfastplaces.ui.theme.BreakfastPlacesTheme

private const val NAV_ROUTE_START = "start"
private const val NAV_ROUTE_PICTURE = "picture"

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