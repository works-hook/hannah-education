package com.hannah.education.studentservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@EnableDiscoveryClient
@SpringBootApplication
class StudentServiceApplication

fun main(args: Array<String>) {
    runApplication<StudentServiceApplication>(*args)
}

@RestController
class PingController {

    @GetMapping("/student-ping")
    fun ping(): String {
        println("ping - student service")
        return "ping - student service"
    }

}
