buildscript {
    dependencies {
        classpath("com.google.gms:google-services:4.4.0")
        // Dependency on a local library module
      classpath ("com.android.tools.build:gradle:4.6.0")

        // Dependency on local binaries
        classpath(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

        // Dependency on a remote binary
        classpath("com.example.android:app-magic:12.3")


    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.1" apply false
}