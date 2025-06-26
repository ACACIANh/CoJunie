package kr.universe.cojunie.redis.service

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit

/**
 * Service for caching operations using Redis
 */
@Service
class CacheService(private val redisTemplate: RedisTemplate<String, Any>) {
    /**
     * Set a value in the cache
     * @param key The cache key
     * @param value The value to cache
     * @param ttl Time to live in seconds (default: 1 hour)
     */
    fun set(
        key: String,
        value: Any,
        ttl: Long = 3600,
    ) {
        redisTemplate.opsForValue().set(key, value, ttl, TimeUnit.SECONDS)
    }

    /**
     * Get a value from the cache
     * @param key The cache key
     * @return The cached value, or null if not found
     */
    @Suppress("UNCHECKED_CAST")
    fun <T> get(key: String): T? {
        return redisTemplate.opsForValue().get(key) as T?
    }

    /**
     * Delete a value from the cache
     * @param key The cache key
     */
    fun delete(key: String) {
        redisTemplate.delete(key)
    }

    /**
     * Check if a key exists in the cache
     * @param key The cache key
     * @return True if the key exists, false otherwise
     */
    fun exists(key: String): Boolean {
        return redisTemplate.hasKey(key)
    }
}
