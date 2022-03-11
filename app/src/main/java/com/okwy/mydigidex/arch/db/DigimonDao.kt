package com.okwy.mydigidex.arch.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.okwy.mydigidex.entity.Digimon
import com.okwy.mydigidex.util.Constants
import kotlinx.coroutines.flow.Flow

@Dao
interface DigimonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllDigimon(digimon: List<Digimon>)

    @Query("DELETE FROM ${Constants.TABLE_NAME}")
    suspend fun deleteAllDigimon()

    @Query("SELECT * FROM ${Constants.TABLE_NAME}")
    fun retrieveAlLDigimon() : Flow<List<Digimon>>
}