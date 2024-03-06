// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    extra.apply {

        //Android Libraries
        set("compileSdk_Version", 34)
        set("minSdk_Version", 24)
        set("targetSdk_Version", 34)
        set("versionCode_Version", 1)
        set("versionName_Version", "1.0")
        set("jvmTarget_Version", "1.8")
        set("extension_Version", "1.5.1")

        set("core_ktx_Version", "1.12.0")
        set("activity_Compose_Version", "1.8.2")
        set("bom_Compose_Version", "2023.08.00")
        set("appcompat_Version", "1.6.1")
        set("test_junit_Version", "1.1.5")
        set("junit_Version", "4.13.2")
        set("espresso_core_Version", "3.5.1")
        set("icons_Extended_Version", "1.6.2")
        set("lifecycle_runtime_Version", "2.7.0")

        //Network
        set("retrofit_Version", "2.9.0")
        set("gson_Version", "2.10.1")
        set("converter_gson_Version", "2.9.0")
        set("logging_interceptor_Version", "4.11.0")
        set("coroutines_adapter_Version", "0.9.2")
        set("processing_api_Version", "1.9.22-1.0.17")

        // Room components
        set("room_runtime_Version", "2.6.1")
        set("room_compiler_Version", "2.5.2")
        set("room_ktx_Version", "2.6.1")
        set("room_paging_Version", "2.6.1")

        //hilt
        set("hilt_android_Version", "2.48.1")
        set("hilt_compiler_Version", "1.2.0")

        // Navigation
        set("navigation_fragment_Version", "2.7.2")
        set("navigation_ui_Version", "2.7.2")

        // splash screen
        set("splashscreen_Version", "1.0.1")
        set("ui_text_android_Version", "1.6.2")
    }
    }


plugins {
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.google.dagger.hilt.android") version "2.48" apply false
    id("com.google.devtools.ksp") version "1.9.10-1.0.13" apply false
}