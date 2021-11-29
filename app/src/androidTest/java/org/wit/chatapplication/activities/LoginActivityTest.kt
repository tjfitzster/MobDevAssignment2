package org.wit.chatapplication.activities

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner

import org.junit.Test

import org.junit.runner.RunWith
import org.wit.chatapplication.R


@RunWith(AndroidJUnit4ClassRunner::class)

class LoginActivityTest{
    @Test
    fun is_Activity_In_View() {
        val activityScenario = ActivityScenario.launch(LoginActivity::class.java)
        onView(withId(R.id.loginbutton)).check(matches(isDisplayed()))
    }

    fun test_page_visibility() {
        val activityScenario = ActivityScenario.launch(LoginActivity::class.java)
        onView(withId(R.id.username)).check(matches(isDisplayed()))

        onView(withId(R.id.imageView2)).check(matches(isDisplayed()))

        onView(withId(R.id.password)).check(matches(isDisplayed()))

        onView(withId(R.id.loginbutton)).check(matches(isDisplayed()))

    }
}