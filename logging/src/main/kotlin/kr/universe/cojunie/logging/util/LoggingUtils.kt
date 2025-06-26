package kr.universe.cojunie.logging.util

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.slf4j.MDC
import java.util.UUID

/**
 * Utility class for logging
 */
object LoggingUtils {
    /**
     * Get a logger for the specified class
     * @param clazz The class to get a logger for
     * @return The logger
     */
    inline fun <reified T> getLogger(): Logger {
        return LoggerFactory.getLogger(T::class.java)
    }

    /**
     * Set a request ID in the MDC
     * @param requestId The request ID (defaults to a random UUID)
     */
    fun setRequestId(requestId: String = UUID.randomUUID().toString()) {
        MDC.put("requestId", requestId)
    }

    /**
     * Set a user ID in the MDC
     * @param userId The user ID
     */
    fun setUserId(userId: String) {
        MDC.put("userId", userId)
    }

    /**
     * Clear the MDC
     */
    fun clearMDC() {
        MDC.clear()
    }

    /**
     * Execute a block of code with a request ID in the MDC
     * @param requestId The request ID (defaults to a random UUID)
     * @param block The block of code to execute
     * @return The result of the block
     */
    fun <T> withRequestId(
        requestId: String = UUID.randomUUID().toString(),
        block: () -> T,
    ): T {
        try {
            setRequestId(requestId)
            return block()
        } finally {
            clearMDC()
        }
    }
}
