package com.hannah.education

import com.hannah.education.util.ApiResponse.Success
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class HannahEducationApplication

fun main(args: Array<String>) {
    runApplication<HannahEducationApplication>(*args)
}

@RestController
class PingController {

    @GetMapping("/ping")
    fun ping(): Success<String> {
        return Success("Success");
    }

}
