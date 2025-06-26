dependencies {
    // Spring dependencies
    implementation("org.springframework.boot:spring-boot-starter:${rootProject.extra["springBootVersion"]}")
    implementation("org.springframework.boot:spring-boot-starter-mail:${rootProject.extra["springBootVersion"]}")

    // AWS SQS for SMS (optional, can use direct AWS SNS integration)
    implementation(project(":infrastructure:aws"))

    // Support module dependencies
    implementation(project(":system:logging"))

    // Test dependencies
    testImplementation("org.springframework.boot:spring-boot-starter-test:${rootProject.extra["springBootVersion"]}")
    testImplementation(project(":testing:test-helper"))
}
