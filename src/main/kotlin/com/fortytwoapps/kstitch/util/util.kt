/*
 * Copyright (C) 2019/2020 Robert Cronin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fortytwoapps.kstitch.util

import kotlin.reflect.KMutableProperty1

// Useful inline function for creating js objects
inline fun jsObject(init: dynamic.() -> Unit): dynamic {
    val obj = js("{}")
    init(obj)
    return obj
}

internal enum class QueryOperatorType {
    And,
    Or
}

internal infix fun <T, R> KMutableProperty1<T, R>.eq(value: dynamic): KStitchEqualPredicate {
    return KStitchEqualPredicate(this.name, value)
}

internal infix fun <T, R> KMutableProperty1<T, R>.eqAnd(value: dynamic): KStitchEqualAndPredicate {
    return KStitchEqualAndPredicate(this.name, value)
}

internal infix fun <T, R> KMutableProperty1<T, R>.eqOr(value: dynamic): KStitchEqualOrPredicate {
    return KStitchEqualOrPredicate(this.name, value)
}

internal fun Array<out KStitchQueryPredicate>.toJSON(): dynamic {
    val equalityAndPredicates = mutableListOf<dynamic>()
    val equalityOrPredicates = mutableListOf<dynamic>()

    this.forEach { predicate ->
        val obj = jsObject { }
        obj[predicate.propertyName] = predicate.propertyValue
        when (predicate.operator) {
            QueryOperatorType.And -> {
                equalityAndPredicates.add(obj)
            }
            QueryOperatorType.Or -> {
                equalityOrPredicates.add(obj)
            }
        }
    }
    val jsonQuery = jsObject{}
    if (equalityAndPredicates.isNotEmpty()) {
        jsonQuery["\$and"] = equalityAndPredicates
    }
    if (equalityOrPredicates.isNotEmpty()) {
        jsonQuery["\$or"] = equalityOrPredicates
    }
    return jsonQuery
}