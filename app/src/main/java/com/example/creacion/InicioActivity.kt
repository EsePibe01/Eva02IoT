package com.example.creacion

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class InicioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnRecuperar = findViewById<Button>(R.id.btnRecuperar)
        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)

        btnLogin.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Iniciar Sesión")
                .setMessage("Simulación de inicio de sesión exitosa")
                .setPositiveButton("OK", null)
                .show()
        }

        btnRecuperar.setOnClickListener {
            startActivity(Intent(this, RecuperarClaveActivity::class.java))
        }

        btnRegistrar.setOnClickListener {
            startActivity(Intent(this, RegistrarCuentaActivity::class.java))
        }
    }
}
