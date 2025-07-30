plugins {
    id("com.android.library")
    id("kotlin-android")
}

// Equivalent to Groovy's `ext` block
extra.set("PUBLISH_GROUP_ID", "com.fxn769")
extra.set("PUBLISH_ARTIFACT_ID", "pix")
extra.set("PUBLISH_VERSION", "1.5.3")

android {
    namespace = "com.fxn.pix"
    compileSdk = rootProject.extra["compileSdkVersion"] as Int

    defaultConfig.apply {
        minSdk = rootProject.extra["minSdkVersion"] as Int
        targetSdk = rootProject.extra["targetSdkVersion"] as Int
        versionCode = 5
        versionName = "1.5.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    lint {
        abortOnError = true
    }

    buildTypes {
        getByName("debug") {}

        maybeCreate("qa")
        maybeCreate("uat")
        getByName("release") {}
        maybeCreate("releaseDebug")
    }
}

/*repositories {
    maven { url = uri("https://jitpack.io") }
    mavenCentral()
    gradlePluginPortal()
}*/

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("com.google.android.material:material:1.1.0")
    implementation("androidx.core:core-ktx:1.2.0")
    implementation("androidx.exifinterface:exifinterface:1.2.0")
    // implementation("com.otaliastudios:cameraview:2.7.0")
    implementation(project(":sdk:cameraview"))
    implementation("com.github.bumptech.glide:glide:4.11.0")
    implementation("androidx.recyclerview:recyclerview:1.1.0")

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:2.1.21")
}
