package com.example.creacion

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class RegistrarCuentaActivity : AppCompatActivity() {

    // Variables para Firebase
    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_cuenta)

        // 1. Inicializar Firebase
        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        // 2. Vincular con tus controles (IDs exactos de tu XML)
        val edtNombre = findViewById<EditText>(R.id.edtNombre)
        val edtApellido = findViewById<EditText>(R.id.edtApellido)
        val edtCorreo = findViewById<EditText>(R.id.edtCorreo)
        val edtRut = findViewById<EditText>(R.id.edtRut)
        val edtPass = findViewById<EditText>(R.id.edtPass)
        val edtPassConfirm = findViewById<EditText>(R.id.edtPassConfirm)

        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)
        val btnVolver = findViewById<Button>(R.id.btnVolverInicio)

        // 3. Configurar el botón de Registro
        btnRegistrar.setOnClickListener {
            // Obtener textos y quitar espacios en blanco
            val nombre = edtNombre.text.toString().trim()
            val apellido = edtApellido.text.toString().trim()
            val rut = edtRut.text.toString().trim()
            val correo = edtCorreo.text.toString().trim()
            val pass = edtPass.text.toString().trim()
            val confirm = edtPassConfirm.text.toString().trim()

            // --- VALIDACIONES ---
            if (nombre.isEmpty() || apellido.isEmpty() || rut.isEmpty() || correo.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Faltan datos por llenar", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (pass != confirm) {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (pass.length < 6) {
                Toast.makeText(this, "La contraseña es muy corta (mínimo 6)", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // --- CREACIÓN EN FIREBASE ---
            auth.createUserWithEmailAndPassword(correo, pass)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // 1. El login se creó con éxito
                        val userId = auth.currentUser?.uid

                        // 2. Preparamos los datos para guardar en la base de datos
                        val usuarioMap = hashMapOf(
                            "id" to userId,
                            "nombre" to nombre,
                            "apellido" to apellido,
                            "rut" to rut,
                            "correo" to correo
                        )

                        // 3. Guardar en Firestore (Colección "usuarios")
                        if (userId != null) {
                            db.collection("usuarios").document(userId)
                                .set(usuarioMap)
                                .addOnSuccessListener {
                                    // Todo salió perfecto
                                    mostrarAlertaExito()
                                }
                                .addOnFailureListener { e ->
                                    Toast.makeText(this, "Usuario creado pero falló guardar datos: ${e.message}", Toast.LENGTH_LONG).show()
                                }
                        }
                    } else {
                        // Falló el registro (correo repetido, internet, etc.)
                        Toast.makeText(this, "Error al registrar: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                    }
                }
        }

        // 4. Configurar botón Volver
        btnVolver.setOnClickListener {
            finish() // Cierra esta pantalla y regresa al Login
        }
    }

    private fun mostrarAlertaExito() {
        AlertDialog.Builder(this)
            .setTitle("¡Cuenta Creada!")
            .setMessage("Tu registro fue exitoso. Ahora puedes iniciar sesión con tus datos.")
            .setPositiveButton("Ir al Login") { _, _ ->
                // Regresar al Login limpiamente
                finish()
            }
            .setCancelable(false)
            .show()
    }
}