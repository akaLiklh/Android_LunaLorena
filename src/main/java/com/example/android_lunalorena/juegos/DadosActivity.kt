package com.example.android_lunalorena.juegos

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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
import androidx.appcompat.widget.Toolbar
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
        val barra = findViewById<Toolbar>(R.id.toolbarDadosAtras)
        setSupportActionBar(barra)

        val spinner = findViewById<Spinner>(R.id.spinnerCantidadDados)
        val grupo = findViewById<RadioGroup>(R.id.RadioGroupTipoDado)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)


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
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_atras,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val idBoton = item.itemId
        return when(idBoton){
            R.id.boton_menu_atras ->{
                val intent = Intent(this, JuegosActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}