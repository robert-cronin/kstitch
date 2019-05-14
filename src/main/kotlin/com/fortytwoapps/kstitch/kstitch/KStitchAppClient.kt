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
import kotlin.js.Promise

class KStitchAppClient(private val stitchAppClient: StitchAppClient) {
    var auth: StitchAuth = stitchAppClient.auth


    fun callFunction(name: String, args: List<Any?>): Promise<Any> {
        return stitchAppClient.callFunction(name, args)
    }
    fun getGeneralServiceClient(serviceName: String): StitchServiceClient {
        return stitchAppClient.getGeneralServiceClient(serviceName)
    }

    fun getRemoteServiceClient(serviceName: String): KRemoteMongoClient {
        return KRemoteMongoClient(stitchAppClient.getServiceClient(RemoteMongoClient.factory, serviceName))
    }
}