package com.example.sqs

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AwsSqsKotlinApplication

fun main(args: Array<String>) {
	runApplication<AwsSqsKotlinApplication>(*args)
}
