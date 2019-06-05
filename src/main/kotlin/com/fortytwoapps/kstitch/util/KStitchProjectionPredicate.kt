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

class KStitchProjectionPredicate(var propertyName: String, var projected: Boolean)

// Projection predicates
infix fun <T, R> KMutableProperty1<T, R>.project(value: Boolean): KStitchProjectionPredicate {
    return KStitchProjectionPredicate(this.name, value)
}

fun List<KStitchProjectionPredicate>.toJSON(): dynamic {
    val projectionObject = jsObject {  }

    this.forEach { predicate ->
        projectionObject[predicate.propertyName] = if (predicate.projected) 1 else 0
    }

    return projectionObject
}
