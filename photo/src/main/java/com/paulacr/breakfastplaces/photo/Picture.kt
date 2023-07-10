@file:OptIn(ExperimentalPermissionsApi::class)

package com.paulacr.breakfastplaces.photo

import android.Manifest
import android.content.ContentValues
import android.net.Uri
import android.provider.MediaStore
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.view.LifecycleCameraController
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidViewBinding
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import com.paulacr.breakfastplaces.photo.databinding.CameraBinding
import timber.log.Timber
import java.util.concurrent.Executors

enum class CameraState { PREVIEW, RESULT }

@Composable
fun Picture(viewModel: CameraViewModel = hiltViewModel()) {

    viewModel.hello()

    val (state, stateSetter) = remember { mutableStateOf(CameraState.PREVIEW) }
    val (imageUri, imageUriSetter) = remember { mutableStateOf<Uri?>(null) }

    when (state) {
        CameraState.RESULT -> AsyncImage(
            model = imageUri,
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )

        CameraState.PREVIEW -> ShowPreview(stateSetter, imageUriSetter)
    }

}

@Composable
fun ShowPreview(stateSetter: (CameraState) -> Unit, imageUriSetter: (Uri?) -> Unit) {
    val cameraController = LifecycleCameraController(LocalContext.current)
    cameraController.bindToLifecycle(LocalLifecycleOwner.current)
    cameraController.cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

    AndroidViewBinding(
        factory = CameraBinding::inflate,
        modifier = Modifier.fillMaxSize()
    ) {
        root.controller = cameraController
    }

    val fileOptions = ImageCapture.OutputFileOptions.Builder(
        LocalContext.current.contentResolver,
        MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
        ContentValues()
    )
        .build()

    val callback = object : ImageCapture.OnImageSavedCallback {
        override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
            Timber.d("qwerty saved!")
            stateSetter(CameraState.RESULT)
            imageUriSetter(outputFileResults.savedUri)
        }

        override fun onError(exception: ImageCaptureException) {
            Timber.d("qwerty got error $exception")
        }

    }

    val newSingleThreadExecutor = remember { Executors.newSingleThreadExecutor() }
    FloatingActionButton(
        onClick = {
            cameraController.takePicture(
                /* outputFileOptions = */ fileOptions,
                /* executor = */ newSingleThreadExecutor,
                /* imageSavedCallback = */ callback
            )
            Timber.d("qwerty took picture")
        },
        backgroundColor = Color.Red
    ) {
    }

    handlePermissions()
    handlePermissionsStorage()
}

@Composable
private fun handlePermissions() {
    // Camera permission state
    val cameraPermissionState = rememberPermissionState(
        Manifest.permission.CAMERA
    )

    if (cameraPermissionState.status.isGranted) {
        Text("Camera permission Granted")
    } else {
        Column {
            val textToShow = if (cameraPermissionState.status.shouldShowRationale) {
                // If the user has denied the permission but the rationale can be shown,
                // then gently explain why the app requires this permission
                "The camera is important for this app. Please grant the permission."
            } else {
                // If it's the first time the user lands on this feature, or the user
                // doesn't want to be asked again for this permission, explain that the
                // permission is required
                "Camera permission required for this feature to be available. " +
                        "Please grant the permission"
            }
            Text(textToShow)
            Button(onClick = { cameraPermissionState.launchPermissionRequest() }) {
                Text("Request permission")
            }
        }
    }
}

@Composable
private fun handlePermissionsStorage() {
    // Camera permission state
    val cameraPermissionState = rememberPermissionState(
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    if (cameraPermissionState.status.isGranted) {
        Text("Camera permission Granted")
    } else {
        Column {
            val textToShow = if (cameraPermissionState.status.shouldShowRationale) {
                // If the user has denied the permission but the rationale can be shown,
                // then gently explain why the app requires this permission
                "The camera is important for this app. Please grant the permission."
            } else {
                // If it's the first time the user lands on this feature, or the user
                // doesn't want to be asked again for this permission, explain that the
                // permission is required
                "Camera permission required for this feature to be available. " +
                        "Please grant the permission"
            }
            Text(textToShow)
            Button(onClick = { cameraPermissionState.launchPermissionRequest() }) {
                Text("Request permission")
            }
        }
    }
}