dependencies {
    // Spring Data Redis
    implementation("org.springframework.boot:spring-boot-starter-data-redis:${rootProject.extra["springBootVersion"]}")

    // Support module dependencies
    implementation(project(":logging"))

    // Test dependencies
    testImplementation("org.springframework.boot:spring-boot-starter-test:${rootProject.extra["springBootVersion"]}")
    testImplementation(project(":test-helper"))
    testImplementation(project(":test-container"))
}
