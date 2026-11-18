package com.example.android_lunalorena.juegos

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_lunalorena.R

class JuegosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_juegos)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        findViewById<ImageButton>(R.id.atrasButton2).setOnClickListener { finish() }
        findViewById<Button>(R.id.bPiedraPapelTijera).setOnClickListener {
            startActivity(Intent(this, PiedraPapelTijeraActivity::class.java))
        }

        findViewById<Button>(R.id.bDados).setOnClickListener {
            startActivity(Intent(this, DadosActivity::class.java))
        }

        findViewById<Button>(R.id.bLightOut).setOnClickListener {
            startActivity(Intent(this, LightsOutActivity::class.java))
        }
    }
}