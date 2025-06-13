plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.5.0"
    id("io.spring.dependency-management") version "1.1.7"

    id("org.jlleitschuh.gradle.ktlint") version "12.1.0" // 코드 스타일 검사를 위한 ktlint 플러그인
}

group = "kr.universe"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

// KtLint Configuration (코드 스타일 검사 설정)
ktlint {
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

// Set up git hooks for pre-commit checks (커밋 전 검사를 위한 Git 훅 설정)
tasks.register("installGitHooks", Copy::class) {
    from(File(rootProject.rootDir, "gradle/scripts/pre-commit")) // pre-commit 스크립트 소스 경로
    into(File(rootProject.rootDir, ".git/hooks")) // Git 훅 디렉토리 대상 경로
    fileMode = 0b111101101 // chmod 755 (실행 권한 부여)
}

// Make ktlintCheck run before build (빌드 전 ktlint 검사 실행 설정)
tasks.named("build") {
    dependsOn("ktlintCheck") // build 태스크가 ktlintCheck에 의존하도록 설정
}
