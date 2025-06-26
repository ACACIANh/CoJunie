dependencies {
    // Spring Boot Actuator for monitoring and health checks
    implementation("org.springframework.boot:spring-boot-starter-actuator:${rootProject.extra["springBootVersion"]}")

    // Micrometer for metrics
    implementation("io.micrometer:micrometer-registry-prometheus:${rootProject.extra["micrometerVersion"]}")

    // Support module dependencies
    implementation(project(":logging"))

    // Test dependencies
    testImplementation("org.springframework.boot:spring-boot-starter-test:${rootProject.extra["springBootVersion"]}")
}
