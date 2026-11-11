package com.example.android_lunalorena.enemigos

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_lunalorena.R
import com.example.android_lunalorena.enemigos.vista.AdaptadorLista

class ListaActivity : AppCompatActivity() {

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

        adaptador = AdaptadorLista(this)
        val recycler = findViewById<RecyclerView>(R.id.recyclerEnemigos)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adaptador
    }

    // Al volver de editar/eliminar, refresca la lista
    override fun onResume() {
        super.onResume()
        adaptador.notifyDataSetChanged()
    }
}
