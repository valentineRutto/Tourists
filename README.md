# Tourists
A small, one page, news feed display app that shows tourist
news articles. It also should have a tab displaying a tourist list with the option of viewing the
individual tourist details on tap. The app consumes these urls: 

REST APIs source and formats:
[API source](https://www.appsloveworld.com/free-online-sample-rest-api-url-for-testing)
● [News Articles:
](http://restapi.adequateshop.com/api/Feed/GetNewsFeed)
● [Tourist Profile List:
](http://restapi.adequateshop.com/api/Tourist?page=2)

●[ Tourist Profile Details:](http://restapi.adequateshop.com/api/Tourist/170030)

# Tech Stack<br/>
-[Kotlin](https://developer.android.com/kotlin?gclid=CjwKCAjw9r-DBhBxEiwA9qYUpWK_ANJvWx6zBkFk-4XeP5a0dCxwyFZv_EeeqAcUx1K_Mj3gGkpdxRoCW9IQAvD_BwE&gclsrc=aw.ds)- a cross-platform, statically typed, general-purpose programming language with type inference.<br/>
-Coroutines - perform background operations.<br/>
-[KOIN](https://insert-koin.io/) - a pragmatic lightweight dependency injection framework.<br/>
-[ROOM](https://developer.android.com/training/data-storage/room) - persistence library providing an abstraction over SQL .<br/>
-[COMPOSE](https://developer.android.com/jetpack/compose)) - Modern UI toolkit.<br/>
[Jetpack](https://developer.android.com/jetpack) -<br/>
-[Retrofit[(https://square.github.io/retrofit/) - A type-safe HTTP client for Android.<br/><br/>

# Features<br/>
-show list of tourists profile 
-tourists profile clicked show details 
-show list of news feed 
-Make app adaptable to large screens
-Offline mode enable

# Architecture<br/>
The app contains these packages: 

#### Data

- ```data-remote```

Handles data interacting with the network and is later serverd up to the presentation layer through 
domain object

- ```data-local```

Handles persistence of object with Room ORM from.This module is responsible for handling all local related
logic and serves up data to and from the presentation layer through domain objects.

With this separation we can easily swap in new or replace the database being used without causeing
major ripples across the codebase.

#### Repository
Gets data from api and room and distributes it to the rest of the app
#### DI
Koin handles dependency injection on components making it easier to reuse
#### util
This package contains utility functions like networkresult which are used throughtout the application 
#### ui
contains views that are shown to the user




