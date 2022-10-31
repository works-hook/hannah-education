package com.hannah.education.teacherservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class TeacherServiceApplication

fun main(args: Array<String>) {
    runApplication<TeacherServiceApplication>(*args)
}

@RestController
class PingController {

    @GetMapping("/teacher-ping")
    fun ping(): String {
        println("ping - teacher service")
        return "ping - teacher service"
    }

}
