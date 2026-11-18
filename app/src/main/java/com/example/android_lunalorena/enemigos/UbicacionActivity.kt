package com.example.android_lunalorena.enemigos

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_lunalorena.R
import com.example.android_lunalorena.enemigos.datos.Ubicacion
import com.example.android_lunalorena.enemigos.vista.AdaptadorLista

class UbicacionActivity : AppCompatActivity() {

    companion object {
        const val UBICACION = "ubicacion"
    }

    private lateinit var adaptador: AdaptadorLista

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ubicacion)

        val ubicacion = Ubicacion.valueOf(intent.getStringExtra(UBICACION) ?: Ubicacion.TRENINFERNAL.name)

        findViewById<TextView>(R.id.textTituloUbicacion).text = ubicacion.nombre
        findViewById<ImageView>(R.id.imgUbicacion).setImageResource(ubicacion.imagen)
        findViewById<TextView>(R.id.txtFraseUbicacion).text = ubicacion.frase

        adaptador = AdaptadorLista(ubicacion)
        val recycler = findViewById<RecyclerView>(R.id.listaEnemigosUbicacion)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adaptador

        findViewById<ImageButton>(R.id.atrasButtonUbicacion).setOnClickListener { finish() }

        findViewById<ImageButton>(R.id.iconoMasUbicacion).setOnClickListener {
            val intent = Intent(this, EditarEnemigoActivity::class.java)
            intent.putExtra(EnemigoActivity.NUMERO_PERS, -1)
            intent.putExtra(UBICACION, ubicacion.name)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        adaptador.refrescar()
    }
}