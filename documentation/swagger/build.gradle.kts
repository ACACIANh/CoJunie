dependencies {
    // Springdoc OpenAPI for Swagger documentation
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.4.0")

    // Spring Web
    implementation("org.springframework.boot:spring-boot-starter-web:${rootProject.extra["springBootVersion"]}")

    // Support module dependencies
    implementation(project(":system:logging"))

    // Test dependencies
    testImplementation("org.springframework.boot:spring-boot-starter-test:${rootProject.extra["springBootVersion"]}")
}
