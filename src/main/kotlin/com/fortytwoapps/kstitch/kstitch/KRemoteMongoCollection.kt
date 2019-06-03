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

package com.fortytwoapps.kstitch.kstitch

import com.fortytwoapps.kstitch.browser.*
import com.fortytwoapps.kstitch.util.*
import kotlin.js.Promise

class KRemoteMongoCollection<T : Any>(var jsRemoteMongoCollection: RemoteMongoCollection<T>, var name: String) {

    // aggregate
    fun aggregate(pipeline: Array<Any>) : RemoteMongoReadOperation<dynamic> {
        return jsRemoteMongoCollection.aggregate(pipeline)
    }

    // count
    fun count(query: List<KStitchQueryPredicate>, options: RemoteCountOptions): Promise<Int> {
        return jsRemoteMongoCollection.count(query.toJSON(), options)
    }
    fun count(query: KStitchEqualPredicate, options: RemoteCountOptions): Promise<Int> {
        return jsRemoteMongoCollection.count(query.toJSON(), options)
    }
    fun count(query: List<KStitchQueryPredicate>): Promise<Int> {
        return jsRemoteMongoCollection.count(query.toJSON())
    }
    fun count(query: KStitchEqualPredicate): Promise<Int> {
        return jsRemoteMongoCollection.count(query.toJSON())
    }
    fun count(query:dynamic = jsObject{}, options: RemoteCountOptions) : Promise<Int> {
        return jsRemoteMongoCollection.count(query, options)
    }
    fun count(query:dynamic = jsObject{}) : Promise<Int> {
        return jsRemoteMongoCollection.count(query)
    }

    // deleteMany
    fun deleteMany(query: List<KStitchQueryPredicate>): Promise<RemoteDeleteResult> {
        return jsRemoteMongoCollection.deleteMany(query.toJSON())
    }
    fun deleteMany(query: KStitchEqualPredicate): Promise<RemoteDeleteResult> {
        return jsRemoteMongoCollection.deleteMany(query.toJSON())
    }
    fun deleteMany(query:dynamic = jsObject{}) : Promise<RemoteDeleteResult> {
        return jsRemoteMongoCollection.deleteMany(query)
    }

    // deleteOne
    fun deleteOne(query: List<KStitchQueryPredicate>): Promise<RemoteDeleteResult> {
        return jsRemoteMongoCollection.deleteOne(query.toJSON())
    }
    fun deleteOne(query: KStitchEqualPredicate): Promise<RemoteDeleteResult> {
        return jsRemoteMongoCollection.deleteOne(query.toJSON())
    }
    fun deleteOne(query:dynamic = jsObject{}) : Promise<RemoteDeleteResult> {
        return jsRemoteMongoCollection.deleteOne(query)
    }

    // find
    fun find(query: List<KStitchQueryPredicate>): Promise<List<T>> {
        return jsRemoteMongoCollection.find(query.toJSON())
            .asArray()
            .then { documents -> documents.toList<T>() }
    }
    fun find(query: KStitchEqualPredicate): Promise<List<T>> {
        return jsRemoteMongoCollection.find(query.toJSON())
            .asArray()
            .then { documents -> documents.toList<T>() }
    }
    fun find(query:dynamic = jsObject{}): Promise<List<T>> {
        return jsRemoteMongoCollection.find(query)
            .asArray()
            .then { documents -> documents.toList<T>() }
    }

    // findOne
    fun findOne(query: List<KStitchQueryPredicate>): Promise<T?> {
        return jsRemoteMongoCollection.findOne(query.toJSON())
            .then<dynamic> { document -> document as? T }
    }
    fun findOne(query: KStitchEqualPredicate): Promise<T?> {
        return jsRemoteMongoCollection.findOne(query.toJSON())
            .then<dynamic> { document -> document as? T }
    }
    fun findOne(query:dynamic = jsObject{}, options: RemoteFindOptions) : Promise<dynamic> {
        return jsRemoteMongoCollection.findOne(query, options)
    }
    fun findOne(query:dynamic = jsObject{}) : Promise<dynamic> {
        return jsRemoteMongoCollection.findOne(query)
    }

    // findOneAndDelete
    fun findOneAndDelete(query: List<KStitchQueryPredicate>): Promise<dynamic> {
        return jsRemoteMongoCollection.findOneAndDelete(query.toJSON())
    }
    fun findOneAndDelete(query: KStitchEqualPredicate): Promise<dynamic> {
        return jsRemoteMongoCollection.findOneAndDelete(query.toJSON())
    }
    fun findOneAndDelete(query:dynamic, options: RemoteFindOneAndModifyOptions) : Promise<dynamic> {
        return jsRemoteMongoCollection.findOneAndDelete(query, options)
    }
    fun findOneAndDelete(query:dynamic) : Promise<dynamic> {
        return jsRemoteMongoCollection.findOneAndDelete(query)
    }

    // findOneAndReplace
    fun findOneAndReplace(query: dynamic, replacement: dynamic, options: RemoteFindOneAndModifyOptions) : Promise<dynamic> {
        return jsRemoteMongoCollection.findOneAndReplace(query, replacement, options)
    }
    fun findOneAndReplace(query:dynamic, replacement: dynamic) : Promise<dynamic> {
        return jsRemoteMongoCollection.findOneAndReplace(query, replacement)
    }

    // findOneAndUpdate
    fun findOneAndUpdate(query: List<KStitchQueryPredicate>, update: List<KStitchUpdatePredicate>, options: RemoteFindOneAndModifyOptions): Promise<T?> {
        return jsRemoteMongoCollection.findOneAndUpdate(query.toJSON(), update.toJSON(), options)
            .then<dynamic> { document -> document as? T }
    }
    fun findOneAndUpdate(query: KStitchEqualPredicate, update: List<KStitchUpdatePredicate>, options: RemoteFindOneAndModifyOptions): Promise<T?> {
        return jsRemoteMongoCollection.findOneAndUpdate(query.toJSON(), update.toJSON(), options)
            .then<dynamic> { document -> document as? T }
    }
    fun findOneAndUpdate(query: List<KStitchQueryPredicate>, update: List<KStitchUpdatePredicate>): Promise<T?> {
        return jsRemoteMongoCollection.findOneAndUpdate(query.toJSON(), update.toJSON())
            .then<dynamic> { document -> document as? T }
    }
    fun findOneAndUpdate(query: KStitchEqualPredicate, update: List<KStitchUpdatePredicate>): Promise<T?> {
        return jsRemoteMongoCollection.findOneAndUpdate(query.toJSON(), update.toJSON())
            .then<dynamic> { document -> document as? T }
    }

    // insertMany
    fun insertMany(documents: List<T>) : Promise<RemoteInsertManyResult> {
        return jsRemoteMongoCollection.insertMany(documents)
    }
    fun insertMany(documents: dynamic) : Promise<RemoteInsertManyResult> {
        return jsRemoteMongoCollection.insertMany(documents)
    }

    // insertOne
    fun insertOne(document: T): Promise<RemoteInsertOneResult> {
        return jsRemoteMongoCollection.insertOne(document)
    }

    // updateMany
    fun updateMany(query: dynamic, update: dynamic, updateOptions: RemoteUpdateOptions) : Promise<RemoteUpdateResult> {
        return jsRemoteMongoCollection.updateMany(query, update, updateOptions)
    }
    fun updateMany(query: dynamic, update: dynamic) : Promise<RemoteUpdateResult> {
        return jsRemoteMongoCollection.updateMany(query, update)
    }

    // updateOne
    fun updateOne(query: dynamic, update: dynamic, updateOptions: RemoteUpdateOptions) : Promise<RemoteUpdateResult> {
        return jsRemoteMongoCollection.updateOne(query, update, updateOptions)
    }
    fun updateOne(query: dynamic, update: dynamic) : Promise<RemoteUpdateResult> {
        return jsRemoteMongoCollection.updateOne(query, update)
    }

    // watch
    fun watch(ids: Array<dynamic>) : Promise<Stream<ChangeEvent<dynamic>>> {
        return jsRemoteMongoCollection.watch(ids)
    }
}
