package com.example.android_lunalorena.enemigos

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_lunalorena.R
import com.example.android_lunalorena.enemigos.datos.Ubicacion
import com.example.android_lunalorena.enemigos.vista.AdaptadorLista

class ListaActivity : AppCompatActivity() {
    companion object {
        const val UBICACION = "ubicacion"
    }

    private lateinit var adaptador: AdaptadorLista

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val ubicacion = intent.getStringExtra(UBICACION)?.let { Ubicacion.valueOf(it) }

        val titulo = findViewById<TextView>(R.id.textTituloLista)
        titulo.text = if (ubicacion != null) "Enemigos de ${ubicacion.nombre}" else "Todos los enemigos"

        adaptador = AdaptadorLista(this, ubicacion)
        val recycler = findViewById<RecyclerView>(R.id.recyclerEnemigos)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adaptador
    }

    override fun onResume() {
        super.onResume()
        adaptador.refrescar()
    }
}