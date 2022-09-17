import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar


plugins {
    // id : gradle 기본 플러그인의 경우 id를 쓴다 => unique
    id("org.springframework.boot") version "2.7.3"
    id("io.spring.dependency-management") version "1.0.13.RELEASE"
    id("org.sonarqube") version "3.3" apply false
    id("jacoco")
    // kotlin : kotlin plugin 의미한다. => kotlin을 기반으로 spring이나, jpa를 쓰려면 아래 플러그인들을 추가해줘야 한다.
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    kotlin("plugin.jpa") version Versions.kotlin apply false
    kotlin("kapt") version Versions.kotlin
}


java.sourceCompatibility = JavaVersion.VERSION_11

allprojects{
    group = "com.example"
    version = "0.0.1-SNAPSHOT"
    repositories {
        mavenCentral()
        google()
        maven {
            // maven의 커스텀 레포지토리. 여기에 지정된 library나 plugin들을 사용할 수 있다?
            url = uri("https://repo.spring.io/release")
        }
        maven {
            //Jboss와 Tomcat은 모두 Java Servlet Application 서버지만 Jboss는 Enterprise용 기능이 많다.
            url = uri("https://repository.jboss.org/maven2")
        }
    }
}
subprojects {
    //앞에서 선언한? 플러그인들을 여기서 적용하는 것!
    apply(plugin = "java")

    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")

    apply(plugin = "kotlin")
    apply(plugin = "kotlin-spring")
    apply(plugin = "kotlin-jpa")
    apply(plugin = "kotlin-kapt")

    apply(plugin = "jacoco")
    apply(plugin = "org.sonarqube")

    dependencies {
        // jackson module은 object Mapper중 하나로, json의 직렬화 / 역직렬화의 성능 향상을 담당한다.
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        // runtime때 인스턴스를 기반으로 그 레퍼런스 객체의 정보를 얻어내는 것을 reflection이라고 한다. ::class 와 같이 사용한다.
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

        implementation("org.springframework.boot:spring-boot-starter-security")
        implementation("org.springframework.boot:spring-boot-starter-web")

        implementation("io.github.microutils:kotlin-logging:${Versions.kotlin_logging}")
        implementation("ch.qos.logback:logback-core")
        implementation("ch.qos.logback:logback-access")
        implementation("ch.qos.logback:logback-classic")
        //elastic cache에서 사용하는 로그를 수집하는 파이프라인을 형성하고 관리하는 라이브러리이다.
        implementation("net.logstash.logback:logstash-logback-encoder:7.0.1")

        testImplementation("org.junit.jupiter:junit-jupiter:${Versions.junit_jupiter}")
        testImplementation("org.testcontainers:testcontainers:${Versions.testcontainers}")
        testImplementation("org.testcontainers:junit-jupiter:${Versions.testcontainers_junit_jupiter}")

        testImplementation(platform("io.kotest:kotest-bom:${Versions.kotest_bom}"))
        testImplementation("io.kotest:kotest-runner-junit5")

        testImplementation("io.kotest.extensions:kotest-extensions-spring:${Versions.kotest_extensions_spring}")

        testImplementation("io.mockk:mockk:${Versions.mock}")

        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation("org.springframework.security:spring-security-test")

        annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
        kapt("org.springframework.boot:spring-boot-configuration-processor")

    }
    dependencyManagement {
        //멀티모듈 프로젝트의 의존성을 관리하기 위해 mavenBom을 사용한다.
        imports {
            mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
        }

        dependencies {
            dependency("net.logstash.logback:logstash-logback-encoder:${Versions.logstash_logback_encoder}")
        }
    }
    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }

    tasks.withType<Test> {
        // Test시 런타임의 여유 프로세서가 있으면 하나를 배정?
        maxParallelForks = (Runtime.getRuntime().availableProcessors() / 2).takeIf { it > 0 } ?: 1
        useJUnitPlatform()
        testLogging {
//            events = setOf(FAILED, PASSED, SKIPPED)
        }
    }
    // code의 테스트 커버리지를 확실히 알기 위해 사용한다.
    jacoco {
        toolVersion = "0.8.5"
    }
    tasks.jacocoTestReport {
//        reports {
//            xml.enabled true
//        }
    }
    //    sonarqube {
//        properties {
//            property 'sonar.projectKey', project.group + ':' + project.name
//        }
//    }
}







