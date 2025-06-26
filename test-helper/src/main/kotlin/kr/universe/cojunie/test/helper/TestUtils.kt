package kr.universe.cojunie.test.helper

import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.ResultMatcher
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

/**
 * Utility class with helper methods for testing
 */
object TestUtils {
    /**
     * Truncate a LocalDateTime to seconds for easier comparison in tests
     */
    fun truncateToSeconds(dateTime: LocalDateTime): LocalDateTime {
        return dateTime.truncatedTo(ChronoUnit.SECONDS)
    }

    /**
     * Extension function to apply common result matchers and print the response
     */
    fun ResultActions.andExpectAll(vararg matchers: ResultMatcher): ResultActions {
        return this.andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpectAll(*matchers)
    }

    /**
     * Create a test data object with a timestamp for uniqueness
     */
    fun createTestId(prefix: String = "test"): String {
        return "$prefix-${System.currentTimeMillis()}"
    }
}
