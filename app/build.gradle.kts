plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    kotlin("plugin.parcelize")
    id("com.google.firebase.crashlytics")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.contusfly"
    signingConfigs {
        create("config") {
            keyAlias = "UiKit"
            keyPassword = "contus@uikit"
            storeFile = file("contus_internal_uikit_keystore.jks")
            storePassword = "contus@uikit"
        }
    }

    aaptOptions {
        noCompress("tflite")
    }

    buildFeatures {
        viewBinding =  true
        buildConfig = true
    }

    lint {
        abortOnError = false
    }

    defaultConfig {
        minSdk = 21
        targetSdk = 35
        compileSdk = 35
        versionCode = 17
        versionName = "7.13.9"
        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        applicationId = "com.mirrorfly.uikit"
    }

    buildTypes {
        getByName("debug") {
            buildConfigField("Boolean", "IS_QA_BUILD", "true")
            buildConfigField("String", "LICENSE", "\"2sdgNtr3sFBSM3bYRa7RKDPEiB38Xo\"")
            buildConfigField("String", "WEB_CHAT_LOGIN", "\"https://webchat-preprod-sandbox.mirrorfly.com/\"")
            buildConfigField("String", "SUPPORT_MAIL", "\"contussupport@gmail.com\"")
            buildConfigField("Boolean", "IS_SKIP_OTP", "true")
            buildConfigField("java.util.Date", "BUILD_TIME", "new java.util.Date(${System.currentTimeMillis()}L)")

            resValue("string", "app_name", "UI Kit")

            val googleTranslateKey = project.findProperty("GOOGLE_TRANSLATE_KEY") as String? ?: ""
            val hipaaComplianceEnabled = project.findProperty("HIPAA_COMPLIANCE_ENABLED") as String? ?: "false"
            val contactSyncEnabled = project.findProperty("CONTACT_SYNC_ENABLED") as String? ?: "false"
            val host = project.findProperty("HOST") as String? ?: "8.8.8.8"
            buildConfigField("String", "GOOGLE_TRANSLATE_KEY", googleTranslateKey)
            buildConfigField("Boolean", "HIPAA_COMPLIANCE_ENABLED", hipaaComplianceEnabled)
            buildConfigField("Boolean", "CONTACT_SYNC_ENABLED", contactSyncEnabled)
            buildConfigField("String", "HOST", host)
            // shrinkResources = false
            isDebuggable = true
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("config")
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }

        getByName("release") {
            initWith(getByName("debug"))
            buildConfigField("Boolean", "IS_QA_BUILD", "true")
            buildConfigField("String", "LICENSE", "\"Please enter your License key\"")
            buildConfigField("String", "WEB_CHAT_LOGIN", "\"https://webchat-preprod-sandbox.mirrorfly.com/\"")
            buildConfigField("String", "SUPPORT_MAIL", "\"contussupport@gmail.com\"")
            buildConfigField("Boolean", "IS_SKIP_OTP", "true")
            buildConfigField("java.util.Date", "BUILD_TIME", "new java.util.Date(${System.currentTimeMillis()}L)")

            resValue("string", "app_name", "UI Kit")

            val googleTranslateKey = project.findProperty("GOOGLE_TRANSLATE_KEY") as String? ?: ""
            val hipaaComplianceEnabled = project.findProperty("HIPAA_COMPLIANCE_ENABLED") as String? ?: "false"
            val contactSyncEnabled = project.findProperty("CONTACT_SYNC_ENABLED") as String? ?: "false"
            val host = project.findProperty("HOST") as String? ?: "8.8.8.8"
            buildConfigField("String", "GOOGLE_TRANSLATE_KEY", googleTranslateKey)
            buildConfigField("Boolean", "HIPAA_COMPLIANCE_ENABLED", hipaaComplianceEnabled)
            buildConfigField("Boolean", "CONTACT_SYNC_ENABLED", contactSyncEnabled)
            buildConfigField("String", "HOST", host)
            // shrinkResources = false
            isDebuggable = true
            isMinifyEnabled = true
            signingConfig = signingConfigs.getByName("config")
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }

    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    dexOptions {
        javaMaxHeapSize = "4g"
    }
    packaging {
        resources {
            excludes += listOf(
                "META-INF/DEPENDENCIES"
            )
        }
    }
    kapt {
        arguments {
            arg("kapt.verbose", "true") // Enable verbose output for KAPT
        }
    }

}

dependencies {

    implementation("com.google.android.gms:play-services-auth:20.3.0")

    configurations.all {
        exclude(group = "org.json", module = "json")
        exclude(group = "xpp3", module = "xpp3")
    }

    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.fragment:fragment-ktx:1.3.2")
    implementation("androidx.activity:activity-ktx:1.3.0-alpha05")
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation(libs.activity)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
    implementation("androidx.core:core-ktx:1.5.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${rootProject.extra["kotlin_version"]}")

    implementation("com.google.firebase:firebase-messaging:24.0.3")
    implementation("com.google.firebase:firebase-messaging-directboot:24.0.3")
    implementation("androidx.emoji:emoji:1.1.0")
    implementation("androidx.emoji:emoji-appcompat:1.1.0")
    implementation("io.github.rockerhieu:emojicon:1.4.2")

    implementation(platform("com.google.firebase:firebase-bom:30.5.0"))
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation("com.google.firebase:firebase-crashlytics-ktx")
    implementation("com.google.firebase:firebase-auth-ktx")
    implementation("com.google.firebase:firebase-config-ktx")
    implementation("androidx.browser:browser:1.3.0")

    implementation("com.github.bumptech.glide:glide:4.14.2")
    kapt("com.github.bumptech.glide:compiler:4.14.2")
    implementation("com.github.bumptech.glide:okhttp3-integration:4.11.0")

    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    kapt("androidx.lifecycle:lifecycle-compiler:2.3.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.0")
    implementation("android.arch.lifecycle:extensions:1.1.1")
    kapt("android.arch.lifecycle:compiler:1.1.1")

    //For GreenDao
    implementation("de.greenrobot:greendao:2.1.0")

    //For gson parsing
    implementation("com.google.code.gson:gson:2.8.6")


    implementation("androidx.localbroadcastmanager:localbroadcastmanager:1.0.0")
    implementation("androidx.multidex:multidex:2.0.1")
    implementation("com.google.android.gms:play-services-location:18.0.0")
    implementation("com.google.android.gms:play-services-maps:17.0.1")

    implementation("com.facebook.stetho:stetho:1.3.1")
    implementation("com.facebook.stetho:stetho-okhttp3:1.3.1")

    //Dagger Dependencies
    api("com.google.dagger:dagger:2.56.2")
    kapt("com.google.dagger:dagger-compiler:2.56.2")
    api("com.google.dagger:dagger-android:2.56.2")
    api("com.google.dagger:dagger-android-support:2.56.2")
    kapt("com.google.dagger:dagger-android-processor:2.56.2")

    //coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.3.8")

    //apicalls
    implementation("com.squareup.retrofit2:retrofit:2.6.1")
    implementation("com.squareup.retrofit2:converter-gson:2.6.1")
    implementation("com.squareup.okhttp3:okhttp:4.2.0")
    implementation("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")

    //okhttp interceptor
    implementation("com.squareup.okhttp3:logging-interceptor:3.14.3")

    implementation("io.reactivex.rxjava2:rxjava:2.2.17")
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")

    implementation("com.jakewharton.rxbinding3:rxbinding:3.1.0")
    implementation("com.jakewharton.rxbinding3:rxbinding-core:3.1.0")
    implementation("com.jakewharton.rxbinding3:rxbinding-appcompat:3.1.0")
    implementation("com.jakewharton.rxbinding3:rxbinding-recyclerview:3.1.0")
    implementation("com.jakewharton.rxbinding3:rxbinding-viewpager2:3.1.0")

    implementation(project(":sdk:mediapicker"))
    implementation(project(":sdk:cameraview"))
    implementation(project(":sdk:zoomimageview"))
    implementation(project(":sdk:spinnerview"))
    implementation(project(":sdk:imagecropper"))
    implementation(project(":sdk:pix"))
    implementation(project(":sdk:biometric-auth"))
    implementation(project(":sdk:googletranslation"))
    implementation(project(":call"))

    implementation("com.github.lisawray.groupie:groupie:2.9.0")
    implementation("com.github.lisawray.groupie:groupie-viewbinding:2.9.0")

    //for webrtc
    implementation("com.mirrorfly.sdk:webrtc:0.0.12")

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${rootProject.extra["kotlin_version"]}")

    //coroutines

    implementation("androidx.media:media:1.7.0")

    //room database
    implementation("androidx.room:room-runtime:2.7.1")
    kapt("androidx.room:room-compiler:2.7.1")
    implementation("androidx.room:room-ktx:2.7.1")


    implementation("com.google.firebase:firebase-ml-natural-language-smart-reply-model:20.0.8")


    //QR Code Scanner
    implementation("com.journeyapps:zxing-android-embedded:3.6.0@aar")
    implementation("com.google.zxing:core:3.3.2")

    //shortcut badger
    implementation("me.leolin:ShortcutBadger:1.1.22@aar")

    implementation("androidx.security:security-crypto:1.0.0")
    implementation("com.google.crypto.tink:tink-android:1.8.0")

    // Work Manager
    implementation("androidx.work:work-runtime-ktx:2.8.1")

    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")

    // Google Drive
    implementation("com.google.android.gms:play-services-auth:20.7.0")
    implementation("com.google.api-client:google-api-client-android:2.2.0") {
        exclude(group = "org.apache.httpcomponents", module = "guava-jdk5")
    }
    implementation("com.google.apis:google-api-services-drive:v3-rev136-1.25.0") {
        exclude(group = "org.apache.httpcomponents", module = "guava-jdk5")
    }
    implementation("com.google.guava:listenablefuture:9999.0-empty-to-avoid-conflict-with-guava")

    implementation("com.airbnb.android:lottie:6.1.0")

    implementation("org.greenrobot:eventbus:3.3.1")

    implementation("com.airbnb.android:lottie:6.1.0")

    implementation("com.github.instacart:truetime-android:3.5") // true timer dependency implemented To avoid recording timer differ if system date & time changes while recording.


    implementation("com.mirrorfly.sdk:mirrorflysdk:7.13.27")

}
