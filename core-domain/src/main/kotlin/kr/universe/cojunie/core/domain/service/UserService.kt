package kr.universe.cojunie.core.domain.service

import kr.universe.cojunie.core.domain.model.User
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Service for user-related business logic
 */
@Service
class UserService {
    /**
     * Get a user by ID
     * @param id The user ID
     * @return The user if found, null otherwise
     */
    @Transactional(readOnly = true)
    fun getUserById(id: Long): User? {
        // In a real application, this would fetch from a repository
        return if (id == 1L) {
            User(
                id = 1L,
                username = "testuser",
                email = "test@example.com",
            )
        } else {
            null
        }
    }

    /**
     * Create a new user
     * @param username The username
     * @param email The email
     * @return The created user
     */
    @Transactional
    fun createUser(
        username: String,
        email: String,
    ): User {
        // In a real application, this would save to a repository
        return User(
            id = 1L,
            username = username,
            email = email,
        )
    }
}
