package kr.universe.cojunie.core.domain.model

import java.time.LocalDateTime

/**
 * User domain model representing a user in the system
 */
data class User(
    val id: Long? = null,
    val username: String,
    val email: String,
    val createdAt: LocalDateTime? = null,
    val updatedAt: LocalDateTime? = null,
)
