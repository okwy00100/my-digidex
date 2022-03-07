package com.okwy.mydigidex.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.okwy.mydigidex.util.Constants

@Entity(tableName = Constants.TABLE_NAME)
data class Digimon(

    @PrimaryKey(autoGenerate = false)
    val name : String = "",
    val img : String = "",
    val level : String = ""
)
