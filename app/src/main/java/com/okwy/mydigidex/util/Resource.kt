package com.okwy.mydigidex.util

sealed class Resource<T> (val data: T?, val error: Throwable?) {

    class Success<T>(data: T) : Resource<T>(data, null)

    class Loading<T>(data: T? = null) : Resource<T>(data, null)

    class Error<T>(data: T? = null, error: Throwable) : Resource<T>(data, error)
}