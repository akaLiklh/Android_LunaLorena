package com.example.android_lunalorena.enemigos

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_lunalorena.R
import com.example.android_lunalorena.enemigos.vista.AdaptadorLista

class ListaActivity : AppCompatActivity() {

    private val adaptador = AdaptadorLista.getInstance()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista_enemigos)

        val recycler = findViewById<RecyclerView>(R.id.listaEnemigos)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adaptador

        val barra = findViewById<Toolbar>(R.id.toolbarLista)
        setSupportActionBar(barra)
        supportActionBar?.setDisplayShowTitleEnabled(false)

    }

    override fun onResume() {
        super.onResume()
        adaptador.refrescar()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_crear_enemigo,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val idBoton = item.itemId
        return when(idBoton){
            R.id.boton_menu_nuevo ->{
                val intent = Intent(this, EditarEnemigoActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.boton_menu_atras ->{
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
