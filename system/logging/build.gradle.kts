dependencies {
    // Logging dependencies
    implementation("org.springframework.boot:spring-boot-starter-logging:${rootProject.extra["springBootVersion"]}")
    implementation("net.logstash.logback:logstash-logback-encoder:7.4")

    // MDC utilities
    implementation("org.slf4j:slf4j-api:${rootProject.extra["slf4jVersion"]}")

    // Test dependencies
    testImplementation("org.springframework.boot:spring-boot-starter-test:${rootProject.extra["springBootVersion"]}")
}
