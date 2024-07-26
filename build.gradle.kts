plugins {
    id("java")
    id("maven-publish")
    id("io.github.goooler.shadow") version "8.1.8"
}

group = "cc.co.evenprime.bukkit.nocheat"
version = "2.0.3c"
description = "Detect and Fight the exploitation of various Flaws/Bugs in Minecraft."
java.sourceCompatibility = JavaVersion.VERSION_1_8
java.targetCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://jitpack.io/")
}

dependencies {
    compileOnly("com.github.Moresteck:Project-Poseidon-Uberbukkit:master-SNAPSHOT")
}


java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(8)
    }
}

tasks.build {
    dependsOn(tasks.shadowJar)
}

tasks.compileJava {
    options.encoding = "UTF-8"
}

publishing.publications.create<MavenPublication>("maven") {
    artifact(tasks["shadowJar"])
}

tasks.shadowJar {
    minimize()
    archiveFileName.set("${project.name}-${project.version}.jar")
}