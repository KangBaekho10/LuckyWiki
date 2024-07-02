package org.real7.luckywiki

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LuckyWikiApplication

fun main(args: Array<String>) {
    runApplication<LuckyWikiApplication>(*args)
}
