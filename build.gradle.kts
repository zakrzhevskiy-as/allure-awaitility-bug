plugins {
    id("java")
    id("io.qameta.allure")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val junitVersion = "5.10.0"
val allureVersion = "2.29.0"
val awaitilityVersion = "4.2.2"

allure {
    version.set(allureVersion)
    adapter {
        aspectjWeaver.set(true)
        frameworks {
            junit5 {
                adapterVersion.set(allureVersion)
            }
        }
    }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:${junitVersion}"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("io.qameta.allure:allure-junit5:${allureVersion}")
    testImplementation("io.qameta.allure:allure-awaitility:${allureVersion}")
    testImplementation("org.awaitility:awaitility:${awaitilityVersion}")
}

tasks.test {
    useJUnitPlatform()
}