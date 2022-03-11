# my-digidex
A simple DigiDex app that gets data of popular Digimon via a REST API and displays on a list. On selection of an item you can view the details of the selected Digimon. Asides fetching the data via REST API, it also caches the data to local storage.

This app was developed using clean MVVM architecture. Fetching of data via REST API is handled using Retrofit using Coroutines while the database caching is done using Room database. Dependency Injection is handled using hilt and the Network Bound Resource helper used in the repository is implemented using Kotlin Flow

<a href="https://digimon-api.vercel.app">Digimon Data API</a>

**Implemented using:**

- Android Jetpack
- MVVM architecture
- ViewBinding
- Glide for image loading
- Coroutines for network/asynchronous calls
- Retrofit2 for REST API consumption
- Kotlin Flow and Livedata
- Hilt for Dependency Injection
- Database Caching using NetworkBoundResource
- Room Database
