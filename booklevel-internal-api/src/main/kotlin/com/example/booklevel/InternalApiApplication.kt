package com.example.booklevel.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(
    scanBasePackages = ["com.example.booklevel.app", "com.example.booklevel.domain"]
)
class InternalApiApplication

fun main(args: Array<String>) {
    runApplication<InternalApiApplication>(*args)
}
