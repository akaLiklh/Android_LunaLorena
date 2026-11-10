package com.example.aplicacionlista

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aplicacionlista.datos.ListaEnemigos
import com.example.aplicacionlista.datos.RepositorioEnemigos

class MainActivity : AppCompatActivity() {
    companion object{
        const val NUMERO_PERS = "numero enemigo"
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
        findViewById<Button>(R.id.bIrEnemigo).setOnClickListener{
            dialogoElegir()
        }

        findViewById<Button>(R.id.bLista).setOnClickListener {
            val intent = Intent(this, ListaActivity::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.bNuevo).setOnClickListener {
            val intent = Intent(this, EditarEnemigoActivity::class.java)
            intent.putExtra("MODO", "NUEVO")
            startActivity(intent)
        }
        findViewById<Button>(R.id.bModificar).setOnClickListener {
            dialogoEditar()
         }
    }

    fun dialogoEditar(){
        val entrada = EditText(this)
        entrada.inputType = InputType.TYPE_CLASS_NUMBER
        entrada.hint=NUMERO_PERS
        AlertDialog.Builder(this)
            .setTitle("Edita un enemigo")
            .setTitle("Introduce un numero para editar el enemigo")
            .setView(entrada)
            .setPositiveButton("Editar"){p0,p1->
                val num=entrada.text.toString().toInt()
                val intent = Intent(this,EditarEnemigoActivity::class.java)
                intent.putExtra("MODO", "EDITAR")
                intent.putExtra(NUMERO_PERS, num)
                startActivity(intent)
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }
    fun dialogoElegir(){
        val entrada = EditText(this)
        entrada.inputType= InputType.TYPE_CLASS_NUMBER
        entrada.hint = NUMERO_PERS
        AlertDialog.Builder(this)
            .setTitle("Elige un enemigo")
            .setTitle("Introduce un numero para elegir el enemigo")
            .setView(entrada)
            .setPositiveButton("Buscar"){ p0,p1 ->
                val num = entrada.text.toString().toInt()
//                val personajeSelecionado = listaEnemigos.buscar(num)
//                Log.d("LISTA","")
                val intent = Intent(this, EnemigoActivity::class.java)
                intent.putExtra(NUMERO_PERS, num)
                startActivity(intent)
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }
}