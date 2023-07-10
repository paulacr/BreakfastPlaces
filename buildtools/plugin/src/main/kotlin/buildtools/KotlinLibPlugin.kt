package buildtools

import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension

class KotlinLibPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            plugins.run {
                apply("java-library")
                apply("org.jetbrains.kotlin.jvm")

                apply("kotlin-kapt")
            }
            extensions.getByType(JavaPluginExtension::class.java).run {
                sourceCompatibility = JavaVersion.VERSION_17
                targetCompatibility = JavaVersion.VERSION_17
            }
            dependencies.run {
                add("implementation", "com.google.dagger:hilt-core:2.44")
                add("kapt", "com.google.dagger:hilt-compiler:2.44")
            }
        }
    }
}