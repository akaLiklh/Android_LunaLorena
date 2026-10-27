package com.example.android_lunalorena

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EnemigoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val idEnemigo = intent.extras?.getInt("nuevo enemigo") ?: 0
        enableEdgeToEdge()
        setContentView(R.layout.activity_enemigo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val enemigo = MainActivity.listaEnemigos.buscar(idEnemigo)
        findViewById<TextView>(R.id.bIrEnemigo).text = enemigo.nombre
    }
}