// Top-level build file
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    // ESTA ES LA LÍNEA QUE TE FALTA AQUI:
    alias(libs.plugins.google.services) apply false
}