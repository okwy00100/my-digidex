package com.okwy.mydigidex.arch.repository

import com.okwy.mydigidex.entity.Digimon
import com.okwy.mydigidex.util.Resource

interface DigiRepository {
    fun fetchDigimon() : Resource<List<Digimon>>
}