plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.awb.flowtest"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.awb.flowtest"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    // Core
    implementation(libs.androidx.core.ktx.v180)

    // Appcompat
    implementation(libs.androidx.appcompat.v142)

    // Material Design Components
    implementation(libs.material.v161)

    // UI Components
    implementation(libs.androidx.constraintlayout)

    // Navigation
    val  nav_version = "2.4.2"
    implementation(libs.androidx.navigation.fragment.ktx.v242)
    implementation (libs.androidx.navigation.ui.ktx.v242)

    // ViewBindingPropertyDelegate | | To use only without reflection variants of viewBinding
    implementation (libs.viewbindingpropertydelegate.noreflection)
}