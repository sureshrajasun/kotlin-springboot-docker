package com.zenika.microservices.kotlinspringdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories("com.zenika.microservices.*")
@EntityScan("com.zenika.microservices.*")
class KotlinSpringDemoApplication



fun main(args: Array<String>) {
    runApplication<KotlinSpringDemoApplication>(*args)
}

