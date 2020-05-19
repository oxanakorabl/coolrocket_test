package com.coolrocket.charttest.api

import com.google.gson.*
import java.lang.reflect.Type

class ResponseDeserializer : JsonDeserializer<Response> {

    @Throws(JsonParseException::class)
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): Response {

        val response = json.asJsonObject.get("response").asJsonObject

        return if (json.asJsonObject.has("result")) {
            val points = Gson().fromJson(response, PointsResponse::class.java)
            Response(json.asJsonObject.getAsJsonPrimitive("result").asInt, points.points, "")
        } else {
            val error = Gson().fromJson(response, ErrorResponse::class.java)
            Response(error.result, null, error.message)
        }
    }
}
