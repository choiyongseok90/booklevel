package com.example.booklevel.domain.cache.config

import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext
import java.time.Duration

@EnableCaching
@Configuration(proxyBeanMethods = false)
class CacheRedisSingleConfiguration {
    @Bean
    fun redisCacheManagerCustomizer() = RedisCacheManagerBuilderCustomizer { builder ->
        builder.withInitialCacheConfigurations(getCacheKeyValuesMap())
    }

    @Bean
    fun cacheConfiguration(): RedisCacheConfiguration? {
        return RedisCacheConfiguration.defaultCacheConfig()
            .entryTtl(Duration.ofMinutes(60))
            .disableCachingNullValues()
            .serializeValuesWith(
                RedisSerializationContext.SerializationPair.fromSerializer(
                    GenericJackson2JsonRedisSerializer()
                ))
    }

    private fun getCacheKeyValuesMap() = RedisCacheKeyProperties.values()
        .associate { it.name to RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(it.ttl)) }
}