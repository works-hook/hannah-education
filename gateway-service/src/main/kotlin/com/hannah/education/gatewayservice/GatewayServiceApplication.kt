package com.hannah.education.gatewayservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class GatewayServiceApplication

fun main(args: Array<String>) {
    runApplication<GatewayServiceApplication>(*args)
}

@RestController
class PingController {

    @GetMapping("/gateway-ping")
    fun ping(): String {
        return "ping - gateway service"
    }

}
