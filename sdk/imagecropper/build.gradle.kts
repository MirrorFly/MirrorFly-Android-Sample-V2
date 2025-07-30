plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    namespace = "eu.janmuller.android.simplecropimage"
    compileSdk = rootProject.extra["compileSdkVersion"] as Int

    defaultConfig {
        minSdk = 21
        targetSdk = rootProject.extra["targetSdkVersion"] as Int
    }

    sourceSets {
        getByName("main") {
            manifest.srcFile("AndroidManifest.xml")
            java.srcDir("src")
            res.srcDir("res")
            assets.srcDir("assets")
            resources.srcDir("src")
        }
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
    implementation("com.android.support:exifinterface:25.1.0")
}
