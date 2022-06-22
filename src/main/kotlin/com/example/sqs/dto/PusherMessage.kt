package com.example.sqs.dto

class PusherMessage {
    var pserson: String? = null
    var comment: String? = null
    var timestamp: Number? = null
    var sentiment: Number? = null

    constructor(pserson: String?, comment: String?, timestamp: Number?, sentiment: Number?) {
        this.pserson = pserson
        this.comment = comment
        this.timestamp = timestamp
        this.sentiment = sentiment
    }
}