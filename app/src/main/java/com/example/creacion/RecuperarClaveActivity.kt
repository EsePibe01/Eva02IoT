package com.example.creacion

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class RecuperarClaveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperar_clave)

        val btnRecuperarClave = findViewById<Button>(R.id.btnRecuperarClave)

        btnRecuperarClave.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Recuperar Clave")
                .setMessage("Simulación de recuperación exitosa")
                .setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss()
                    finish()  // Cierra esta Activity y vuelve a InicioActivity
                }
                .show()
        }
    }
}
