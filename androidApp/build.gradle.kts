import android.annotation.SuppressLint

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
    kotlin("plugin.serialization")
}

android {
    namespace = "io.github.tiagonuneslx.burgerapp.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "io.github.tiagonuneslx.burgerapp.android"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "/META-INF/INDEX.LIST"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(project(":shared"))
    implementation("androidx.compose.ui:ui:1.3.2")
    implementation("androidx.compose.ui:ui-tooling:1.3.2")
    implementation("androidx.compose.ui:ui-tooling-preview:1.3.2")
    implementation("androidx.compose.foundation:foundation:1.3.1")
    implementation("androidx.compose.material:material:1.3.1")
    implementation("io.coil-kt:coil-compose:2.2.2")
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.28.0")
    implementation("androidx.activity:activity-compose:1.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")
    implementation("androidx.room:room-runtime:2.4.3")
    implementation("androidx.room:room-ktx:2.4.3")
    implementation("io.ktor:ktor-client-core-jvm:2.2.1")
    implementation("io.ktor:ktor-client-cio-jvm:2.2.1")
    implementation("io.ktor:ktor-client-logging-jvm:2.2.1")
    implementation("io.ktor:ktor-client-resources-jvm:2.2.1")
    implementation("io.ktor:ktor-client-content-negotiation-jvm:2.2.1")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:2.2.1")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
    implementation("ch.qos.logback:logback-classic:1.2.11")
    annotationProcessor("androidx.room:room-compiler:2.4.3")
    ksp("androidx.room:room-compiler:2.4.3")
    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-android-compiler:2.44")
}