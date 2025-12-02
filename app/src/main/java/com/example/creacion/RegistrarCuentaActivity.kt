package com.example.creacion

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegistrarCuentaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_cuenta)

        val edtNombre = findViewById<EditText>(R.id.edtNombre)
        val edtApellido = findViewById<EditText>(R.id.edtApellido)
        val edtCorreo = findViewById<EditText>(R.id.edtCorreo)
        val edtRut = findViewById<EditText>(R.id.edtRut)
        val edtPass = findViewById<EditText>(R.id.edtPass)
        val edtPassConfirm = findViewById<EditText>(R.id.edtPassConfirm)

        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)
        val btnVolver = findViewById<Button>(R.id.btnVolverInicio)

        btnRegistrar.setOnClickListener {
            if (edtNombre.text.isEmpty() ||
                edtApellido.text.isEmpty() ||
                edtCorreo.text.isEmpty() ||
                edtRut.text.isEmpty() ||
                edtPass.text.isEmpty() ||
                edtPassConfirm.text.isEmpty()
            ) {
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Simulación registro exitoso", Toast.LENGTH_LONG).show()
            }
        }

        btnVolver.setOnClickListener {
            finish() // vuelve a la pantalla anterior
        }
    }
}
