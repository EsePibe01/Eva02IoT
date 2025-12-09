// file: app/src/main/java/com/example/creacion/MainActivity.kt
package com.example.creacion

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // REMOVIDO: private val noticias = mutableListOf<String>() // Lista simulada de noticias

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnVerNoticias = findViewById<Button>(R.id.btnVerNoticias)
        val btnAgregarNoticia = findViewById<Button>(R.id.btnAgregarNoticia)

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