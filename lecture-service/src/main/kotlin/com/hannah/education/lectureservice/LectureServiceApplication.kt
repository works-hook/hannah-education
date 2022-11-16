package com.hannah.education.lectureservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaRepositories
class LectureServiceApplication

fun main(args: Array<String>) {
    runApplication<LectureServiceApplication>(*args)
}

@RestController
class PingController {

    @GetMapping("/lecture-ping")
    fun ping(): String {
        return "ping - lecture service"
    }

}
