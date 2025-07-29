// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
}

extra.apply {
    set("compileSdkVersion", 35)
    set("targetSdkVersion", 35)
    set("minSdkVersion", 21)
    set("versionCode", 9)
    set("versionName", "2.3")
    set("repoVersion", "7.13.7")
    set("uatVersion", "_pre_1")
    set("kotlin_version", "2.1.21")
}

buildscript {
    dependencies {
        // Firebase Crashlytics plugin
        classpath("com.google.firebase:firebase-crashlytics-gradle:2.9.4")

        // Google services plugin
        classpath("com.google.gms:google-services:4.3.15")

        // Navigation Safe Args plugin
        val navVersion = "2.5.0"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$navVersion")
    }
    allprojects {
        configurations.all {
            resolutionStrategy.force("org.jetbrains.kotlin:kotlin-stdlib:2.1.21")
            resolutionStrategy.force("org.jetbrains.kotlin:kotlin-stdlib-jdk8:2.1.21")
        }
    }
}
