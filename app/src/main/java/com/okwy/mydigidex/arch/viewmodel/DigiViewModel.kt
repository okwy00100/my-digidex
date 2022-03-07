package com.okwy.mydigidex.arch.viewmodel

import androidx.lifecycle.*
import com.okwy.mydigidex.arch.repository.DigiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DigiViewModel @Inject constructor(
    repository: DigiRepository
) : ViewModel() {

    val digimon = repository.getDigimon().asLiveData()

//    private val digimonLiveData = MutableLiveData<List<Digimon>>()
//    val digimon : LiveData<List<Digimon>> = digimonLiveData
//
//    init{
//        viewModelScope.launch {
//            val digimon = api.fetchDigimon()
//            delay(2000)
//            digimonLiveData.value = digimon
//        }
//    }


}