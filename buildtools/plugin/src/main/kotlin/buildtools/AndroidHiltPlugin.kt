package buildtools

import org.gradle.api.Project
import org.gradle.api.Plugin

class AndroidHiltPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.run {
            pluginManager.run {
                apply("kotlin-kapt")
                apply("com.google.dagger.hilt.android")
            }
            dependencies.run {
                add("implementation", "com.google.dagger:hilt-android:2.44")
                add("kapt", "com.google.dagger:hilt-android-compiler:2.44")

                add("implementation", "androidx.hilt:hilt-navigation-compose:1.0.0")
            }
        }
    }
}
