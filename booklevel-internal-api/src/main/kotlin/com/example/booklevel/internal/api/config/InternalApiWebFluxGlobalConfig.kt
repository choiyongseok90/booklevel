package com.example.booklevel.internal.api.config

import mu.KotlinLogging
import org.springframework.web.reactive.config.DelegatingWebFluxConfiguration


// WebFlux
//@EnableWebFlux
//@Configuration
class InternalApiWebFluxGlobalConfig: DelegatingWebFluxConfiguration() {
    private val log = KotlinLogging.logger{}
    fun todo(){
        log.debug { "예정" }
    }
}