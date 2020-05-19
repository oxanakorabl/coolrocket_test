package com.coolrocket.charttest.api

import android.util.Base64

data class Response(val result: Int, val points: List<Point>?, val message: String) {

    fun getDecodedMessage(): String {
        return try {
            val data: ByteArray = Base64.decode(message, Base64.DEFAULT)
            String(data, Charsets.UTF_8)
        } catch (e: Exception) {
            message
        }
    }
}


data class PointsResponse(val points: List<Point>)

data class ErrorResponse(val result: Int, val message: String)
