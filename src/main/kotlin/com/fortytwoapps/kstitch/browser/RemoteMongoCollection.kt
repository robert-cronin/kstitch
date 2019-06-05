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
@file:JsNonModule
package com.fortytwoapps.kstitch.browser

import kotlin.js.Promise

@JsName("RemoteMongoCollection")
external interface RemoteMongoCollection<T> {
    var namespace: String

    // aggregate
    fun aggregate(pipeline: Array<Any>): RemoteMongoReadOperation<dynamic>
    // count
    fun count(query: dynamic, options: RemoteCountOptions): Promise<Int>
    fun count(query: dynamic): Promise<Int>
    // deleteMany
    fun deleteMany(query: dynamic): Promise<RemoteDeleteResult>
    // deleteOne
    fun deleteOne(query: dynamic): Promise<RemoteDeleteResult>
    // find
    fun find(query: dynamic, options: dynamic): RemoteMongoReadOperation<dynamic>
    fun find(query: dynamic): RemoteMongoReadOperation<dynamic>
    // findOne
    fun findOne(query: dynamic, options: dynamic): Promise<dynamic>
    fun findOne(query: dynamic): Promise<dynamic>
    // findOneAndDelete
    fun findOneAndDelete(query: dynamic, options: dynamic): Promise<dynamic>
    fun findOneAndDelete(query: dynamic): Promise<dynamic>
    // findOneAndReplace
    fun findOneAndReplace(query: dynamic, replacement: dynamic, options: dynamic): Promise<dynamic>
    fun findOneAndReplace(query: dynamic, replacement: dynamic): Promise<dynamic>
    // findOneAndReplace
    fun findOneAndUpdate(query: dynamic, update: dynamic, options: dynamic): Promise<dynamic>
    fun findOneAndUpdate(query: dynamic, update: dynamic): Promise<dynamic>
    // insertMany
    fun insertMany(documents: dynamic): Promise<RemoteInsertManyResult>
    // insertOne
    fun insertOne(document: dynamic): Promise<RemoteInsertOneResult>
    // updateMany
    fun updateMany(query: dynamic, update: dynamic, updateOptions: RemoteUpdateOptions? = definedExternally): Promise<RemoteUpdateResult>
    fun updateMany(query: dynamic, update: dynamic): Promise<RemoteUpdateResult>
    // updateOne
    fun updateOne(query: dynamic, update: dynamic, updateOptions: RemoteUpdateOptions? = definedExternally): Promise<RemoteUpdateResult>
    fun updateOne(query: dynamic, update: dynamic): Promise<RemoteUpdateResult>
    // watch
    fun watch(ids: Array<dynamic>): Promise<Stream<ChangeEvent<dynamic>>>
}
