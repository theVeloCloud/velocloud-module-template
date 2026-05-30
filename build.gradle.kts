import de.snenjih.velocloud.module.gradle.LoadOrder

plugins {
    kotlin("jvm") version libs.versions.kotlin.get()
    alias(libs.plugins.velocloud.module)
}

group = "dev.velocloud.example"
version = "1.0.0"

velocloudModule {
    id = "example-module" // Unique identifier for the module (e.g., "example-module"). This should be lowercase with hyphens.
    version = project.version.toString() // Version of the module (e.g., "1.0.0" or "1.0.0-SNAPSHOT"). This should follow semantic versioning.
    moduleName = "Example Module" // Human-readable name of the module (e.g., "Example Module").
    description = "A module that does cool things" // Description of what the module does.
    author = "YourName" // Author of the module.
    mainClass = "com.example.MyModule" // Fully qualified main class that implements VelocloudModule.

    // Optional
    loadOrder = LoadOrder.STARTUP // Load order of the module. Valid values: STARTUP, POST_STARTUP, LATE; Default: STARTUP
    apiVersion = ">=3.0.0-pre.8-SNAPSHOT" // API version this module was built for. Default: >=3.0.0-pre.8-SNAPSHOT

}

repositories {
    mavenLocal()
    mavenCentral()
    maven {
        name = "velocloud-snapshots"
        url = uri("https://repo.snenjih.de/snapshots")
    }
}

dependencies {
    compileOnly(libs.log4j.api)

    compileOnly(libs.velocloud.shared)
    implementation(libs.velocloud.agent)
    compileOnly(libs.velocloud.common)
    compileOnly(libs.velocloud.proto)
}

kotlin {
    jvmToolchain(21)
}