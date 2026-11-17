package com.example.android_lunalorena.juegos

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_lunalorena.InicioActivity
import com.example.android_lunalorena.R

class JuegosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_juegos)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val barra = findViewById<Toolbar>(R.id.toolbarJuegosAtras)
        setSupportActionBar(barra)

        findViewById<Button>(R.id.bPiedraPapelTijera).setOnClickListener {
            startActivity(Intent(this, PiedraPapelTijeraActivity::class.java))
        }

        findViewById<Button>(R.id.bDados).setOnClickListener {
            startActivity(Intent(this, DadosActivity::class.java))
        }

        findViewById<Button>(R.id.bTresEnRaya).setOnClickListener {
            startActivity(Intent(this, TresEnRayaActivity::class.java))
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_atras,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val idBoton = item.itemId
        return when(idBoton){
            R.id.boton_menu_atras ->{
                val intent = Intent(this, InicioActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}