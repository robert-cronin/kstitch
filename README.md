[![Awesome Kotlin Badge](https://kotlin.link/awesome-kotlin.svg)](https://github.com/KotlinBy/awesome-kotlin)
[![Download](https://api.bintray.com/packages/robert-cronin/fortytwoapps/kstitch/images/download.svg) ](https://bintray.com/robert-cronin/fortytwoapps/kstitch/_latestVersion)
[![Build Status](https://travis-ci.org/fortytwoapps/kstitch.svg?branch=master)](https://travis-ci.org/fortytwoapps/kstitch)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
# KStitch
A KotlinJS Toolkit for the MongoDB Stitch API. This tool kit will also support an ODM (Object Document Mapper) in the future, watch this space!

Heavily inspired by KMongo: https://github.com/Litote/kmongo

## Getting Started

### Development
You can explore the source code either by browsing this repo or downloading KStitch from GitHub:
```
git clone https://github.com/fortytwoapps/kstitch.git
```

### Installing

To setup KStitch and start using it in your project, add these lines to build.gradle:

```gradle
repositories {
    maven { url = "https://dl.bintray.com/robert-cronin/fortytwoapps" }
}

dependencies {
    implementation "fortytwoapps:kstitch:4.9.0"
}
```

### Usage

To start using KStitch in your project, simply import like this:

```kotlin
import com.fortytwoapps.kstitch.*
```

If you are familiar with the [MongoDB Stitch JavaScript API](https://docs.mongodb.com/stitch-sdks/js/4/index.html), you can still use the Kotlin in much the same way:

##### Initializing and logging in:

```kotlin
import com.fortytwoapps.kstitch.browser.*

fun main(args: Array<String>){
    // Initialize default app client
    Stitch.initializeDefaultAppClient('<your-client-app-id>')
    
    // Login anonymously
    val client = Stitch.initializeDefaultAppClient('<your-client-app-id>')
    client.auth.loginWithCredential(AnonymousCredential())
        .then {user -> 
            console.log("Logged in as anonymous user with id ${user.id}")
        }
}
```

##### Calling a function:

```kotlin
client.callFunction("echoArg", ["Hello world!"])
    .then { echoedResult ->
        console.log("Echoed result: $echoedResult")
    }
```

Note: this requires a function called `echoArg` to be defined in the Stitch UI that looks like this:

```javascript
exports = function(arg) {
  return {arg: arg};
};
```

#### BSON and Extended JSON

KStitch now comes with BSON support:

```kotlin
import com.fortytwoapps.kstitch.bson.ObjectID

val newId = ObjectID()
```

#### ODM Functionaltiy

Define a Kotlin class and use it in Stitch!

```kotlin
class User(
        var _id: ObjectID = "",
        var adminUser: Boolean = false,
        var email: String = "",
        var fullName: String = "",
        var age: Int = 18,
        var customFunction: Code = Code("console.log('Hello World')")
)

val mongoClient = client.getRemoteServiceClient("<your-service-name>")
val userDatabase = mongoClient.db("user")
val userDataCollection = userDatabase.collection<User>("userData")

val specificUser: User = userDataCollection.find(UserData::_id eq ObjectID("5e13f16fb3de4f44ccb386e8")).await().firstOrNull()

val adminUserList: List<User> = userDataCollection.find(UserData::adminUser eq true).await()
```

## Built With

* [stitch-js-sdk](https://github.com/mongodb/stitch-js-sdk) - The underlying JavaScript library used
* [Travis CI](https://travis-ci.org/) - Continuous Integration
* [Gradle](https://gradle.org/) - Dependency Management

## Contributing

Feel free to contribute if you feel this toolkit is lacking for your application. Contributions are open.

## Authors

* **Robert Cronin** - *Initial work* - [robert-cronin](https://github.com/robert-cronin)

## License

This project is licensed under the Apache 2.0 License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip goes to developers at MongoDB for developing the JavaScript Stitch API
* Template for this readme came from [PurpleBooth](https://github.com/PurpleBooth)
