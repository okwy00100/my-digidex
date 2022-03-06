package com.okwy.mydigidex.di

import com.okwy.mydigidex.network.DigimonDataAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDigimonApi(): DigimonDataAPI =
        Retrofit.Builder()
            .baseUrl(DigimonDataAPI.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DigimonDataAPI::class.java)
}