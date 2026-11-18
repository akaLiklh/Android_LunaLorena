package com.example.android_lunalorena.juegos

import android.graphics.Color
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.android_lunalorena.R
import com.google.android.material.button.MaterialButton

class LightsOutActivity : AppCompatActivity() {

    private lateinit var botones: List<MaterialButton>
    private lateinit var txtEstado: TextView

    private val luces = mutableListOf(false, false, false, false, false, false, false, false, false)
    private var movimientos = 0

    private val vecinos = listOf(
        listOf(0, 1, 3),
        listOf(1, 0, 2, 4),
        listOf(2, 1, 5),
        listOf(3, 0, 4, 6),
        listOf(4, 1, 3, 5, 7),
        listOf(5, 2, 4, 8),
        listOf(6, 3, 7),
        listOf(7, 4, 6, 8),
        listOf(8, 5, 7)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lights_out)

        txtEstado = findViewById(R.id.txtEstado)
        botones = listOf(
            findViewById(R.id.b0), findViewById(R.id.b1), findViewById(R.id.b2),
            findViewById(R.id.b3), findViewById(R.id.b4), findViewById(R.id.b5),
            findViewById(R.id.b6), findViewById(R.id.b7), findViewById(R.id.b8)
        )

        for (i in 0..8) {
            botones[i].setOnClickListener { jugar(i) }
        }
        findViewById<MaterialButton>(R.id.bReiniciar).setOnClickListener { nuevaPartida() }
        findViewById<ImageButton>(R.id.atrasButton9).setOnClickListener { finish() }

        nuevaPartida()
    }

    private fun nuevaPartida() {
        for (i in 0..8) {
            luces[i] = false
        }
        repeat(10) { alternar((0..8).random()) }
        movimientos = 0
        actualizar()
    }

    private fun jugar(i: Int) {
        if (!luces.contains(true)) return
        alternar(i)
        movimientos++
        actualizar()
    }

    private fun alternar(i: Int) {
        for (j in vecinos[i]) {
            luces[j] = !luces[j]
        }
    }

    private fun actualizar() {
        for (i in 0..8) {
            if (luces[i]) {
                botones[i].setBackgroundColor(getColor(R.color.red))
            } else {
                botones[i].setBackgroundColor(Color.DKGRAY)
            }
        }

        if (!luces.contains(true)) {
            txtEstado.text = "¡Ganaste en $movimientos movimientos!"
        } else {
            txtEstado.text = "Movimientos: $movimientos"
        }
    }
}