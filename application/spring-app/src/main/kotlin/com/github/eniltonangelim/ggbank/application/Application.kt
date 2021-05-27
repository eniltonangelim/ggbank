package com.github.eniltonangelim.ggbank.application

import com.github.eniltonangelim.ggbank.application.configuration.startInject
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
private open class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
    startInject()
}


