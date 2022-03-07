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

}