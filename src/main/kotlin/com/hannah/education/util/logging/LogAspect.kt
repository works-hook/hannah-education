package com.hannah.education.util.logging

import com.hannah.education.util.ApiResponse
import mu.KotlinLogging
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes

@Aspect
@Component
class LogAspect {

    private val logger = KotlinLogging.logger {}

    @Around("bean(*Controller)")
    fun logging(joinPoint: ProceedingJoinPoint): Any {
        val request = (RequestContextHolder.currentRequestAttributes() as ServletRequestAttributes).request

        val start = System.currentTimeMillis()
        var result: Any? = null
        try {
            with(StringBuilder("Request --> Url: [${request.method}] ${request.requestURI}, ")) {
                appendParameters(joinPoint.args)
                logger.info(toString())
            }
            result = joinPoint.proceed()
            return result
        } finally {
            val duration = System.currentTimeMillis() - start
            logger.info("Response --> Duration: $duration ms, Returned: ${appendReturns(result)}")
        }
    }

    private fun appendReturns(result: Any?): StringBuilder {
        val returns: StringBuilder = StringBuilder("{ ")
        if (result is ApiResponse<*>) {
            returns.append("data = " + result.data + ", ")
            returns.append("message = " + result.message)
        }
        returns.append(" }")
        return returns
    }

    private fun StringBuilder.appendParameters(args: Array<Any>) {
        append("Parameters: [")
        args.forEachIndexed { i, p ->
            append(p.javaClass.simpleName).append("(").append(p.toString()).append(")")
            if (i < args.size - 1) append(", ")
        }
        append("]")
    }
}