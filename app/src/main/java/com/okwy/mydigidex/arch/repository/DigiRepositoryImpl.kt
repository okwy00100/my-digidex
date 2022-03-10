package com.okwy.mydigidex.arch.repository

import androidx.room.withTransaction
import com.okwy.mydigidex.arch.db.DigimonDatabase
import com.okwy.mydigidex.entity.Digimon
import com.okwy.mydigidex.network.DigimonDataApi
import com.okwy.mydigidex.util.Resource
import com.okwy.mydigidex.util.networkBoundResource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow


class DigiRepositoryImpl(
    private val api: DigimonDataApi,
    private val db: DigimonDatabase
) : DigiRepository {

    private val digimonDao = db.digimonDao()


    override fun getDigimon(): Flow<Resource<List<Digimon>>> = networkBoundResource(
        query = {
            digimonDao.retrieveAlLDigimon()
        },
        fetch = {
            delay(2000)
            api.fetchDigimon()
        },
        saveFetchResult = { digimon ->
            db.withTransaction {
                digimonDao.deleteAllDigimon()
                digimonDao.insertAllDigimon(digimon)
            }
        }
    )

}