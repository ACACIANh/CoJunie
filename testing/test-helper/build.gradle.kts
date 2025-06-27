dependencies {
    // Test frameworks
    api("org.junit.jupiter:junit-jupiter-api:5.10.0")
    api("org.junit.jupiter:junit-jupiter-engine:5.10.0")
    api("org.mockito:mockito-core:5.7.0")
    api("org.mockito.kotlin:mockito-kotlin:5.2.1")

    // Spring test utilities
    api("org.springframework.boot:spring-boot-starter-test:${rootProject.extra["springBootVersion"]}") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }

    // Kotlin test utilities
    api("org.jetbrains.kotlin:kotlin-test-junit5")
    api("io.mockk:mockk:1.13.8")

    // Assertion libraries
    api("org.assertj:assertj-core:3.24.2")
    api("com.willowtreeapps.assertk:assertk-jvm:0.28.0")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
