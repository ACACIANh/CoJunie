dependencies {
    // AWS SDK
    implementation(platform("software.amazon.awssdk:bom:2.25.0"))
    implementation("software.amazon.awssdk:s3")
    implementation("software.amazon.awssdk:sqs")

    // Spring dependencies
    implementation("org.springframework.boot:spring-boot-starter:${rootProject.extra["springBootVersion"]}")

    // Support module dependencies
    implementation(project(":logging"))

    // Test dependencies
    testImplementation("org.springframework.boot:spring-boot-starter-test:${rootProject.extra["springBootVersion"]}")
    testImplementation(project(":test-helper"))
}
