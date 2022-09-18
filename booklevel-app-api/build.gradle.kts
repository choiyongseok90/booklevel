plugins {
}

dependencies {
    implementation(project(":booklevel-domain-core"))
    implementation(project(":booklevel-domain-model"))
    implementation("net.logstash.logback:logstash-logback-encoder:${Versions.logstash_logback_encoder}")

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-webflux")

    implementation("io.springfox:springfox-boot-starter:3.0.0")
    implementation("io.springfox:springfox-swagger-ui:3.0.0")
//    implementation("io.springfox:springfox-swagger2:3.0.0")
//    implementation("org.springdoc:springdoc-openapi-ui:1.6.11")
//    implementation("org.springdoc:springdoc-openapi-data-rest:1.6.11")
//    implementation("org.springdoc:springdoc-openapi-kotlin:1.6.11")


    testImplementation("org.springframework.boot:spring-boot-starter-test")

    testImplementation(testFixtures(project(":booklevel-domain-core")))
}

tasks.jar {
    enabled = false
}

tasks.bootJar {
    enabled = true
    mainClass.set("com.example.booklevel.app.AppApiApplicationKt")
    archiveFileName.set("${archiveBaseName.get()}.${archiveExtension.get()}")
}