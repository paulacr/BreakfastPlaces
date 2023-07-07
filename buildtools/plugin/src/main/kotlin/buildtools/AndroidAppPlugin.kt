package buildtools

import org.gradle.api.Project
import org.gradle.api.Plugin

class AndroidAppPlugin: Plugin<Project> {
    override fun apply(project: Project) {
        project.run {
            pluginManager.run {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }
        }
    }
}
