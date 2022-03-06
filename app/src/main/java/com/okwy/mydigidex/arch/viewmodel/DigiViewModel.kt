package com.okwy.mydigidex.arch.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.okwy.mydigidex.arch.repository.DigiRepository
import com.okwy.mydigidex.entity.Digimon
import com.okwy.mydigidex.network.DigimonDataApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DigiViewModel @Inject constructor(
//    repository: DigiRepository
    api : DigimonDataApi
) : ViewModel() {

//    val digimon = repository.getDigimon()

    private val digimonLiveData = MutableLiveData<List<Digimon>>()
    val digimon : LiveData<List<Digimon>> = digimonLiveData

    init{
        viewModelScope.launch {
            val digimon = api.fetchDigimon()
            delay(2000)
            digimonLiveData.value = digimon
        }
    }
}