package com.paulacr.breakfastplaces.photo

import androidx.camera.core.CameraSelector
import androidx.camera.view.LifecycleCameraController
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.paulacr.breakfastplaces.photo.databinding.CameraBinding

@Composable
fun Picture() {
    val cameraController = LifecycleCameraController(LocalContext.current)
    cameraController.bindToLifecycle(LocalLifecycleOwner.current)
    cameraController.cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

    AndroidViewBinding(
        factory = CameraBinding::inflate,
        modifier = Modifier.fillMaxSize()
    ) {
        root.controller = cameraController
    }
}