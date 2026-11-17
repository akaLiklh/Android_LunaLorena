package com.example.android_lunalorena.enemigos


import android.os.Bundle

import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Spinner

import com.example.android_lunalorena.R

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import com.example.android_lunalorena.enemigos.datos.Ubicacion
import com.example.android_lunalorena.enemigos.modelo.RepositorioSingleton
import com.example.android_lunalorena.enemigos.vista.AdaptadorLista
import com.example.android_lunalorena.enemigos.vista.AdaptadorLista.Companion.NUMERO_PERS


class EditarEnemigoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val idEnemigo = intent.extras?.getInt(NUMERO_PERS) ?: 0
        enableEdgeToEdge()
        setContentView(R.layout.activity_editar_enemigo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        if(idEnemigo!=null) {
            val enemigo = RepositorioSingleton.instance.listaEnemigos.buscar(idEnemigo)

            val nom = findViewById<EditText>(R.id.editarNombre)
                nom.setText(enemigo.nombre)
            val ubi = findViewById<Spinner>(R.id.spinner)
                ubi.setSelection(enemigo.ubicacion.ordinal)
            val desBrev = findViewById<EditText>(R.id.editarDescripcionBreve)
                desBrev.setText(enemigo.descripcionBreve)
            val des = findViewById<EditText>(R.id.editarDescripcion)
                des.setText(enemigo.descripcion)
            val ataPr = findViewById<EditText>(R.id.editarAtaquePrin)
                ataPr.setText(enemigo.ataquePrincipal)
            val ataSe = findViewById<EditText>(R.id.editarAtaqueSec)
                ataSe.setText(enemigo.ataqueSecundario)
            val dnt = findViewById<EditText>(R.id.editarDientes)
                dnt.setText(enemigo.numeroDientes.toString())
            val difEne = findViewById<RatingBar>(R.id.editarDificultadEnemigo)
                difEne.setRating(enemigo.dificultadEnemigo.toFloat())

            /*val adapter =
                ArrayAdapter(this, android.R.layout.simple_spinner_item, Ubicacion.values())
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            ubi.adapter = adapter*/

            val bGuardar = findViewById<Button>(R.id.bGuardar)
            bGuardar.setOnClickListener{
                enemigo.nombre = nom.text.toString()
                enemigo.ubicacion = ubi.selectedItem as Ubicacion
                enemigo.descripcionBreve = desBrev.text.toString()
                enemigo.descripcion = des.text.toString()
                enemigo.ataquePrincipal = ataPr.text.toString()
                enemigo.ataqueSecundario = ataSe.text.toString()
                enemigo.numeroDientes = dnt.text.toString().toInt()
                enemigo.dificultadEnemigo = difEne.rating.toString().toFloat()

                RepositorioSingleton.instance.listaEnemigos.actualizar(idEnemigo, enemigo)
                AdaptadorLista.getInstance().notifyItemChanged(idEnemigo)
                finish()
            }
        } else {



        }

    }
}