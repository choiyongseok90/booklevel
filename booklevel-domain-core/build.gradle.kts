plugins {
    id("java-library")
    id("java-test-fixtures")
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.Embeddable")
    annotation("javax.persistence.MappedSuperclass")
}

noArg {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.Embeddable")
    annotation("javax.persistence.MappedSuperclass")
}

dependencies {
    implementation("mysql:mysql-connector-java")
    implementation("org.mariadb.jdbc:mariadb-java-client")
    implementation("com.h2database:h2")
    implementation("org.springframework.boot:spring-boot-starter-cache")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("com.querydsl:querydsl-jpa:${Versions.querydsl_version}")

    kapt("com.querydsl:querydsl-apt:${Versions.querydsl_version}:jpa")
    kapt("org.springframework.boot:spring-boot-configuration-processor")
    kapt("jakarta.persistence:jakarta.persistence-api")
    kapt("jakarta.annotation:jakarta.annotation-api")

}

kotlin.sourceSets.main{
    setBuildDir("$buildDir/generated/source/kapt/main")
}
