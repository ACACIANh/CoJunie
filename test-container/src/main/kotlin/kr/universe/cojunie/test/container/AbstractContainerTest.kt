package kr.universe.cojunie.test.container

import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

/**
 * Base class for tests that require a PostgreSQL container
 * Extend this class to use a PostgreSQL database in your tests
 */
@Testcontainers
abstract class AbstractContainerTest {
    companion object {
        /**
         * Shared PostgreSQL container for all tests
         */
        @Container
        @JvmStatic
        val postgresContainer =
            PostgreSQLContainer<Nothing>("postgres:15-alpine").apply {
                withDatabaseName("testdb")
                withUsername("testuser")
                withPassword("testpassword")
                withReuse(true)
            }

        /**
         * Configure Spring Boot to use the container
         */
        @JvmStatic
        @DynamicPropertySource
        fun properties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", postgresContainer::getJdbcUrl)
            registry.add("spring.datasource.username", postgresContainer::getUsername)
            registry.add("spring.datasource.password", postgresContainer::getPassword)
            registry.add("spring.jpa.hibernate.ddl-auto") { "create-drop" }
        }
    }
}
