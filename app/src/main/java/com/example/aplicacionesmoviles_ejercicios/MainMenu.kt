package com.example.aplicacionesmoviles_ejercicios

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu)

        findViewById<Button>(R.id.btnBurbuja).setOnClickListener {
            startActivity(Intent(this, MetodoBurbujaActivity::class.java))
        }
        findViewById<Button>(R.id.btnCalculadora).setOnClickListener {
            startActivity(Intent(this, CalculadoraActivity::class.java))
        }
        findViewById<Button>(R.id.btnMatricula).setOnClickListener {
            startActivity(Intent(this, RegistroMatriculaActivity::class.java))
        }
        findViewById<Button>(R.id.btnAsistencia).setOnClickListener {
            startActivity(Intent(this, RegistroAsistenciaActivity::class.java))
        }
    }
}