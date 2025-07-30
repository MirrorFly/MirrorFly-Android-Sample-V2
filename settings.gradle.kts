import java.net.URI

pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()

        maven {
            url = URI("https://jitpack.io")
        }
        maven {
            url = URI("https://gitlab.linphone.org/BC/public/maven_repository/raw/master")
        }
        maven {
            url = URI("https://maven.google.com/")
        }
        maven {
            url = URI("https://oss.sonatype.org/content/repositories/snapshots")
        }

        maven {
            url = URI("https://mvnrepository.com/artifact")
        }

        maven {
            url = URI("https://repo.mirrorfly.com/release")
        }
    }
}

include(":app", ":sdk:imagecropper", ":sdk:pix", ":sdk:mediapicker",":sdk:biometric-auth", ":sdk:zoomimageview")
include(":call")
include(":app")
rootProject.name = "UI-Kit"
include(":sdk:cameraview")
include("sdk:googletranslation")
include(":sdk:spinnerview")