dependencies {
    // Spring Data JPA
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:${rootProject.extra["springBootVersion"]}")

    // Database driver (using H2 for simplicity, replace with your preferred DB)
    runtimeOnly("com.h2database:h2")

    // Support module dependencies
    implementation(project(":logging"))

    // Test dependencies
    testImplementation("org.springframework.boot:spring-boot-starter-test:${rootProject.extra["springBootVersion"]}")
    testImplementation(project(":test-helper"))
    testImplementation(project(":test-container"))
}
