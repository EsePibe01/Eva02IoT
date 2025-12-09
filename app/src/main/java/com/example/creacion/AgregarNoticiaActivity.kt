// file: app/src/main/java/com/example/creacion/AgregarNoticiaActivity.kt
package com.example.creacion

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import java.util.Date

class AgregarNoticiaActivity : AppCompatActivity() {

    // Variable para Firebase Firestore
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_noticia)

        // 1. Inicializar Firebase Firestore
        db = FirebaseFirestore.getInstance()

        // 2. Vincular controles
        val edtTitulo = findViewById<EditText>(R.id.edtTituloNoticia)
        val edtDescripcion = findViewById<EditText>(R.id.edtDescripcionNoticia)
        val btnGuardar = findViewById<Button>(R.id.btnGuardarNoticia)
        val btnVolver = findViewById<Button>(R.id.btnVolverNoticias)

        // 3. Configurar el botón Guardar
        btnGuardar.setOnClickListener {
            val titulo = edtTitulo.text.toString().trim()
            val descripcion = edtDescripcion.text.toString().trim()

            if (titulo.isNotEmpty() && descripcion.isNotEmpty()) {

                // --- LÓGICA DE GUARDADO EN FIREBASE FIRESTORE ---
                val noticiaMap = hashMapOf(
                    "titulo" to titulo,
                    "descripcion" to descripcion,
                    "fecha" to Date()
                )

                // Guardar en Firestore (Colección "noticias")
                db.collection("noticias").add(noticiaMap)
                    .addOnSuccessListener { documentReference ->
                        // Éxito: Se agregó la noticia.
                        Toast.makeText(this, "Noticia agregada con éxito (ID: ${documentReference.id})", Toast.LENGTH_LONG).show()
                        finish() // Cierra esta pantalla y regresa a MainActivity
                    }
                    .addOnFailureListener { e ->
                        // Error al guardar
                        Toast.makeText(this, "Error al guardar la noticia: ${e.message}", Toast.LENGTH_LONG).show()
                    }

            } else {
                Toast.makeText(this, "Por favor complete el título y la descripción", Toast.LENGTH_SHORT).show()
            }
        }

        // 4. Configurar botón Volver
        btnVolver.setOnClickListener {
            finish() // Cierra esta pantalla y regresa a MainActivity
        }
    }
}