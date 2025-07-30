# Mirrorfly Sample App

## Overview
Our sample app provides basic UI integrated with latest Mirrorfly SDK where you can customize and build your own app easily.

## Before getting started

This section shows you the prerequisites you need for testing **Mirrorfly Sample App**.

### Requirements
The minimum requirements to run the Sample App:

```groovy
- Android Lollipop 5.0 (API Level 21) or above
- Java 7 or higher
- Gradle 8.6.0 or higher
- Kotlin 20.0.20 or higher
```
> **Note :** If you're utilizing Chat SDK version 7.13.27 or higher, it's must to set the target SDK version to 35. This is due to the migration of Chat SDK to Android 15.

## Getting started
This section explains the steps you need to take before testing the sample app.

**Step 1:** Create a new project or Open an existing project in Android Studio

**Step 2:** If using `Gradle 6.8` or higher, add the following code to your settings.gradle file. If using `Gradle 6.7` or lower, add the following code to your root build.gradle file. See <a href="https://docs.gradle.org/6.8/release-notes.html#dm-features" target="_self">this release note</a> to learn more about updates to Gradle.

```gradle
dependencyResolutionManagement {
        repositories {
            mavenCentral()
               maven {
                 url "https://repo.mirrorfly.com/release"
                 }
       }
}
   ```

**Step 3:** Add the following dependencies in the app/build.gradle file.
   ```gradle
 plugins {
    id("com.android.application")
 }

android {
    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
      implementation 'com.mirrorfly.sdk:MirrorFlySDK:7.13.27'
}
   ```

**Step 4:** Add the below line in the gradle.properties file, to avoid imported library conflicts.
   ```gradle
   android.enableJetifier=true
   ```

**Step 5:** Open the AndroidManifest.xml and add below permissions.
   ```xml
   <uses-permission android:name="android.permission.INTERNET" />
   ```
**Step 6:** To log in and run the app, you need to add the **LICENCSE** key in the app/build.gradle file. To generate the license key, you need to sign up in the <a href="https://console.mirrorfly.com/" target="_self">MirrorFly console</a>, and you can get it from there.
   ```gradle
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
```
After saving your build.gradle file, click the Sync button to apply all the changes.