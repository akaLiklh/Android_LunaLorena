package com.example.android_lunalorena.enemigos

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.android_lunalorena.InicioActivity
import com.example.android_lunalorena.R
import com.example.android_lunalorena.enemigos.datos.Ubicacion
import kotlin.jvm.java

class ListaUbicacionesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista_ubicaciones)

        findViewById<ImageButton>(R.id.atrasButton5).setOnClickListener { finish() }

        findViewById<TextView>(R.id.textTituloLista).setOnClickListener {
            startActivity(Intent(this, ListaActivity::class.java))
        }

        abrirZona(R.id.imgUbicacion1, R.id.tituloUbicacion1, Ubicacion.VALLELAGRIMAS)
        abrirZona(R.id.imgUbicacion2, R.id.tituloUbicacion2, Ubicacion.DOMINIOSOMBRERERO)
        abrirZona(R.id.imgUbicacion3, R.id.tituloUbicacion3, Ubicacion.QUEENSLAND)
        abrirZona(R.id.imgUbicacion4, R.id.tituloUbicacion4, Ubicacion.CASAMUNECAS)
        abrirZona(R.id.imgUbicacion5, R.id.tituloUbicacion5, Ubicacion.TRENINFERNAL)
    }

    private fun abrirZona(idImagen: Int, idTexto: Int, ubicacion: Ubicacion) {
        val abrir = {
            val intent = Intent(this, UbicacionActivity::class.java)
            intent.putExtra(UbicacionActivity.UBICACION, ubicacion.name)
            startActivity(intent)
        }
        findViewById<ImageButton>(idImagen).setOnClickListener { abrir() }
        findViewById<TextView>(idTexto).setOnClickListener { abrir() }
    }



}
