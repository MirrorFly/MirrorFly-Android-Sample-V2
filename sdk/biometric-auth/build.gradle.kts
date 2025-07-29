plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    namespace = "com.an.biometric"
    compileSdk = rootProject.extra["compileSdkVersion"] as Int

    defaultConfig.apply {
        minSdk = rootProject.extra["minSdkVersion"] as Int
        targetSdk = rootProject.extra["targetSdkVersion"] as Int
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {}

        create("qa") {}

        create("uat") {}

        getByName("release") {}

        create("releaseDebug") {}
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    //Android - versions.gradle
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("com.google.android.material:material:1.3.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0-alpha03")
}