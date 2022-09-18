package com.example.booklevel.internal.api.config

import mu.KotlinLogging
import org.springframework.web.servlet.LocaleContextResolver


// WebFlux
//@Component
abstract class InternalApiWebFluxConfig: LocaleContextResolver {
    private val log = KotlinLogging.logger{}
    fun todo(){
        log.debug { "예정" }
    }
}