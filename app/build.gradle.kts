plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("com.google.devtools.ksp")

}

android {
    namespace = "com.example.smssender"
    compileSdk = rootProject.extra["compileSdk_Version"] as Int?

    defaultConfig {
        applicationId = "com.example.smssender"
        minSdk = rootProject.extra["minSdk_Version"] as Int?
        targetSdk = rootProject.extra["targetSdk_Version"] as Int?
        versionCode = rootProject.extra["versionCode_Version"] as Int?
        versionName = rootProject.extra["versionName_Version"].toString()

        buildConfigField("String", "DOMAIN_URL", "\"https://api.httpsms.com\"")
        buildConfigField("String", "APP_SECRET_KEY", "\"tHeApAcHe6410111\"")
        buildConfigField("String", "APP_API_KEY", "\"XL5lwtXV0821Pen4p1dlvPQMMVXtiomgB0_LKezbQs2UfidLV1Y7GYId3bps24sT\"")
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
        jvmTarget = rootProject.extra["jvmTarget_Version"].toString()

    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = rootProject.extra["extension_Version"].toString()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    kapt {
        correctErrorTypes= true
    }
}

dependencies {

    //Android Libraries
    implementation("androidx.core:core-ktx:${rootProject.extra["core_ktx_Version"]}")
    implementation("androidx.activity:activity-compose:${rootProject.extra["activity_Compose_Version"]}")
    implementation(platform("androidx.compose:compose-bom:${rootProject.extra["bom_Compose_Version"]}"))

    implementation("androidx.appcompat:appcompat:${rootProject.extra["appcompat_Version"]}")
    testImplementation("junit:junit:${rootProject.extra["junit_Version"]}")
    androidTestImplementation("androidx.test.ext:junit:${rootProject.extra["test_junit_Version"]}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${rootProject.extra["espresso_core_Version"]}")
    implementation ("androidx.compose.material:material-icons-extended:${rootProject.extra["icons_Extended_Version"]}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${rootProject.extra["lifecycle_runtime_Version"]}")

    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    //Network
    implementation("com.squareup.retrofit2:retrofit:${rootProject.extra["retrofit_Version"]}")
    implementation("com.google.code.gson:gson:${rootProject.extra["gson_Version"]}")
    implementation("com.squareup.retrofit2:converter-gson:${rootProject.extra["converter_gson_Version"]}")
    implementation("com.squareup.okhttp3:logging-interceptor:${rootProject.extra["logging_interceptor_Version"]}")
    implementation("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${rootProject.extra["coroutines_adapter_Version"]}")
    implementation("com.google.devtools.ksp:symbol-processing-api:${rootProject.extra["processing_api_Version"]}")

    //hilt
    implementation("com.google.dagger:hilt-android:${rootProject.extra["hilt_android_Version"]}")
    kapt("androidx.hilt:hilt-compiler:${rootProject.extra["hilt_compiler_Version"]}")
    kapt("com.google.dagger:hilt-android-compiler:${rootProject.extra["hilt_android_Version"]}")
    implementation("androidx.hilt:hilt-navigation-compose:${rootProject.extra["hilt_compiler_Version"]}")

    // Room components
    implementation("androidx.room:room-runtime:${rootProject.extra["room_runtime_Version"]}")
    implementation("androidx.room:room-ktx:${rootProject.extra["room_ktx_Version"]}")
    ksp("androidx.room:room-compiler:${rootProject.extra["room_compiler_Version"]}")
    implementation("androidx.room:room-paging:${rootProject.extra["room_paging_Version"]}")

    // splash screen
    implementation("androidx.core:core-splashscreen:${rootProject.extra["splashscreen_Version"]}")
    implementation("androidx.compose.ui:ui-text-android:${rootProject.extra["ui_text_android_Version"]}")
    implementation("androidx.compose.ui:ui:${rootProject.extra["ui_text_android_Version"]}")

}