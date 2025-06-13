# CoJunie

![CodeRabbit Pull Request Reviews](https://img.shields.io/coderabbit/prs/github/ACACIANh/CoJunie?utm_source=oss&utm_medium=github&utm_campaign=ACACIANh%2FCoJunie&labelColor=171717&color=FF570A&link=https%3A%2F%2Fcoderabbit.ai&label=CodeRabbit+Reviews)

CoJunie는 Kotlin으로 작성된 Spring Boot 애플리케이션입니다.

## 기술 스택

- Kotlin 1.9.25
- Spring Boot 3.5.0
- Java 21
- Gradle (Kotlin DSL 사용)
- KtLint (코드 스타일 강제)

## 설정

### 사전 요구사항
- JDK 21
- Gradle

### 빌드
```bash
./gradlew build
```

### 실행
```bash
./gradlew bootRun
```

## 개발

이 프로젝트는 코드 스타일 강제를 위해 KtLint를 사용합니다. 코드가 스타일 가이드라인을 충족하지 않으면 빌드가 실패합니다.

### 코드 스타일
KtLint 검사 실행:
```bash
./gradlew ktlintCheck
```

KtLint 문제 자동 수정:
```bash
./gradlew ktlintFormat
```

### Git 훅
이 프로젝트는 커밋 전에 KtLint 검사를 실행하는 pre-commit 훅을 포함하고 있습니다.

## 참고 문서

추가 참고를 위해 다음 섹션을 확인하세요:
* [공식 Gradle 문서](https://docs.gradle.org)
* [Spring Boot Gradle 플러그인 참조 가이드](https://docs.spring.io/spring-boot/3.5.0/gradle-plugin)
