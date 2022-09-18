package com.example.booklevel.internal

import com.example.booklevel.internal.api.message.ErrorMessageProperty
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication(
    scanBasePackages = ["com.example.booklevel.internal", "com.example.booklevel.api", "com.example.booklevel.domain"]
)
@EnableConfigurationProperties(ErrorMessageProperty::class)
class InternalApiApplication

fun main(args: Array<String>) {
    runApplication<InternalApiApplication>(*args)
}
