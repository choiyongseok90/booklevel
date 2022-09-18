package com.example.booklevel.internal.api.message

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "error")
data class ErrorMessageProperty(
    val notfound:String
)