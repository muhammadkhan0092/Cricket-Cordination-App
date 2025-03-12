buildscript {
    dependencies{
        classpath("androidx.navigation.safeargs:androidx.navigation.safeargs.gradle.plugin:2.8.4")
    }
}
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.google.gms.google.services) apply false
}