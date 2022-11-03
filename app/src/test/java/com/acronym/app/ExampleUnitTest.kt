package com.acronym.app

import androidx.lifecycle.MutableLiveData
import com.acronym.app.model.ResponseData
import com.acronym.app.viewmodel.MainActivityViewModel
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun WhenInputValid(){

        val result = MainActivityViewModel().getUser("hmm")

    }
}