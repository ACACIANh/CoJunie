dependencies {
    // Storage module dependencies
    implementation(project(":db-core"))
    implementation(project(":redis"))

    // Spring dependencies
    implementation("org.springframework.boot:spring-boot-starter:${rootProject.extra["springBootVersion"]}")
    implementation("org.springframework:spring-tx:${rootProject.extra["springVersion"]}")

    // Support module dependencies
    implementation(project(":logging"))

    // Test dependencies
    testImplementation("org.springframework.boot:spring-boot-starter-test:${rootProject.extra["springBootVersion"]}")
    testImplementation(project(":test-helper"))
}
