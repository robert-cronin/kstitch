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

class KRemoteFindOptions {
    var limit: Int?
    var projection: dynamic
    var sort: dynamic

    constructor(limit: Int? = null, projection: dynamic = null, sort: dynamic = null) {
        this.limit = limit
        this.projection = projection
        this.sort = sort
    }
    constructor(limit: Int? = null, projection: List<KStitchProjectionPredicate>? = null, sort: List<KStitchSortPredicate>? = null) {
        this.limit = limit
        this.projection = projection?.toJSON()
        this.sort = sort?.toJSON()
    }

    fun toJSON(): dynamic {
        return jsObject {
            if (limit != null) this.limit = limit
            if (projection != null) this.projection = projection
            if (sort != null) this.sort = sort
        }
    }
}