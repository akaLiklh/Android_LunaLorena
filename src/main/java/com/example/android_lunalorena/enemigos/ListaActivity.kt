package com.example.android_lunalorena.enemigos

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_lunalorena.R
import com.example.android_lunalorena.enemigos.datos.Ubicacion
import com.example.android_lunalorena.enemigos.modelo.RepositorioSingleton
import com.example.android_lunalorena.enemigos.vista.AdaptadorLista
import com.example.android_lunalorena.enemigos.vista.AdaptadorLista.Companion.NUMERO_PERS

class ListaActivity : AppCompatActivity() {
    companion object {
        const val UBICACION = "ubicacion"
    }
    private lateinit var adaptador: AdaptadorLista

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val ubicacion = intent.getStringExtra(UBICACION)?.let { Ubicacion.valueOf(it) }

        val titulo = findViewById<TextView>(R.id.textTituloLista)
        titulo.text = if (ubicacion != null) "Enemigos de ${ubicacion.nombre}" else "Todos los enemigos"

        adaptador = AdaptadorLista(this, ubicacion)
        val recycler = findViewById<RecyclerView>(R.id.listaEnemigos)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adaptador

        findViewById<ImageButton>(R.id.iconoMas).setOnClickListener {
            val intent = Intent(this, EditarEnemigoActivity::class.java)
            intent.putExtra("MODO", "NUEVO")
            startActivity(intent)
        }
        findViewById<ImageButton>(R.id.iconoEditar).setOnClickListener {
            dialogoEditar()
        }
        findViewById<ImageButton>(R.id.iconoEliminar).setOnClickListener {
            dialogoEliminar()
        }

    }
    fun dialogoEliminar(){
        val entrada = EditText(this)
        entrada.hint=NUMERO_PERS
        AlertDialog.Builder(this)
            .setTitle("Elimina un enemigo")
            .setTitle("Introduce un numero para eliminar el enemigo")
            .setView(entrada)
            .setPositiveButton("Eliminar"){p0,p1 ->
                val num=entrada.text.toString().toInt()
                RepositorioSingleton.instance.listaEnemigos.borrar(num)
                AlertDialog.Builder(this)
                    .setTitle("Correcto")
                    .setMessage("El enemigo se ha eliminado correctamente")
                    .setPositiveButton("Aceptar", null)
                    .show()
            }
            .setNegativeButton("Cancelar",null)
            .show()
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


    override fun onResume() {
        super.onResume()
        adaptador.refrescar()
    }
}