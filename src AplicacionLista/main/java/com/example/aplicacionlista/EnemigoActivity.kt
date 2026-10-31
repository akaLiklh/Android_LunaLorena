package com.example.aplicacionlista

import android.os.Bundle
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EnemigoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val idEnemigo = intent.extras?.getInt("numero enemigo") ?: 0
        enableEdgeToEdge()
        setContentView(R.layout.activity_enemigo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val enemigo  = MainActivity.listaEnemigos.buscar(idEnemigo)
        findViewById<TextView>(R.id.textNombre).text = enemigo.nombre
        findViewById<TextView>(R.id.textUbicacion).text = enemigo.ubicacion
        findViewById<TextView>(R.id.textDescripcion).text = enemigo.descripcion
        findViewById<TextView>(R.id.textAtaquePrin).text = enemigo.ataquePrincipal
        findViewById<TextView>(R.id.textAtaqueSec).text = enemigo.ataqueSecundario
        findViewById<TextView>(R.id.textDientes).text = enemigo.numeroDientes.toString()
        findViewById<RatingBar>(R.id.dificultadEnemigo).rating = enemigo.dificultadEnemigo.toFloat()
    }
}