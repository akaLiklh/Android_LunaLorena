package com.example.aplicacionlista

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aplicacionlista.EnemigoActivity.Companion.NUMERO_PERS
import com.example.aplicacionlista.datos.RepositorioSingleton
import com.example.aplicacionlista.modelo.DatosEnemigo
import com.example.aplicacionlista.modelo.Ubicacion

class EditarEnemigoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val idEnemigo = intent.extras?.getInt(NUMERO_PERS) ?: 0
        val modo= intent.extras?.getString("MODO") ?:""
        enableEdgeToEdge()
        setContentView(R.layout.activity_editar_enemigo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val textoNombre2 = findViewById<EditText>(R.id.textNombre2)
        val spUbicacion2=findViewById<Spinner>(R.id.spinner)
        val textoDescripcionBreve2 = findViewById<EditText>(R.id.textDescripcionBreve2)
        val textoDescripcion2 = findViewById<EditText>(R.id.textDescripcion2)
        val textoAtaquePrin2 = findViewById<EditText>(R.id.textAtaquePrin2)
        val textoAtaqueSec2 = findViewById<EditText>(R.id.textAtaqueSec2)
        val numeroDientes2 = findViewById<EditText>(R.id.textDientes2)
        val ratingBar = findViewById<RatingBar>(R.id.dificultadEnemigo2)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, Ubicacion.values())

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spUbicacion2.adapter = adapter

        if (modo == "EDITAR") {

            val enemigo = RepositorioSingleton.instance.listaEnemigos.buscar(idEnemigo)

            textoNombre2.setText(enemigo.nombre)
            spUbicacion2.setSelection(enemigo.ubicacion.ordinal)
            textoDescripcionBreve2.setText(enemigo.descripcionBreve)
            textoDescripcion2.setText(enemigo.descripcion)
            textoAtaquePrin2.setText(enemigo.ataquePrincipal)
            textoAtaqueSec2.setText(enemigo.ataqueSecundario)
            numeroDientes2.setText(enemigo.numeroDientes.toString())
           ratingBar.setRating(enemigo.dificultadEnemigo.toFloat())
        }
        val btnGuardar= findViewById<Button>(R.id.bGuardar)

        btnGuardar.setOnClickListener {

            val enemigo = DatosEnemigo(
                textoNombre2.text.toString(),
                spUbicacion2.selectedItem as Ubicacion,
                textoDescripcionBreve2.text.toString(),
                textoDescripcion2.text.toString(),
                textoAtaquePrin2.text.toString(),
                textoAtaqueSec2.text.toString(),
                numeroDientes2.text.toString().toInt(),
                ratingBar.rating
            )

            if (modo == "NUEVO") {

                RepositorioSingleton.instance.listaEnemigos
                    .nuevoEnemigo(enemigo)

            } else {

                val idEnemigo = intent.getIntExtra(NUMERO_PERS, 0)

                RepositorioSingleton.instance.listaEnemigos
                    .actualizar(idEnemigo, enemigo)
            }

            finish()
        }
    }
}