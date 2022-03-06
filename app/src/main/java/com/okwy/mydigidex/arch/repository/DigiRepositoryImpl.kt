package com.okwy.mydigidex.arch.repository

import com.okwy.mydigidex.arch.db.DigimonDatabase
import com.okwy.mydigidex.entity.Digimon
import com.okwy.mydigidex.network.DigimonDataApi
import com.okwy.mydigidex.util.Resource
import javax.inject.Inject

class DigiRepositoryImpl(
    private val api : DigimonDataApi,
//    private val db : DigimonDatabase
) : DigiRepository{


    override fun getDigimon(): Resource<List<Digimon>> {
        TODO("Not yet implemented")
    }

}