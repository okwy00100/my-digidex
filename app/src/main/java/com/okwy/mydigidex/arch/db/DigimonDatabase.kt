package com.okwy.mydigidex.arch.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.okwy.mydigidex.entity.Digimon
import com.okwy.mydigidex.util.Constants

@Database(entities = [Digimon::class], version = Constants.DATABASE_VERSION)
abstract class DigimonDatabase : RoomDatabase() {

    abstract fun digimonDao() : DigimonDao

}