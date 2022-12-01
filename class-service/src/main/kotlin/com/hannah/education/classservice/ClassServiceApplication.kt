package com.hannah.education.classservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class ClassServiceApplication

fun main(args: Array<String>) {
    runApplication<ClassServiceApplication>(*args)
}

@RestController
class PingController {

    @GetMapping("/class-ping")
    fun ping(): String {
        return "ping - class service"
    }

}
