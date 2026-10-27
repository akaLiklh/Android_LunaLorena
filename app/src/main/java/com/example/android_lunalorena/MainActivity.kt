package com.example.android_lunalorena

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_lunalorena.datos.ListaEnemigos

class MainActivity : AppCompatActivity() {
    companion object {
        val listaEnemigos = ListaEnemigos()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.bIrEnemigo).setOnClickListener {
            dialogoElegir()
        }
    }

    private fun dialogoElegir() {
        val entrada = EditText(this)
        entrada.inputType = InputType.TYPE_CLASS_NUMBER
        entrada.hint = "Número del enemigo: "

        AlertDialog.Builder(this)
            .setTitle("Elige un enemigo: ")
            .setTitle("Introduce un número para elegir el enemigo: ")
            .setView(entrada)
            .setPositiveButton("Buscar") { dialog, whichButton ->
                val num = entrada.text.toString().toInt()
                val enemigoSeleccionado = listaEnemigos.buscar(num)
                Log.d("ENEMIGOS LOG", enemigoSeleccionado.nombre)
                val intent = Intent(this, EnemigoActivity::class.java)
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }
}