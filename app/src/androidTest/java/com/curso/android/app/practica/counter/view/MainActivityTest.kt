package com.curso.android.app.practica.counter.view

import android.support.test.rule.ActivityTestRule
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.curso.android.app.practica.counter.R
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun testComparisonButton() {

        val string1 = "Hello"
        val string2 = "Hello"

        // Ingreso el string en el layout del primer EditText
        Espresso.onView(ViewMatchers.withId(R.id.first_text))
            .perform(ViewActions.typeText(string1), ViewActions.closeSoftKeyboard())

        // Ingreso el string en el layout del segundo EditText
        Espresso.onView(ViewMatchers.withId(R.id.second_text))
            .perform(ViewActions.typeText(string2), ViewActions.closeSoftKeyboard())

        // Click en el boton
        Espresso.onView(ViewMatchers.withId(R.id.boton_comparador))
            .perform(ViewActions.click())

        // verifico si son iguales
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
            .check(ViewAssertions.matches(ViewMatchers.withText("Son IGUALES")))
    }
}