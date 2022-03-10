package com.okwy.mydigidex.arch.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.asLiveData
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.okwy.mydigidex.entity.Digimon
import com.okwy.mydigidex.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class DigimonDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var dao: DigimonDao
    private lateinit var db: DigimonDatabase
    private val digimon: MutableList<Digimon> = mutableListOf(
        Digimon("first", "img1", "rookie"),
        Digimon("second", "img2", "champion"),
        Digimon("third", "img3", "ultimate")
    )

    @Before
    fun setup() {
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            DigimonDatabase::class.java
        ).allowMainThreadQueries().build()

        dao = db.digimonDao()
    }

    @After
    fun teardown() {
        db.close()
    }



    @Test
    fun insertAllDigimonTest() = runBlockingTest {

        dao.insertAllDigimon(digimon)
        val getAllDigimon = dao.retrieveAlLDigimon().asLiveData().getOrAwaitValue()

        assertThat(getAllDigimon).isEqualTo(digimon)

    }

    @Test
    fun deleteAllDigimonTest() = runBlockingTest {

        dao.insertAllDigimon(digimon)
        dao.deleteAllDigimon()
        val allDigimon = dao.retrieveAlLDigimon().asLiveData().getOrAwaitValue()

        assertThat(allDigimon).doesNotContain(digimon)
    }


}


