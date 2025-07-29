plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    namespace = "com.location.googletranslation"
    compileSdk = rootProject.extra["compileSdkVersion"] as Int

    defaultConfig.apply {
        minSdk = 16
        targetSdk = rootProject.extra["compileSdkVersion"] as Int
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
    //Okhttp3 - versions.gradle
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")
    //Retrofit - versions.gradle
    implementation("com.google.code.gson:gson:2.8.6")
    //Retrofit - versions.gradle
    implementation("com.squareup.retrofit2:retrofit:2.6.1")
    implementation("com.squareup.retrofit2:converter-gson:2.6.1")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
}
