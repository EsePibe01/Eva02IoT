package com.example.creacion

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class BienvenidaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida)

        val logo = findViewById<ImageView>(R.id.imgLogo)
        val anim = AnimationUtils.loadAnimation(this, R.anim.logo_anim)
        logo.startAnimation(anim)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, InicioActivity::class.java))
            finish()
        }, 2000)
    }
}



