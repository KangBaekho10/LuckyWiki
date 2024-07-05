package org.real7.luckywiki

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
class LuckyWikiApplication

fun main(args: Array<String>) {
    runApplication<LuckyWikiApplication>(*args)
}
