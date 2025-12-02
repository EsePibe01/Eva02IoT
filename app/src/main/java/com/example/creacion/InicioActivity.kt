package com.example.creacion

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class InicioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        val edtUsuario = findViewById<EditText>(R.id.edtUsuario)
        val edtPassword = findViewById<EditText>(R.id.edtPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnGoRegistrar = findViewById<Button>(R.id.btnGoRegistrar)
        val btnGoRecuperar = findViewById<Button>(R.id.btnGoRecuperar)

        btnLogin.setOnClickListener {
            if (edtUsuario.text.isBlank() || edtPassword.text.isBlank()) {
                Toast.makeText(this, "Complete los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "Inicio de sesión exitoso (simulado)", Toast.LENGTH_SHORT).show()
            // Aquí podrías iniciar MainActivity si la usaras
        }

        btnGoRegistrar.setOnClickListener {
            startActivity(Intent(this, RegistrarCuentaActivity::class.java))
        }

        btnGoRecuperar.setOnClickListener {
            startActivity(Intent(this, RecuperarClaveActivity::class.java))
        }
    }
}

