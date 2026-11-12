package com.example.juegopiedrapapelytijeras

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    var numDerrotas=0
    var numVictorias=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.bPiedra).setOnClickListener{
            jugar("Piedra")
        }
        findViewById<Button>(R.id.bPapel).setOnClickListener {
            jugar("Papel")
        }
        findViewById<Button>(R.id.bTijera).setOnClickListener {
            jugar("Tijera")
        }
    }

    private fun jugar(jugador: String) {
        var txtDispositivo= findViewById<TextView>(R.id.txtDispositivo)
        var txtVictorias=findViewById<TextView>(R.id.txtVictorias)
        var txtDerrotas=findViewById<TextView>(R.id.txtDerrotas)

        val opciones=listOf("Piedra","Papel","Tijera")
        val dispositivo=opciones.random()

        if(jugador=="Piedra" && dispositivo=="Tijera" ||
            jugador=="Papel" && dispositivo=="Piedra" ||
            jugador=="Tijera" && dispositivo=="Papel"){
            numVictorias++
        }else if(jugador==dispositivo){

        }else{
            numDerrotas++
        }
        txtDispositivo.text=dispositivo
        txtVictorias.text=numVictorias.toString()
        txtDerrotas.text=numDerrotas.toString()
    }
}