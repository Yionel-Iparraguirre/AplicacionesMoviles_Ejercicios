package com.example.aplicacionesmoviles_ejercicios

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegistroMatriculaActivity : AppCompatActivity() {

    data class Matricula(val codigo: String, val nombre: String, val correo: String, val direccion: String)

    private val listaMatriculas = ArrayList<Matricula>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registro_matricula)

        val etCodigo = findViewById<EditText>(R.id.etCodigo)
        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etCorreo = findViewById<EditText>(R.id.etCorreo)
        val etDireccion = findViewById<EditText>(R.id.etDireccion)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)

        val layoutLista = findViewById<LinearLayout>(R.id.layoutListaMatriculas)
        val tvListaTitulo = findViewById<TextView>(R.id.tvListaTitulo)

        btnGuardar.setOnClickListener {
            val codigo = etCodigo.text.toString().trim()
            val nombre = etNombre.text.toString().trim()
            val correo = etCorreo.text.toString().trim()
            val direccion = etDireccion.text.toString().trim()

            if (codigo.isNotEmpty() && nombre.isNotEmpty() && correo.isNotEmpty() && direccion.isNotEmpty()) {
                val nuevaMatricula = Matricula(codigo, nombre, correo, direccion)
                listaMatriculas.add(nuevaMatricula)

                if (listaMatriculas.size == 1) {
                    tvListaTitulo.visibility = View.VISIBLE
                }

                val tarjeta = LinearLayout(this).apply {
                    orientation = LinearLayout.VERTICAL
                    setBackgroundResource(R.drawable.fondo_tarjeta_matricula)
                    setPadding(32, 32, 32, 32)
                    val params = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    )
                    params.setMargins(0, 0, 0, 24)
                    layoutParams = params
                    elevation = 8f
                }

                val tvDatos = TextView(this).apply {
                    text = "Código: $codigo\nNombre: $nombre\nCorreo: $correo\nDirección: $direccion"
                    textSize = 16f
                    setTextColor(resources.getColor(android.R.color.black))
                    setLineSpacing(1f, 1.4f)
                }

                tarjeta.addView(tvDatos)
                layoutLista.addView(tarjeta)

                // Limpiar campos
                etCodigo.text.clear()
                etNombre.text.clear()
                etCorreo.text.clear()
                etDireccion.text.clear()

                Toast.makeText(this, "Matrícula guardada", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}