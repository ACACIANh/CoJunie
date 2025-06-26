dependencies {
    // Core module dependencies
    implementation(project(":domain:core-domain"))

    // Spring Boot dependencies
    implementation("org.springframework.boot:spring-boot-starter-web:${rootProject.extra["springBootVersion"]}")
    implementation("org.springframework.boot:spring-boot-starter-validation:${rootProject.extra["springBootVersion"]}")

    // Support module dependencies
    implementation(project(":system:logging"))
    implementation(project(":documentation:swagger"))

    // Test dependencies
    testImplementation("org.springframework.boot:spring-boot-starter-test:${rootProject.extra["springBootVersion"]}")
    testImplementation(project(":testing:test-helper"))
}
