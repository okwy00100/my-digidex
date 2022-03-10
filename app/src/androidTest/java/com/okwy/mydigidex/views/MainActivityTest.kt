package com.okwy.mydigidex.views

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*

import androidx.test.espresso.contrib.RecyclerViewActions.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.okwy.mydigidex.R
import com.okwy.mydigidex.adapter.DigiAdapter
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun testActivity_inView() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.main))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_isListFragmentVisible_onAppLaunch() {
        onView(withId(R.id.digi_recycler)).check(matches(isDisplayed()))
    }


    @Test
    fun test_selectListItem_isDetailFragmentVisible() {
        onView(withId(R.id.digi_recycler))
            .perform(actionOnItemAtPosition<DigiAdapter.DigiViewHolder>(0, click()))

        onView(withId(R.id.digimon_name_detail)).check(matches(withText("Koromon")))
    }

}