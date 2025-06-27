package kr.universe.cojunie.core.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["kr.universe.cojunie"])
class CoJunieApplication

fun main(args: Array<String>) {
    runApplication<CoJunieApplication>(*args)
}
