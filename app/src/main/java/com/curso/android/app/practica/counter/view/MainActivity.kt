package com.curso.android.app.practica.counter.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.curso.android.app.practica.counter.R

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: StringComparisonViewModel
    private lateinit var resultTextView: TextView
    private lateinit var compareButton: Button
    private lateinit var firstEditText: EditText
    private lateinit var secondEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializaciones ViewModel y Views
        viewModel = ViewModelProvider(this)[StringComparisonViewModel::class.java]

        resultTextView = findViewById(R.id.resultTextView)
        compareButton = findViewById(R.id.boton_comparador)
        firstEditText = findViewById(R.id.first_text)
        secondEditText = findViewById(R.id.second_text)

        // Livedata
        viewModel.result.observe(this) { result ->
            // Update the UI based on the comparison result
            if (result) {
                resultTextView.text = "Son IGUALES"
            } else {
                resultTextView.text = "Son DISINTOS"
            }
        }

        // Tomar el evento del boton
        compareButton.setOnClickListener {
            // Get the text from the EditText views
            val string1 = firstEditText.text.toString()
            val string2 = secondEditText.text.toString()

            // Hacer la comparación cuando se apreta el botón.
            viewModel.compareStrings(string1, string2)
        }
    }
}
