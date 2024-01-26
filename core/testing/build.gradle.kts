plugins {
    alias(libs.plugins.pq.android.library)
    alias(libs.plugins.pq.android.library.compose)
    alias(libs.plugins.pq.android.hilt)
}

android {
    namespace = "com.wei.picquest.core.testing"
}


dependencies {
    implementation(projects.core.common)
    implementation(projects.core.data)
    implementation(projects.core.model)
    implementation(projects.core.domain)
    implementation(projects.core.network)
    implementation(projects.core.designsystem)

    api(libs.junit4)
    api(libs.androidx.activity.compose)
    api(libs.androidx.compose.ui.test)
    api(libs.androidx.test.espresso.core)
    api(libs.androidx.test.core)
    api(libs.androidx.test.runner)
    // testharness
    api(libs.accompanist.testharness)
    // Coroutines test
    api(libs.kotlinx.coroutines.test)
    api(libs.hilt.android.testing)
    // Google truth
    api(libs.google.truth)
    // For flow test
    api(libs.turbine)
    // Android Unit Testing Framework
    api(libs.robolectric.shadows)
    // For screenshot tests
    api(libs.roborazzi)

    debugApi(libs.androidx.compose.ui.testManifest)
}
