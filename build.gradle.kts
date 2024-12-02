plugins {
    `kotlin-dsl`
}

group = "me.mh.gradle"
version = "1.0.0"

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    testImplementation(testLibs.junit.jupiter)
    testImplementation(testLibs.assertj.core)
}

tasks {
    test {
        useJUnitPlatform()
    }
}

kotlin {
    jvmToolchain(21)
}