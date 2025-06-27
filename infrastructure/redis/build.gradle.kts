dependencies {
    // Spring Data Redis
    implementation("org.springframework.boot:spring-boot-starter-data-redis:${rootProject.extra["springBootVersion"]}")

    // Support module dependencies
    implementation(project(":system:logging"))

    // Test dependencies
    testImplementation("org.springframework.boot:spring-boot-starter-test:${rootProject.extra["springBootVersion"]}")
    testImplementation(project(":testing:test-helper"))
    testImplementation(project(":testing:test-container"))
}
