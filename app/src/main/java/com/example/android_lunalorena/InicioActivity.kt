package com.example.android_lunalorena

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_lunalorena.calculadora.CalculadoraActivity
import com.example.android_lunalorena.conversor.ConversorActivity
import com.example.android_lunalorena.enemigos.ListaActivity
import com.example.android_lunalorena.juegos.JuegosActivity

class InicioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inicio)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.bCalculadora).setOnClickListener {
            startActivity(Intent(this, CalculadoraActivity::class.java))
        }
        findViewById<Button>(R.id.bConversor).setOnClickListener {
            startActivity(Intent(this, ConversorActivity::class.java))
        }
        findViewById<Button>(R.id.bJuegos).setOnClickListener {
            startActivity(Intent(this, JuegosActivity::class.java))
        }
        findViewById<Button>(R.id.bListaEnemigos).setOnClickListener {
            startActivity(Intent(this, ListaActivity::class.java))
        }
    }
}