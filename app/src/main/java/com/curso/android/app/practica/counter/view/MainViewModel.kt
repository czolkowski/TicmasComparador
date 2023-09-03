package com.curso.android.app.practica.counter.view

import com.curso.android.app.practica.counter.model.StringComparisonModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StringComparisonViewModel : ViewModel() {
    private val _result = MutableLiveData<Boolean>()

    // Exponer Livedata
    val result: LiveData<Boolean>
        get() = _result

    // funcion para comparar
    fun compareStrings(string1: String, string2: String) {
        val model = StringComparisonModel()
        _result.value = model.compareStrings(string1, string2)
    }
}