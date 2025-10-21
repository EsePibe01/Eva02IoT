package com.example.creacion

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class BienvenidaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida)

        Handler().postDelayed({
            startActivity(Intent(this, InicioActivity::class.java))
            finish()
        }, 2000) // 2 segundos
    }
}


