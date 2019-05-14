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


internal open class KStitchQueryPredicate(var propertyName: String, var propertyValue: dynamic, internal open var operator:QueryOperatorType? = null)

internal class KStitchEqualAndPredicate(propertyName: String, propertyValue: dynamic): KStitchQueryPredicate(propertyName, propertyValue, QueryOperatorType.And)

internal class KStitchEqualOrPredicate(propertyName: String, propertyValue: dynamic): KStitchQueryPredicate(propertyName, propertyValue, QueryOperatorType.Or)

internal class KStitchEqualPredicate(var propertyName: String, var propertyValue: dynamic){
    fun toJSON(): dynamic {
        val obj = jsObject {}
        obj[propertyName] = propertyValue
        return obj
    }
}