package com.curso.android.app.practica.counter

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.curso.android.app.practica.counter.view.MainActivity
import com.curso.android.app.practica.counter.model.StringComparisonModel
import com.curso.android.app.practica.counter.view.StringComparisonViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)


class MainViewModelUnitTest {

    private lateinit var viewModel: StringComparisonViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = StringComparisonViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()

    }

    @Test
    fun testCompareStrings_EqualStrings() = runTest{

        val model = StringComparisonModel()
        val string1 = "Hello"
        val string2 = "Hello"


        val result = model.compareStrings(string1, string2)


        assertTrue(result)
    }

    @Test
    fun testCompareStrings_DifferentStrings() = runTest {

        val model = StringComparisonModel()
        val string1 = "Hello"
        val string2 = "World"


        val result = model.compareStrings(string1, string2)


        assertFalse(result)
    }
}
