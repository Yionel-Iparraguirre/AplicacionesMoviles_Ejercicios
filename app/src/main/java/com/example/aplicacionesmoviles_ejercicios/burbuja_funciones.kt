package com.example.aplicacionesmoviles_ejercicios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.TextView

class MetodoBurbujaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.metodo_burbuja)

        val val1 = findViewById<EditText>(R.id.etValor1)
        val val2 = findViewById<EditText>(R.id.etValor2)
        val val3 = findViewById<EditText>(R.id.etValor3)
        val val4 = findViewById<EditText>(R.id.etValor4)
        val val5 = findViewById<EditText>(R.id.etValor5)
        val btnOrdenar = findViewById<Button>(R.id.btnOrdenar)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        btnOrdenar.setOnClickListener {
            val valores = listOf(
                val1.text.toString().toDoubleOrNull(),
                val2.text.toString().toDoubleOrNull(),
                val3.text.toString().toDoubleOrNull(),
                val4.text.toString().toDoubleOrNull(),
                val5.text.toString().toDoubleOrNull()
            )

            if (valores.all { it != null }) {
                val burbuja = bubbleSort(valores.filterNotNull().toDoubleArray())
                tvResultado.text = "Resultado: ${burbuja.joinToString(", ")}"
            } else {
                tvResultado.text = "Por favor ingrese números válidos."
            }
        }
    }

    private fun bubbleSort(array: DoubleArray): DoubleArray {
        val arr = array.copyOf()
        for (i in 0 until arr.size - 1) {
            for (j in 0 until arr.size - i - 1) {
                if (arr[j] > arr[j + 1]) {
                    val temp = arr[j]
                    arr[j] = arr[j + 1]
                    arr[j + 1] = temp
                }
            }
        }
        return arr
    }
}