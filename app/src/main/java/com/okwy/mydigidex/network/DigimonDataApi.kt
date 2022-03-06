package com.okwy.mydigidex.network

import com.okwy.mydigidex.entity.Digimon
import retrofit2.http.GET

interface DigimonDataApi {
    companion object{
        const val BASE_URL = "https://digimon-api.vercel.app/api/"
    }


    @GET("/digimon")
    suspend fun getDigimon() : List<Digimon>
}