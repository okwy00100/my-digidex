package com.okwy.mydigidex.di

import com.okwy.mydigidex.network.DigimonDataApi
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

    @Singleton
    @Provides
    fun provideDigimonApi(): DigimonDataApi =
        Retrofit.Builder()
            .baseUrl(DigimonDataApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DigimonDataApi::class.java)
}