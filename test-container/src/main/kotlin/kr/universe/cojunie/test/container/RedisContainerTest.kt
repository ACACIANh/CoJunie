package kr.universe.cojunie.test.container

import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.GenericContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import org.testcontainers.utility.DockerImageName

/**
 * Base class for tests that require a Redis container
 * Extend this class to use Redis in your tests
 */
@Testcontainers
abstract class RedisContainerTest {
    companion object {
        /**
         * Redis port
         */
        private const val REDIS_PORT = 6379

        /**
         * Shared Redis container for all tests
         */
        @Container
        @JvmStatic
        val redisContainer =
            GenericContainer(DockerImageName.parse("redis:7-alpine")).apply {
                withExposedPorts(REDIS_PORT)
                withReuse(true)
            }

        /**
         * Configure Spring Boot to use the container
         */
        @JvmStatic
        @DynamicPropertySource
        fun properties(registry: DynamicPropertyRegistry) {
            registry.add("spring.data.redis.host") { redisContainer.host }
            registry.add("spring.data.redis.port") { redisContainer.getMappedPort(REDIS_PORT) }
        }
    }
}
