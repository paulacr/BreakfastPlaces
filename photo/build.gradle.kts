plugins {
    id("buildtools.androidLib")
}

android {
    namespace = "com.paulacr.breakfastplaces.photo"

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("com.google.android.material:material:1.5.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    // CameraX core library using the camera2 implementation
    val camerax_version = "1.3.0-beta01"
    implementation("androidx.camera:camera-camera2:${camerax_version}")
    implementation("androidx.camera:camera-view:${camerax_version}")


    implementation("androidx.camera:camera-lifecycle:${camerax_version}")
    implementation("androidx.camera:camera-extensions:${camerax_version}")

    implementation(project(":boundary:db"))
    implementation(project(":db"))
}