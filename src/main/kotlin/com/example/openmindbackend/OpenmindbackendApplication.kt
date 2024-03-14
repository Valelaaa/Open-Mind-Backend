package com.example.openmindbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
class OpenmindbackendApplication

fun main(args: Array<String>) {
    runApplication<OpenmindbackendApplication>(*args)
}
