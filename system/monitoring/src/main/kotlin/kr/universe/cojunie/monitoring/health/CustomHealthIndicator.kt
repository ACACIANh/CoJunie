package kr.universe.cojunie.monitoring.health

import org.springframework.boot.actuate.health.Health
import org.springframework.boot.actuate.health.HealthIndicator
import org.springframework.stereotype.Component

/**
 * Custom health indicator for application health checks
 */
@Component
class CustomHealthIndicator : HealthIndicator {
    /**
     * Check the health of the application
     * @return The health status
     */
    override fun health(): Health {
        // Perform health check logic here
        // For example, check database connectivity, external service availability, etc.

        // For demonstration, we'll just return UP status
        return Health.up()
            .withDetail("version", "1.0.0")
            .withDetail("description", "Custom health check")
            .build()
    }
}
