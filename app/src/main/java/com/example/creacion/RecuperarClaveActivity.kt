package com.example.creacion

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class RecuperarClaveActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperar_clave)

        // Inicializar Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Solo vinculamos el correo y los botones, ya que solo necesitamos el correo para el reseteo.
        val edtCorreo = findViewById<EditText>(R.id.edtCorreoRec)
        val btnRecuperar = findViewById<Button>(R.id.btnRecuperar)
        val btnVolver = findViewById<Button>(R.id.btnVolverInicio)

        btnRecuperar.setOnClickListener {
            val email = edtCorreo.text.toString().trim()

            // Validación: Solo necesitamos el correo para enviar el link de reseteo
            if (email.isNotEmpty()) {

                // --- LÓGICA DE RECUPERACIÓN REAL CON FIREBASE ---
                auth.sendPasswordResetEmail(email)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            // Éxito: Se notificó al usuario que debe revisar su correo
                            Toast.makeText(this, "Correo de recuperación enviado a $email. Revisa tu bandeja de entrada.", Toast.LENGTH_LONG).show()
                            // Volver al inicio
                            finish()
                        } else {
                            // Error: Falló el envío (p. ej. correo no registrado o error de conexión)
                            Toast.makeText(this, "Error: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Por favor, ingrese su correo electrónico", Toast.LENGTH_SHORT).show()
            }
        }

        btnVolver.setOnClickListener {
            finish() // vuelve a la pantalla anterior (InicioActivity)
        }
    }
}


