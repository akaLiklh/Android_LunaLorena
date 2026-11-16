package com.example.android_lunalorena.juegos

import android.content.Intent
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.android_lunalorena.InicioActivity
import com.example.android_lunalorena.R


class TresEnRayaActivity : AppCompatActivity() {
    private lateinit var botones: List<Button>
    private lateinit var txtEstado: TextView
    private var terminado = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tres_en_raya)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        findViewById<ImageButton>(R.id.atrasButton6).setOnClickListener {
            startActivity(Intent(this, InicioActivity::class.java))
        }
        txtEstado = findViewById(R.id.txtEstado)
        botones = listOf(
            findViewById(R.id.b0), findViewById(R.id.b1), findViewById(R.id.b2),
            findViewById(R.id.b3), findViewById(R.id.b4), findViewById(R.id.b5),
            findViewById(R.id.b6), findViewById(R.id.b7), findViewById(R.id.b8)
        )

        for (b in botones) b.setOnClickListener { jugar(b) }

        findViewById<Button>(R.id.bReiniciar).setOnClickListener {
            for (b in botones) b.text = ""
            txtEstado.text = "Tu turno"
            terminado = false
        }
    }

    private fun jugar(b: Button) {
        if (terminado || b.text != "") return

        b.text = "X"
        if (gana("X")) return fin("¡Has ganado!")

        val libres = botones.filter { it.text == "" }
        if (libres.isEmpty()) return fin("Empate")

        libres.random().text = "O"
        if (gana("O")) fin("Gana el dispositivo")
    }

    private fun fin(mensaje: String) {
        txtEstado.text = mensaje
        terminado = true
    }

    private fun gana(p: String): Boolean {
        val lineas = listOf(
            listOf(0, 1, 2), listOf(3, 4, 5), listOf(6, 7, 8),
            listOf(0, 3, 6), listOf(1, 4, 7), listOf(2, 5, 8),
            listOf(0, 4, 8), listOf(2, 4, 6)
        )
        return lineas.any { l -> l.all { botones[it].text == p } }
    }
}