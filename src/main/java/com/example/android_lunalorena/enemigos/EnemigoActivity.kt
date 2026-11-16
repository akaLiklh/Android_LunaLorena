package com.example.android_lunalorena.enemigos

import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.example.android_lunalorena.R
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_lunalorena.enemigos.modelo.RepositorioSingleton

class EnemigoActivity : AppCompatActivity() {
    companion object{
        const val NUMERO_PERS = "numero enemigo"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val idEnemigo = intent.extras?.getInt(NUMERO_PERS) ?: 0
        enableEdgeToEdge()
        setContentView(R.layout.activity_enemigo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val lista= RepositorioSingleton.instance.listaEnemigos
        val enemigo  = lista.buscar(idEnemigo)
        findViewById<TextView>(R.id.textNombre).text = enemigo.nombre

        val icono = findViewById<ImageView>(R.id.iconoGrande)
        val draw= AppCompatResources.getDrawable(this,enemigo.ubicacion.imagen)
        icono.setImageDrawable(draw)
        val textoDescripcion= findViewById<TextView>(R.id.textDescripcion)
        textoDescripcion.text = enemigo.descripcion
        val textoAtaquePrin=findViewById<TextView>(R.id.textAtaquePrin)
        textoAtaquePrin.text = enemigo.ataquePrincipal
        val textoAtaqueSec= findViewById<TextView>(R.id.textAtaqueSec)
        textoAtaqueSec.text = enemigo.ataqueSecundario
        val numDientes=findViewById<TextView>(R.id.textDientes)
        numDientes.text = enemigo.numeroDientes.toString()
        val ratingBar=findViewById<RatingBar>(R.id.dificultadEnemigo)
        ratingBar.rating = enemigo.dificultadEnemigo
    }
}