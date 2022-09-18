package com.example.booklevel.domain.db.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaRepositories(
    basePackages = ["com.example.booklevel.domain"]
)
@EntityScan(
    basePackages = ["com.example.booklevel.domain"]
)
class JpaConfig