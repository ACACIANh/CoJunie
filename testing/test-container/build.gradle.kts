dependencies {
    // Test helper module
    api(project(":testing:test-helper"))

    // Testcontainers
    api("org.testcontainers:testcontainers:1.19.3")
    api("org.testcontainers:junit-jupiter:1.19.3")

    // Database containers
    api("org.testcontainers:postgresql:1.19.3")
    api("org.testcontainers:mysql:1.19.3")

    // Other service containers
    api("org.testcontainers:mongodb:1.19.3")
    api("org.testcontainers:elasticsearch:1.19.3")
    api("org.testcontainers:rabbitmq:1.19.3")
    api("org.testcontainers:kafka:1.19.3")
    // Note: Redis testcontainer is provided via GenericContainer or custom implementation

    // Spring Boot test
    api("org.springframework.boot:spring-boot-starter-test:${rootProject.extra["springBootVersion"]}")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
