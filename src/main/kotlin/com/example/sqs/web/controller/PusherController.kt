package com.example.sqs.web.controller

import com.example.sqs.dto.PusherMessage
import com.pusher.rest.Pusher
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*


@RestController
@RequestMapping("/pusher")
class PusherController(
    @Value("\${pusher.appId}") private val appId: String,
    @Value("\${pusher.key}") private val key: String,
    @Value("\${pusher.secret}") private val secret: String,
    @Value("\${pusher.cluster}") private val cluster: String
) {

    @PostMapping
    fun sendMessage(@RequestBody message: String): ResponseEntity<String> {
        val pusher = Pusher(appId, key, secret)
        pusher.setCluster(cluster)

        val message = Collections.singletonMap("comment", PusherMessage("MOS server", "Hi~ From Server!", 1655887910168, 0))

        return ResponseEntity.ok()
            .body(pusher.trigger("post-comments", "new-comment", message).status.name)
    }
}