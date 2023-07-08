package com.paulacr.breakfastplaces.places

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SavePlaceScreen() {
    Column(modifier = Modifier.wrapContentSize()) {
        CameraPreviewContainer()
        PlaceInformationContainer()
    }
}
@Composable
fun CameraPreviewContainer(

) {

    Column(modifier = Modifier.wrapContentSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        CameraPreviewCard()
        ActionMenu(
            addPictureButton = {
                ActionButtonIcon(
                    icon = Icons.Filled.Add,
                    contentDescription = "Add picture button"
                ) {}
            },
            deletePictureButton = {
                ActionButtonIcon(
                    icon = Icons.Filled.Delete,
                    contentDescription = "Add picture button"
                ) {}
            },
            savePictureButton = {
                ActionButtonIcon(
                    icon = Icons.Filled.Done,
                    contentDescription = "Add picture button"
                ) {}
            }
        )
    }
}

@Composable
fun CameraPreviewCard() {

    Card(
        Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(16.dp)
    ) {
        Text(text = "Camera preview", modifier = Modifier.background(Color.Green))
    }
}

@Composable
fun ActionMenu(
    addPictureButton: @Composable () -> Unit,
    deletePictureButton: @Composable () -> Unit,
    savePictureButton: @Composable () -> Unit
) {

    Row(
        Modifier
            .height(50.dp)
            .wrapContentWidth()
            .background(Color.Magenta)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        deletePictureButton()
        savePictureButton()
        addPictureButton()
    }
}

@Composable
fun ActionButtonIcon(icon: ImageVector, contentDescription: String, onClick: () -> Unit) {
    Icon(
        icon,
        modifier = Modifier
            .clickable {
                onClick()
            }
            .wrapContentSize()
            .padding(4.dp)
            .border(BorderStroke(2.dp, Color.Cyan), shape = CutCornerShape(4.dp)),
        contentDescription = contentDescription
    )
}

@Composable
fun PlaceInformationContainer() {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Column {
        TextField(value = title, label = "Place name here") {
            title = it
        }
        TextField(value = description, label = "Describe how was this place", modifier = Modifier.height(100.dp)) {
            description = it
        }
    }
}

@Composable
fun TextField(value: String, label: String, modifier: Modifier = Modifier, onValueChange: (String) -> Unit) {
    TextField(value = value, modifier = modifier, onValueChange = {
        onValueChange(it)
    },
        label = { Text(label) }
    )
}


@Preview
@Composable
fun CameraPreviewContainerPreview() {
    CameraPreviewContainer()
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PlaceInformationContainerPreview() {
    PlaceInformationContainer()
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PlaceScreenPreview() {
    SavePlaceScreen()
}