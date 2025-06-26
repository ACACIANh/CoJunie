dependencies {
    // Spring OAuth2 Client
    implementation(
        "org.springframework.boot:spring-boot-starter-oauth2-client:${rootProject.extra["springBootVersion"]}",
    )
    implementation(
        "org.springframework.boot:spring-boot-starter-web:${rootProject.extra["springBootVersion"]}",
    )

    // Support module dependencies
    implementation(project(":logging"))

    // Test dependencies
    testImplementation(
        "org.springframework.boot:spring-boot-starter-test:${rootProject.extra["springBootVersion"]}",
    )
    testImplementation(project(":test-helper"))
}
