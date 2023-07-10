package buildtools

import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidLibPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            plugins.run {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")

                apply("buildtools.androidHilt")
            }
            extensions.getByType(LibraryExtension::class.java).run {

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
                buildFeatures {
                    compose = true
                    viewBinding = true
                }
                composeOptions {
                    kotlinCompilerExtensionVersion = "1.4.8"
                }
            }
            dependencies.run {
                add("implementation", project(":platform"))
            }
        }
    }
}