plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
    kotlin("android") version "1.6.10"
    kotlin("android.extensions") version "1.6.10"
}

android {
    namespace = "com.example.facedetection"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.facedetection"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {


    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.firebase:firebase-auth:22.3.1")
    implementation ("org.tensorflow:tensorflow-hub-lite:0.1.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation ("com.google.android.gms:play-services-mlkit-face-detection:16.6.0")
    implementation("androidx.navigation:navigation-fragment:2.7.6")
    implementation("androidx.navigation:navigation-ui:2.7.6")
    implementation("com.google.mlkit:common:18.10.0")
    implementation("androidx.room:room-compiler:2.6.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation ("org.opencv:opencv-android:4.9.0")
    implementation ("androidx.camera:camera-core:1.0.1")
    implementation ("androidx.camera:camera-camera2:1.0.1")
    implementation ("androidx.camera:camera-lifecycle:1.0.1")
    implementation ("androidx.camera:camera-view:1.0.1")
    implementation ("com.google.guava:guava:31.0.1-android")
    implementation (":openCVLibrary:4.9.0")
    implementation ("C:\\Users\\DELL\\Downloads\\openjfx-21.0.2_windows-x64_bin-sdk\\javafx-sdk-21.0.2\\lib")
    implementation ("com.google.firebase:firebase-ml-vision:26.0.0")
    implementation ("com.google.firebase:firebase-ml-vision-face-model:17.0.0")
    // Dependency on a local library module
    implementation (project(":mylibrary"))
    implementation project(':opencv')


    // Dependency on local binaries
    implementation (org.gradle.internal.impldep.bsh.commands.dir: "libs", include: ["*.jar"])

    // Dependency on a remote binary
    implementation ("com.example.android:app-magic:12.3")






}