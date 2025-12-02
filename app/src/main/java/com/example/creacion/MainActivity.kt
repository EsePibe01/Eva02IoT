package com.example.creacion

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val noticias = mutableListOf<String>() // Lista simulada de noticias

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnVerNoticias = findViewById<Button>(R.id.btnVerNoticias)
        val btnAgregarNoticia = findViewById<Button>(R.id.btnAgregarNoticia)

        btnVerNoticias.setOnClickListener {
            mostrarNoticias()
        }

        btnAgregarNoticia.setOnClickListener {
            agregarNoticia()
        }
    }

    private fun mostrarNoticias() {
        if (noticias.isEmpty()) {
            Toast.makeText(this, "No hay noticias disponibles", Toast.LENGTH_SHORT).show()
            return
        }

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Noticias")
        builder.setMessage(noticias.joinToString("\n\n"))
        builder.setPositiveButton("Cerrar", null)
        builder.show()
    }

    private fun agregarNoticia() {
        val tituloInput = EditText(this)
        tituloInput.hint = "Título de la noticia"

        val descripcionInput = EditText(this)
        descripcionInput.hint = "Descripción"

        val layout = androidx.appcompat.widget.LinearLayoutCompat(this)
        layout.orientation = androidx.appcompat.widget.LinearLayoutCompat.VERTICAL
        layout.setPadding(40, 20, 40, 10)
        layout.addView(tituloInput)
        layout.addView(descripcionInput)

        AlertDialog.Builder(this)
            .setTitle("Agregar Noticia")
            .setView(layout)
            .setPositiveButton("Guardar") { _, _ ->
                val titulo = tituloInput.text.toString()
                val desc = descripcionInput.text.toString()

                if (titulo.isNotEmpty() && desc.isNotEmpty()) {
                    noticias.add("$titulo\n$desc")
                    Toast.makeText(this, "Simulación: noticia agregada", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }
}
