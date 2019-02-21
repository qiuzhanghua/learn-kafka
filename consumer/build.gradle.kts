import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm")
    application
}

group = "com.github.qiuzhanghua"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClassName="com.github.qiuzhanghua.ConsumerKt"
}

val kafkaVersion: String by project
val slf4jVersion: String by project

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
    compile("org.apache.kafka:kafka-clients:$kafkaVersion")
    compile("org.slf4j:slf4j-simple:$slf4jVersion")
    testCompile("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}