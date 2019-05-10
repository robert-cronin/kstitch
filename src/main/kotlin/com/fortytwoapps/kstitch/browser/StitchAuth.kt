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

external interface StitchAuth {
    var isLoggedIn: Boolean
    var user: com.fortytwoapps.kstitch.browser.StitchUser

//    fun addAuthListener(listener: StitchAuthListener): Any
    fun handleRedirectResult(): Promise<com.fortytwoapps.kstitch.browser.StitchUser>
    fun hasRedirectResult(): Boolean
    fun listUsers(): List<com.fortytwoapps.kstitch.browser.StitchUser>
    fun loginWithCredential(credential: com.fortytwoapps.kstitch.browser.StitchCredential): Promise<com.fortytwoapps.kstitch.browser.StitchUser>
//    fun loginWithRedirect(credential: StitchRedirectCredential)
    fun logout(): Promise<dynamic>
    fun logoutUserWithId(userId: String): Promise<dynamic>
//    fun removeAuthListener(listener: StitchAuthListener): Any
    fun removeUser(): Promise<dynamic>
    fun removeUserWithId(userId: String): Promise<dynamic>
    fun switchToUserWithId(userId: String): com.fortytwoapps.kstitch.browser.StitchUser
}