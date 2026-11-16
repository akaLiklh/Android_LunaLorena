package com.example.android_lunalorena.juegos

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_lunalorena.R
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import com.example.android_lunalorena.InicioActivity


class DadosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dados)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val spinner = findViewById<Spinner>(R.id.spinnerCantidadDados)
        val grupo = findViewById<RadioGroup>(R.id.RadioGroupTipoDado)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        findViewById<ImageButton>(R.id.atrasButton3).setOnClickListener {
            startActivity(Intent(this, InicioActivity::class.java))
        }
        findViewById<Button>(R.id.bLanzar).setOnClickListener {
            val cantidad = spinner.selectedItem.toString().toInt()

            val caras = when (grupo.checkedRadioButtonId) {
                R.id.radioButtonD8 -> 8
                R.id.radioButtonD12 -> 12
                else -> 6
            }

            var suma = 0
            var texto = ""
            for (i in 1..cantidad) {
                val resultado = (1..caras).random()
                suma += resultado
                texto += "Dado $i: $resultado\n"
            }
            texto += "\nSuma total: $suma"

            txtResultado.text = texto
        }
    }
}