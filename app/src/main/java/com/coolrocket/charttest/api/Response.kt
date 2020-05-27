package com.coolrocket.charttest.api

import com.coolrocket.charttest.decodeIfBase64Encoded

data class Response(val result: Int, val points: List<Point>?, private val message: String) {

    val safeMessage: String
        get() = message.decodeIfBase64Encoded()

    val isSuccess = message.isEmpty()
}

data class PointsResponse(val points: List<Point>)

data class ErrorResponse(val result: Int, val message: String)

