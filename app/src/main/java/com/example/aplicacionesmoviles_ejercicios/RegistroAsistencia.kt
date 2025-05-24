package com.example.aplicacionesmoviles_ejercicios

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class RegistroAsistenciaActivity : AppCompatActivity() {

    data class Asistencia(val codigo: String, val nombre: String, val fechaHora: String)

    private val listaAsistencias = ArrayList<Asistencia>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registro_asistencia)

        val etCodigo = findViewById<EditText>(R.id.etCodigo)
        val etNombre = findViewById<EditText>(R.id.etNombre)
        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)
        val tabla = findViewById<TableLayout>(R.id.tableAsistencias)

        agregarCabeceraTabla(tabla)

        btnRegistrar.setOnClickListener {
            val codigo = etCodigo.text.toString().trim()
            val nombre = etNombre.text.toString().trim()

            if (codigo.isNotEmpty() && nombre.isNotEmpty()) {
                val fechaHora = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())
                val asistencia = Asistencia(codigo, nombre, fechaHora)
                listaAsistencias.add(asistencia)
                agregarFilaTabla(tabla, asistencia)

                etCodigo.text.clear()
                etNombre.text.clear()

                Toast.makeText(this, "Asistencia registrada", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun agregarCabeceraTabla(tabla: TableLayout) {
        val fila = TableRow(this)
        fila.setBackgroundColor(resources.getColor(android.R.color.darker_gray))

        val headers = listOf("Código", "Nombre", "Fecha y Hora")
        headers.forEach { texto ->
            val tv = TextView(this)
            tv.text = texto
            tv.setPadding(16, 16, 16, 16)
            tv.setTextColor(resources.getColor(android.R.color.white))
            tv.textAlignment = TextView.TEXT_ALIGNMENT_CENTER
            fila.addView(tv)
        }
        tabla.addView(fila)
    }

    private fun agregarFilaTabla(tabla: TableLayout, asistencia: Asistencia) {
        val fila = TableRow(this)

        val datos = listOf(asistencia.codigo, asistencia.nombre, asistencia.fechaHora)
        datos.forEach { texto ->
            val tv = TextView(this)
            tv.text = texto
            tv.setPadding(16, 16, 16, 16)
            tv.textAlignment = TextView.TEXT_ALIGNMENT_CENTER
            fila.addView(tv)
        }
        tabla.addView(fila)
    }
}
