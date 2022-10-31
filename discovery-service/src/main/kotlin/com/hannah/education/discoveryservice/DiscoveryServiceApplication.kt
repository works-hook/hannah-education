package com.hannah.education.discoveryservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@EnableEurekaServer
@SpringBootApplication
class DiscoveryServiceApplication

fun main(args: Array<String>) {
    runApplication<DiscoveryServiceApplication>(*args)
}

@RestController
class PingController {

    @GetMapping("/discovery-ping")
    fun ping(): String {
        return "ping - discovery service"
    }

}

