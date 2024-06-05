plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.network"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.network"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    viewBinding.enable = true;

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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {


    implementation ("com.github.bumptech.glide:glide:4.15.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.firebase:firebase-auth:23.0.0")
    implementation("com.google.firebase:firebase-database:21.0.0")
    implementation("androidx.navigation:navigation-fragment:2.7.7")
    implementation("androidx.navigation:navigation-ui:2.7.7")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.activity:activity:1.8.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation(platform("com.google.firebase:firebase-bom:33.0.0"))
    implementation("com.google.firebase:firebase-analytics")
    implementation ("de.hdodenhof:circleimageview:3.1.0")
    implementation ("com.github.bumptech.glide:glide:4.15.1")
    implementation ("com.google.firebase:firebase-storage:21.0.0")

    //rxjava
//
//    implementation ("io.reactivex.rxjava2:android:2.1.1")
//    implementation ("io.reactivex.rxjava2:rxjava:2.2.21")
//
//    implementation("com.squareup.retrofit2:adapter-rxjava2:2.3.0")

    //retrofit
//
//    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
//    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
//
//    implementation ("com.squareup-retrofit2:adapter-rxjava2:2.9.0")
//    implementation ("com.squareup.retrofit2:converter-simplexml:2.3.0")


    //Picasso
//    implementation ("com. squareup-picasso:picasso:2.71828")

    // shimmer like facebook

//    implementation ("com.facebook.shimmer:shimmer:0.5.0")
//    implementation ("com.toddlers:shimmer-recyclerview:0.4.1")


    //Shimmer effect
//    implementation ("com.facebook.shimmer:shimmer:0.5.0")
//    implementation ("com.github.femtofarad:ShimmerRecyclerView:v0.4.1")
}