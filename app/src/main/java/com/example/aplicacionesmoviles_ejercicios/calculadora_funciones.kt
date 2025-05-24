package com.example.aplicacionesmoviles_ejercicios

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder

class CalculadoraActivity : AppCompatActivity() {

    private lateinit var tvOperacion: TextView
    private lateinit var tvResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculadora)

        tvOperacion = findViewById(R.id.tvOperacion)
        tvResultado = findViewById(R.id.tvResultado)

        val botones = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9,
            R.id.btnPunto, R.id.btnSuma, R.id.btnResta, R.id.btnMultiplicar, R.id.btnDividir,
            R.id.btnPotencia, R.id.btnPorcentaje
        )

        botones.forEach { id ->
            findViewById<Button>(id).setOnClickListener {
                val textoActual = tvOperacion.text.toString()
                val textoBoton = (it as Button).text.toString()
                tvOperacion.text = textoActual + textoBoton
            }
        }

        findViewById<Button>(R.id.btnClear).setOnClickListener {
            tvOperacion.text = ""
            tvResultado.text = ""
        }

        findViewById<Button>(R.id.btnIgual).setOnClickListener {
            try {
                val expresion = tvOperacion.text.toString()
                    .replace("÷", "/")
                    .replace("*", "*")
                    .replace("^", "^")
                    .replace("√", "sqrt")
                    .replace("%", "/100")

                val resultado = ExpressionBuilder(expresion).build().evaluate()
                tvResultado.text = resultado.toString()
            } catch (e: Exception) {
                tvResultado.text = "Error"
            }
        }

        findViewById<Button>(R.id.btnRaiz).setOnClickListener {
            val textoActual = tvOperacion.text.toString()
            tvOperacion.text = textoActual + "√("
        }
    }
}