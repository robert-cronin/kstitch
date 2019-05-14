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

@file:JsModule("mongodb-stitch-browser-sdk")
@file:JsQualifier("BSON")
@file:JsNonModule

package com.fortytwoapps.kstitch.bson

import kotlinx.io.ByteBuffer
import kotlin.Double
import kotlin.js.Json

external class ObjectID {
    constructor()
    constructor(id: String)
    constructor(id: Int)

    var id: ObjectID

    override fun toString(): String

    fun toJSON(): Json
}

external class Binary(buffer: ByteBuffer) {
    var buffer: ByteBuffer

    fun toJSON(): Json
}

external class Code(code: String, scope: dynamic = definedExternally) {
    var code: String

    var scope: dynamic

    fun toJSON(): Json
}

external class DBRef(namespace:String, oid:dynamic, db:String = definedExternally) {
    var namespace: String

    var oid: ObjectID

    var db: String

    fun toJSON(): Json
}

external class Double {
    constructor(value: Double)
    constructor(value: Int)

    fun toJSON(): Json
}

external class MinKey() {
    fun toJSON(): Json
}

external class MaxKey() {
    fun toJSON(): Json
}

external class Timestamp(low:Int, high: Int) {
    companion object

    fun toInt(): Int

    fun toNumber(): Double

    fun toJSON(): Json

    override fun toString(): String
    fun toString(radix:Double): String

    fun getLowBits(radix:Double): Int

    fun getLowBitsUnsigned(): Int

    fun getNumBitsAbs(): Int

    fun isZero(): Boolean

    fun isOdd(): Boolean

    fun equals(other: Timestamp): Boolean

    fun notEquals(other: Timestamp): Boolean

    fun lessThan(other: Timestamp): Boolean

    fun lessThanOrEqual(other: Timestamp): Boolean

    fun greaterThan(other: Timestamp): Boolean

    fun greaterThanOrEqual(other: Timestamp): Boolean

    fun compare(other: Timestamp): Boolean

    fun negate(): Timestamp

    fun add(other: Timestamp): Timestamp

    fun subtract(other: Timestamp): Timestamp

    fun multiply(other: Timestamp): Timestamp

    fun div(other: Timestamp): Timestamp

    fun valueOf(): String

}

//=================================================================================/
// Class functions
external fun serialize(obj: dynamic, checkKeys: Boolean = definedExternally, asBuffer: Boolean = definedExternally, serializeFunctions: Boolean = definedExternally): dynamic