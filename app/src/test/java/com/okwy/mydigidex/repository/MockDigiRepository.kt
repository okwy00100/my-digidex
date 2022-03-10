package com.okwy.mydigidex.repository

import com.okwy.mydigidex.arch.repository.DigiRepository
import com.okwy.mydigidex.entity.Digimon
import com.okwy.mydigidex.util.Resource
import kotlinx.coroutines.flow.*

class MockDigiRepository : DigiRepository {

    val digimon = mutableListOf<Digimon>()


    override fun getDigimon(): Flow<Resource<List<Digimon>>> {
        return flow{emit(Resource.Success(digimon))}
    }
}