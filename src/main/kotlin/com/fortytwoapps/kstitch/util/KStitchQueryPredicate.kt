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


open class KStitchQueryPredicate(var propertyName: String, var propertyValue: dynamic, internal open var operator:QueryOperatorType? = null)

class KStitchEqualAndPredicate(propertyName: String, propertyValue: dynamic): KStitchQueryPredicate(propertyName, propertyValue, QueryOperatorType.And)

class KStitchEqualOrPredicate(propertyName: String, propertyValue: dynamic): KStitchQueryPredicate(propertyName, propertyValue, QueryOperatorType.Or)

class KStitchEqualPredicate(var propertyName: String, var propertyValue: dynamic){
    fun toJSON(): dynamic {
        val obj = jsObject {}
        obj[propertyName] = propertyValue
        return obj
    }
}

enum class QueryOperatorType {
    And,
    Or
}

// Query predicates
infix fun <T, R> KMutableProperty1<T, R>.eq(value: dynamic): KStitchEqualPredicate {
    return KStitchEqualPredicate(this.name, value)
}

infix fun <T, R> KMutableProperty1<T, R>.eqAnd(value: dynamic): KStitchEqualAndPredicate {
    return KStitchEqualAndPredicate(this.name, value)
}

infix fun <T, R> KMutableProperty1<T, R>.eqOr(value: dynamic): KStitchEqualOrPredicate {
    return KStitchEqualOrPredicate(this.name, value)
}

fun List<KStitchQueryPredicate>.toJSON(): dynamic {
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
