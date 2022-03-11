package com.okwy.mydigidex.util

import kotlinx.coroutines.flow.*

inline fun <ResultType, RequestType> networkBoundResource(
    crossinline query: () -> Flow<ResultType>,  //fetch data from db
    crossinline fetch: suspend () -> RequestType,   //fetch data from rest api
    crossinline saveFetchResult: suspend (RequestType) -> Unit,     //send data from rest api to db
    crossinline shouldFetch: (ResultType) -> Boolean = { true }     //deciding whether to fetch new data from api or use cache

) = flow {
    //obtain one list of digimon from db
    val data = query().first()

    //obtain data to update cache where necessary
    val flow = if(shouldFetch(data)){

        //Loading the cache data
        emit(Resource.Loading(data))
        try {
            //save data to cache
            saveFetchResult(fetch())
            //pass entire flow obtained from the api
            query().map { Resource.Success(it) }
        } catch (err: Throwable) {
            //error then cache data
            query().map{Resource.Error(it, err)}
        }
    } else {
        //current cache data
        query().map { Resource.Success(it) }
    }

    //get all
    emitAll(flow)
}
