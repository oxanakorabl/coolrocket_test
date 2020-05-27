package com.coolrocket.charttest

import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes


private const val REGEX = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)?\$"

fun String.decodeIfBase64Encoded(): String {
    val regex = REGEX.toRegex()
    return if (regex.matches(this)) {
        val data: ByteArray = Base64.decode(this, Base64.DEFAULT)
        String(data, Charsets.UTF_8)
    } else {
        this
    }
}

fun ViewGroup.inflate(@LayoutRes layoutId: Int): View {
    return LayoutInflater.from(this.context).inflate(layoutId, this, false)
}
