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
    fun aggregate(pipeline: Array<Any>): com.fortytwoapps.kstitch.browser.RemoteMongoReadOperation<dynamic>
    // count
    fun count(query: dynamic, options: com.fortytwoapps.kstitch.browser.RemoteCountOptions): Promise<Int>
    fun count(query: dynamic): Promise<Int>
    // deleteMany
    fun deleteMany(query: dynamic): Promise<com.fortytwoapps.kstitch.browser.RemoteDeleteResult>
    // deleteOne
    fun deleteOne(query: dynamic): Promise<com.fortytwoapps.kstitch.browser.RemoteDeleteResult>
    // find
    fun find(query: dynamic, options: com.fortytwoapps.kstitch.browser.RemoteFindOptions): com.fortytwoapps.kstitch.browser.RemoteMongoReadOperation<dynamic>
    fun find(query: dynamic): com.fortytwoapps.kstitch.browser.RemoteMongoReadOperation<dynamic>
    // findOne
    fun findOne(query: dynamic, options: com.fortytwoapps.kstitch.browser.RemoteFindOptions): com.fortytwoapps.kstitch.browser.RemoteMongoReadOperation<dynamic>
    fun findOne(query: dynamic): com.fortytwoapps.kstitch.browser.RemoteMongoReadOperation<dynamic>
    // findOneAndDelete
    fun findOneAndDelete(query: dynamic, options: com.fortytwoapps.kstitch.browser.RemoteFindOneAndModifyOptions): Promise<dynamic>
    fun findOneAndDelete(query: dynamic): Promise<dynamic>
    // findOneAndReplace
    fun findOneAndReplace(query: dynamic, replacement: dynamic, options: com.fortytwoapps.kstitch.browser.RemoteFindOneAndModifyOptions): Promise<dynamic>
    fun findOneAndReplace(query: dynamic, replacement: dynamic): Promise<dynamic>
    // findOneAndReplace
    fun findOneAndUpdate(query: dynamic, update: dynamic, options: com.fortytwoapps.kstitch.browser.RemoteFindOneAndModifyOptions): Promise<dynamic>
    fun findOneAndUpdate(query: dynamic, update: dynamic): Promise<dynamic>
    // insertMany
    fun insertMany(documents: dynamic): Promise<com.fortytwoapps.kstitch.browser.RemoteInsertManyResult>
    // insertOne
    fun insertOne(document: dynamic): Promise<com.fortytwoapps.kstitch.browser.RemoteInsertOneResult>
    // updateMany
    fun updateMany(query: dynamic, update: dynamic, updateOptions: com.fortytwoapps.kstitch.browser.RemoteUpdateOptions? = definedExternally): Promise<com.fortytwoapps.kstitch.browser.RemoteUpdateResult>
    fun updateMany(query: dynamic, update: dynamic): Promise<com.fortytwoapps.kstitch.browser.RemoteUpdateResult>
    // updateOne
    fun updateOne(query: dynamic, update: dynamic, updateOptions: com.fortytwoapps.kstitch.browser.RemoteUpdateOptions? = definedExternally): Promise<com.fortytwoapps.kstitch.browser.RemoteUpdateResult>
    fun updateOne(query: dynamic, update: dynamic): Promise<com.fortytwoapps.kstitch.browser.RemoteUpdateResult>
    // watch
    fun watch(ids: Array<dynamic>): Promise<com.fortytwoapps.kstitch.browser.Stream<com.fortytwoapps.kstitch.browser.ChangeEvent<dynamic>>>
}
