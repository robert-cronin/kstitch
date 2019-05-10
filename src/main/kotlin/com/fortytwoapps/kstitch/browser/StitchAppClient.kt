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

import com.fortytwoapps.kstitch.browser.core.services.NamedServiceClientFactory
import kotlin.js.Promise

external interface StitchAppClient {
    var auth: com.fortytwoapps.kstitch.browser.StitchAuth

    fun callFunction(name: String, args: List<Any?>): Promise<Any>
    fun getGeneralServiceClient(serviceName: String): com.fortytwoapps.kstitch.browser.StitchServiceClient
    fun <T> getServiceClient(factory: com.fortytwoapps.kstitch.browser.core.services.NamedServiceClientFactory<T>, serviceName: String): T
//    fun <T> getServiceClient(factory: ServiceClientFactory<T>): T

}