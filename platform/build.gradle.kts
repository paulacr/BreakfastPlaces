plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.paulacr.breakfastplaces.platform"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
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



    val nav_version = "2.6.0"

    api("androidx.navigation:navigation-compose:$nav_version")

    api(platform("androidx.compose:compose-bom:2023.05.01"))

    api("androidx.compose.ui:ui")
    api("androidx.compose.material:material")
    api("androidx.compose.ui:ui-tooling-preview")
    api("androidx.compose.ui:ui-viewbinding")
    androidTestApi("androidx.compose.ui:ui-test-junit4")
    debugApi("androidx.compose.ui:ui-tooling")


    val accompanist_version = "0.31.5-beta"
    api("com.google.accompanist:accompanist-permissions:$accompanist_version")

    api("com.jakewharton.timber:timber:5.0.1")

    api("io.coil-kt:coil-compose:2.4.0")
}