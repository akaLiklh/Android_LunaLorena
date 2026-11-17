package com.example.android_lunalorena.enemigos

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_lunalorena.R
import com.example.android_lunalorena.enemigos.datos.Ubicacion
import com.example.android_lunalorena.enemigos.modelo.RepositorioSingleton
import com.example.android_lunalorena.enemigos.vista.AdaptadorLista
import com.example.android_lunalorena.enemigos.vista.AdaptadorLista.Companion.NUMERO_PERS

class ListaActivity : AppCompatActivity() {
    companion object {
        const val UBICACION = "ubicacion"
    }
    private lateinit var adaptador: AdaptadorLista
    var idEnemigo: Int= 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        val idEnemigo = intent.extras?.getInt(EnemigoActivity.NUMERO_PERS) ?: 0
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val ubicacion = intent.getStringExtra(UBICACION)?.let { Ubicacion.valueOf(it) }

        adaptador = AdaptadorLista(this, ubicacion)
        val recycler = findViewById<RecyclerView>(R.id.listaEnemigos)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adaptador


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_crear_enemigo,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.d("MENU", "PULSADO EL ITEM")

        val idBoton = item.itemId
        return when(idBoton){
            R.id.boton_menu_nuevo ->{
                val intent = Intent(this, EditarEnemigoActivity::class.java)
                intent.putExtra(EnemigoActivity.NUMERO_PERS,idEnemigo)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onResume() {
        super.onResume()
        adaptador.refrescar()
    }
}