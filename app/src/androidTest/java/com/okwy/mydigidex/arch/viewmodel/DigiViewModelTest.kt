package com.okwy.mydigidex.arch.viewmodel

import androidx.activity.viewModels
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.asLiveData
import com.okwy.mydigidex.arch.repository.DigiRepository
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito


@RunWith(JUnit4::class)
class DigiViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val repository = Mockito.mock(DigiRepository::class.java)
    private var digiViewModel = DigiViewModel(repository)


    @Test
    fun testNull() {
        MatcherAssert.assertThat(digiViewModel.digimon, CoreMatchers.notNullValue())
        Mockito.verify(repository, Mockito.never())
            .getDigimon().asLiveData()
    }




}