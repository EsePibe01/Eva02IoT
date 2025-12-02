package com.example.creacion

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class InicioActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        // Inicializar Firebase Auth
        auth = FirebaseAuth.getInstance()

        val edtUsuario = findViewById<EditText>(R.id.edtUsuario) // Es el campo del correo
        val edtPassword = findViewById<EditText>(R.id.edtPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnGoRegistrar = findViewById<Button>(R.id.btnGoRegistrar)
        val btnGoRecuperar = findViewById<Button>(R.id.btnGoRecuperar)

        // --- BOTÓN INICIAR SESIÓN ---
        btnLogin.setOnClickListener {
            val email = edtUsuario.text.toString().trim()
            val pass = edtPassword.text.toString().trim()

            if (email.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Ingresa correo y contraseña", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // LOGIN CON FIREBASE
            auth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // ¡Login correcto!
                        Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show()

                        // Ir a la pantalla principal (MainActivity)
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish() // Para que no pueda volver atrás al login
                    } else {
                        // Error (clave mal, usuario no existe, etc)
                        Toast.makeText(this, "Error: Credenciales incorrectas", Toast.LENGTH_LONG).show()
                    }
                }
        }

        // --- BOTÓN IR A REGISTRO ---
        btnGoRegistrar.setOnClickListener {
            startActivity(Intent(this, RegistrarCuentaActivity::class.java))
        }

        // --- BOTÓN IR A RECUPERAR ---
        btnGoRecuperar.setOnClickListener {
            startActivity(Intent(this, RecuperarClaveActivity::class.java))
        }
    }
}
