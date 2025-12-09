// file: app/src/main/java/com/example/creacion/MainActivity.kt
package com.example.creacion

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth // Importar Firebase Auth

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth // Declarar FirebaseAuth
    // REMOVIDO: private val noticias = mutableListOf<String>() // Lista simulada de noticias

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar Firebase Auth
        auth = FirebaseAuth.getInstance() // Inicializar

        val btnVerNoticias = findViewById<Button>(R.id.btnVerNoticias)
        val btnAgregarNoticia = findViewById<Button>(R.id.btnAgregarNoticia)
        val btnLogout = findViewById<Button>(R.id.btnLogout) // Vincular el nuevo botón

        // --- BOTÓN VER NOTICIAS ---
        // Simulación: En un escenario real, este botón debería lanzar una actividad con un RecyclerView
        // que muestre la lista de noticias cargadas de Firebase Firestore.
        btnVerNoticias.setOnClickListener {
            mostrarNoticiasSimulado()
        }

        // --- BOTÓN AGREGAR NOTICIA (LANZA LA NUEVA ACTIVIDAD) ---
        btnAgregarNoticia.setOnClickListener {
            // Ahora navega a la nueva Activity dedicada para agregar noticias (el "new page")
            startActivity(Intent(this, AgregarNoticiaActivity::class.java))
        }

        // --- BOTÓN CERRAR SESIÓN ---
        btnLogout.setOnClickListener {
            auth.signOut() // Cierra la sesión de Firebase

            // Navegar a la pantalla de inicio (InicioActivity)
            val intent = Intent(this, InicioActivity::class.java).apply {
                // Estas banderas aseguran que todas las actividades anteriores sean borradas
                // y que InicioActivity sea la única en la pila.
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            startActivity(intent)
            Toast.makeText(this, "Sesión cerrada con éxito", Toast.LENGTH_SHORT).show()
            finish() // Cierra MainActivity para que el usuario no pueda volver con el botón "back"
        }
    }

    // Método para simular la vista de noticias (reemplaza la lógica anterior)
    private fun mostrarNoticiasSimulado() {
        AlertDialog.Builder(this)
            .setTitle("Noticias (Simulado)")
            .setMessage("Este botón debería llevar a una pantalla de lista de noticias cargadas desde la base de datos (Firestore).")
            .setPositiveButton("Cerrar", null)
            .show()
    }
}