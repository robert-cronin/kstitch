package com.fortytwoapps.kstitch.util

// Useful inline function for creating js objects
inline fun jsObject(init: dynamic.() -> Unit): dynamic {
    val obj = js("{}")
    init(obj)
    return obj
}