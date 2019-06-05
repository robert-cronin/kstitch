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

import com.fortytwoapps.kstitch.util.KStitchProjectionPredicate
import com.fortytwoapps.kstitch.util.KStitchSortPredicate
import com.fortytwoapps.kstitch.util.jsObject
import com.fortytwoapps.kstitch.util.toJSON

class KRemoteFindOneAndModifyOptions {
    var projection: dynamic
    var returnNewDocument: Boolean?
    var sort: dynamic
    var upsert: Boolean?

    constructor(
        projection: dynamic = null,
        returnNewDocument: Boolean? = null,
        sort: dynamic = null,
        upsert: Boolean? = null
    ) {
        this.projection = projection
        this.returnNewDocument = returnNewDocument
        this.sort = sort
        this.upsert = upsert
    }

    constructor(
        projection: List<KStitchProjectionPredicate>? = null,
        returnNewDocument: Boolean? = null,
        sort: List<KStitchSortPredicate>? = null,
        upsert: Boolean? = null
    ) {
        this.projection = projection?.toJSON()
        this.returnNewDocument = returnNewDocument
        this.sort = sort?.toJSON()
        this.upsert = upsert
    }

    fun toJSON(): dynamic {
        return jsObject {
            if (projection != null) this.projection = projection
            if (returnNewDocument != null) this.returnNewDocument = returnNewDocument
            if (sort != null) this.sort = sort
            if (upsert != null) this.upsert = upsert
        }
    }
}