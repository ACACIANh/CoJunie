package kr.universe.cojunie.db.core.repository

import kr.universe.cojunie.db.core.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Repository for User entity operations
 */
@Repository
interface UserRepository : JpaRepository<UserEntity, Long> {
    /**
     * Find a user by username
     * @param username The username to search for
     * @return The user if found, null otherwise
     */
    fun findByUsername(username: String): UserEntity?

    /**
     * Find a user by email
     * @param email The email to search for
     * @return The user if found, null otherwise
     */
    fun findByEmail(email: String): UserEntity?

    /**
     * Check if a user exists with the given username
     * @param username The username to check
     * @return True if a user exists with the username, false otherwise
     */
    fun existsByUsername(username: String): Boolean

    /**
     * Check if a user exists with the given email
     * @param email The email to check
     * @return True if a user exists with the email, false otherwise
     */
    fun existsByEmail(email: String): Boolean
}
