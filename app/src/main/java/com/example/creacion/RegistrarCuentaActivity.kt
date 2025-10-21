package com.example.creacion

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class RegistrarCuentaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_cuenta)

        val btnRegistrarCuenta = findViewById<Button>(R.id.btnRegistrarCuenta)

        btnRegistrarCuenta.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Registrar Cuenta")
                .setMessage("Simulación de registro exitoso")
                .setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss()
                    finish()  // Cierra esta Activity y vuelve a InicioActivity
                }
                .show()
        }
    }
}

