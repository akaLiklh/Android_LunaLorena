package com.example.android_lunalorena.enemigos

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_lunalorena.R
import com.example.android_lunalorena.enemigos.vista.AdaptadorLista

class ListaActivity : AppCompatActivity() {

    private val adaptador = AdaptadorLista.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista_enemigos)

        val recycler = findViewById<RecyclerView>(R.id.listaEnemigos)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adaptador

        findViewById<ImageButton>(R.id.atrasButton6).setOnClickListener { finish() }

        findViewById<ImageButton>(R.id.iconoMas).setOnClickListener {
            val intent = Intent(this, EditarEnemigoActivity::class.java)
            intent.putExtra(EnemigoActivity.NUMERO_PERS, -1)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        adaptador.refrescar()
    }
}
