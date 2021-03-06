package com.example.sqs.listener

import org.slf4j.LoggerFactory
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener
import org.springframework.stereotype.Service

@Service
class QueueListener {

    private val logger = LoggerFactory.getLogger(javaClass)

    @SqsListener(
        value = ["#{ environment['aws.sqs.queue-test-sqs'] }"],
        deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS
    )
    fun listener(message: String) {
        logger.info("Received message <> SqsListener: $message")
    }
}