plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("com.google.gms.google-services")
}

android {
    namespace = "com.kiki.carzone"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.kiki.carzone"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.firebase.firestore)
    implementation(libs.androidx.material3.android)
    implementation(libs.firebase.storage.ktx)
    implementation(libs.firebase.auth.ktx)
    implementation(libs.firebase.database.ktx)
    implementation(libs.androidx.core.splashscreen)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


    implementation ("androidx.compose.runtime:runtime-livedata:1.6.7")
    implementation("io.coil-kt:coil-compose:2.2.2")


    // for video player

    implementation ("com.google.android.exoplayer:exoplayer-core:2.19.1")
    implementation ("com.google.android.exoplayer:exoplayer-ui:2.19.1")

//    implementation("io.coil-kt:coil:1.4.0")
//    implementation "androidx.core:core-ktx:1.12.0"
    implementation ("androidx.core:core-ktx:1.13.0")
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("com.google.android.material:material:1.11.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
//    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
//    implementation "androidx.lifecycle:lifecycle-livedata-ktx:2.4.0"
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")

    implementation ("androidx.compose.ui:ui:1.6.6")

//    for bottom navigation

    implementation ("androidx.compose.material:material:1.6.6")



    implementation("androidx.compose.ui:ui-tooling:1.6.6")
    implementation( "androidx.activity:activity-compose:1.9.0")
    implementation("androidx.activity:activity-compose:1.9.0")
//    implementation "androidx.activity:activity-compose:1.8.2")
    implementation ("androidx.compose.material3:material3:1.2.1")
    implementation ("androidx.compose.animation:animation:1.6.6")
//    implementation ("androidx.compose.animation:animation:1.6.5")
    implementation ("androidx.compose.ui:ui-tooling:1.6.6")
//    implementation ("androidx.compose.ui:ui-tooling:1.6.5")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")

    implementation ("androidx.navigation:navigation-compose:2.7.7")
    implementation ("androidx.constraintlayout:constraintlayout-compose:1.0.1")

//    implementation( "com.google.dagger:hilt-android:2.42")
//    implementation ("com.google.dagger:hilt-android:2.42")
//    implementation ("com.google.firebase:firebase-firestore-ktx:24.11.1")
//    implementation ('com.google.firebase:firebase-database:20.3.1')
//    implementation ('com.google.firebase:firebase-storage-ktx:20.3.0')
//    implementation ('com.google.firebase:firebase-auth-ktx:22.0.0')
//
//    kapt ("com.google.dagger:hilt-android-compiler:2.42")

    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:1.6.6")
//    androidTestImplementation "androidx.compose.ui:ui-test-junit4:1.6.5"

    implementation ("androidx.navigation:navigation-compose:2.7.7")
//    implementation  "androidx.navigation:navigation-compose:2.4.0-alpha07"
    implementation  ("androidx.navigation:navigation-compose:2.7.7")
    implementation("androidx.navigation:navigation-compose:2.4.0-alpha07")
    implementation("androidx.core:core-splashscreen:1.0.1")
    implementation("com.airbnb.android:lottie-compose:5.2.0")
    implementation("androidx.navigation:navigation-compose:2.7.7")
    implementation("com.google.accompanist:accompanist-pager:0.12.0")
}