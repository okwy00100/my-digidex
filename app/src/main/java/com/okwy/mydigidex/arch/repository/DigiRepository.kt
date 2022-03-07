package com.okwy.mydigidex.arch.repository

import com.okwy.mydigidex.entity.Digimon
import com.okwy.mydigidex.util.Resource
import kotlinx.coroutines.flow.Flow

interface DigiRepository {
    fun getDigimon() : Flow<Resource<List<Digimon>>>
}