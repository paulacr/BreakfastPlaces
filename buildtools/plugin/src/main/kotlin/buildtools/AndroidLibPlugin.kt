package buildtools

import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidLibPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            extensions.getByType(LibraryExtension::class.java).run {
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