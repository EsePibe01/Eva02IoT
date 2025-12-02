package com.example.creacion

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RecuperarClaveActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperar_clave)

        val edtNombre = findViewById<EditText>(R.id.edtNombreRec)
        val edtApellido = findViewById<EditText>(R.id.edtApellidoRec)
        val edtCorreo = findViewById<EditText>(R.id.edtCorreoRec)
        val edtRut = findViewById<EditText>(R.id.edtRutRec)
        val btnRecuperar = findViewById<Button>(R.id.btnRecuperar)
        val btnVolver = findViewById<Button>(R.id.btnVolverInicio)

        btnRecuperar.setOnClickListener {
            // Verifica si todos los campos están llenos
            if (edtNombre.text.isNotEmpty() &&
                edtApellido.text.isNotEmpty() &&
                edtCorreo.text.isNotEmpty() &&
                edtRut.text.isNotEmpty()
            ) {
                Toast.makeText(this, "Simulación exitosa: clave recuperada", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        btnVolver.setOnClickListener {
            finish() // vuelve a la pantalla anterior (InicioActivity)
        }
    }
}


