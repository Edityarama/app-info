plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt") // Menambahkan plugin kapt
    id("kotlin-parcelize") // Tambahkan ini
}

android {
    namespace = "com.example.kulinerapps"
    compileSdk = 34 // Anda dapat menggunakan 34, ini tidak masalah

    buildFeatures {
        viewBinding = true // Mengaktifkan View Binding
    }

    defaultConfig {
        applicationId = "com.example.kulinerapps"
        minSdk = 31 // API minimum
        targetSdk = 34 // Anda dapat menggunakan target SDK yang lebih tinggi
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
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation("androidx.viewpager2:viewpager2:1.0.0")
    implementation("com.github.bumptech.glide:glide:4.14.2") // Versi terbaru Glide
    kapt("com.github.bumptech.glide:compiler:4.14.2") // Menggunakan kapt untuk Glide
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
}
