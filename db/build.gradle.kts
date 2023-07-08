plugins {
    id("buildtools.androidLib")
    id("io.realm.kotlin") version "1.10.0"
}

        android {
            namespace = "com.paulacr.breakfastplaces.boundary.db"

            kotlinOptions {
                jvmTarget = "17"
            }
        }

dependencies {

    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("io.realm.kotlin:library-base:1.10.0")// Add to use local realm (no sync)

    implementation(project(":boundary:db"))
}