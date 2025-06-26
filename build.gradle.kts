plugins {
    kotlin("jvm") version "1.9.25" apply false
    kotlin("plugin.spring") version "1.9.25" apply false
    kotlin("plugin.jpa") version "1.9.25" apply false
    id("org.springframework.boot") version "3.5.0" apply false
    id("io.spring.dependency-management") version "1.1.7" apply false
    id("org.jlleitschuh.gradle.ktlint") version "12.1.0" apply false
}

allprojects {
    group = "kr.universe"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }

    // Centralized version management
    extra["springBootVersion"] = "3.5.0"
    extra["slf4jVersion"] = "2.0.9"
    extra["micrometerVersion"] = "1.12.0"
    extra["springVersion"] = "6.1.2"
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
    apply(plugin = "java")

    // Apply Spring plugins only to modules that need them
    val springModules = setOf(
        "core-api", "core-domain", "db-core", "redis", "monitoring",
        "notification", "oauth-client", "swagger", "aws", "logging"
    )
    
    if (project.name in springModules) {
        apply(plugin = "org.jetbrains.kotlin.plugin.spring")
        apply(plugin = "io.spring.dependency-management")
    }

    // Apply JPA plugin to database-related modules
    if (project.name == "db-core") {
        apply(plugin = "org.jetbrains.kotlin.plugin.jpa")
    }

    // Apply Spring Boot plugin only to modules that produce executable JARs
    if (project.name == "core-api") {
        apply(plugin = "org.springframework.boot")
    }

    dependencies {
        // Common dependencies for all modules
        "implementation"("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        "implementation"("org.jetbrains.kotlin:kotlin-reflect")

        // Test dependencies
        "testImplementation"("org.junit.jupiter:junit-jupiter-api:5.10.0")
        "testRuntimeOnly"("org.junit.jupiter:junit-jupiter-engine:5.10.0")
    }

    configure<JavaPluginExtension> {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(21))
        }
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "21"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

// Set up git hooks for pre-commit checks (커밋 전 검사를 위한 Git 훅 설정)
tasks.register("installGitHooks", Copy::class) {
    from(File(rootProject.rootDir, "gradle/scripts/pre-commit")) // pre-commit 스크립트 소스 경로
    into(File(rootProject.rootDir, ".git/hooks")) // Git 훅 디렉토리 대상 경로
    filePermissions {
        unix("rwxr-xr-x") // chmod 755 (실행 권한 부여)
    }
}

subprojects {
    // KtLint Configuration (코드 스타일 검사 설정)
    plugins.withId("org.jlleitschuh.gradle.ktlint") {
        configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
            version.set("1.1.1") // ktlint 버전 설정
            verbose.set(true) // 상세 로그 출력 활성화
            outputToConsole.set(true) // 콘솔에 결과 출력
            coloredOutput.set(true) // 색상이 있는 출력 활성화
            reporters {
                reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE) // Checkstyle 형식의 보고서 생성
                reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.HTML) // HTML 형식의 보고서 생성
            }
            filter {
                exclude("**/generated/**") // 생성된 코드 제외
                include("**/kotlin/**") // Kotlin 파일만 포함
            }
        }

        // Make ktlintCheck run before build (빌드 전 ktlint 검사 실행 설정)
        tasks.named("build") {
            dependsOn("ktlintCheck") // build 태스크가 ktlintCheck에 의존하도록 설정
        }
    }
}
