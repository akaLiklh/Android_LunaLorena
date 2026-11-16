package com.example.android_lunalorena.enemigos

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Spinner
import com.example.android_lunalorena.R
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_lunalorena.enemigos.datos.DatosEnemigo
import com.example.android_lunalorena.enemigos.datos.Ubicacion
import com.example.android_lunalorena.enemigos.modelo.RepositorioSingleton
import com.example.android_lunalorena.enemigos.vista.AdaptadorLista.Companion.NUMERO_PERS


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
        val textoNombre = findViewById<EditText>(R.id.editarNombre)
        val spUbicacion=findViewById<Spinner>(R.id.spinner)
        val textoDescripcionBreve = findViewById<EditText>(R.id.editarDescripcionBreve)
        val textoDescripcion = findViewById<EditText>(R.id.editarDescripcion)
        val textoAtaquePrin = findViewById<EditText>(R.id.editarAtaquePrin)
        val textoAtaqueSec = findViewById<EditText>(R.id.editarAtaqueSec)
        val numeroDientes = findViewById<EditText>(R.id.editarDientes)
        val ratingBar = findViewById<RatingBar>(R.id.editarDificultadEnemigo)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, Ubicacion.values())

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spUbicacion.adapter = adapter

        if (modo == "EDITAR") {

            val enemigo = RepositorioSingleton.instance.listaEnemigos.buscar(idEnemigo)

            textoNombre.setText(enemigo.nombre)
            spUbicacion.setSelection(enemigo.ubicacion.ordinal)
            textoDescripcionBreve.setText(enemigo.descripcionBreve)
            textoDescripcion.setText(enemigo.descripcion)
            textoAtaquePrin.setText(enemigo.ataquePrincipal)
            textoAtaqueSec.setText(enemigo.ataqueSecundario)
            numeroDientes.setText(enemigo.numeroDientes.toString())
            ratingBar.setRating(enemigo.dificultadEnemigo.toFloat())
        }
        val btnGuardar= findViewById<Button>(R.id.bGuardar)

        btnGuardar.setOnClickListener {

            val enemigo = DatosEnemigo(
                textoNombre.text.toString(),
                spUbicacion.selectedItem as Ubicacion,
                textoDescripcionBreve.text.toString(),
                textoDescripcion.text.toString(),
                textoAtaquePrin.text.toString(),
                textoAtaqueSec.text.toString(),
                numeroDientes.text.toString().toInt(),
                ratingBar.rating
            )

            if (modo == "NUEVO") {

                RepositorioSingleton.instance.listaEnemigos.nuevoEnemigo(enemigo)

            } else {

                RepositorioSingleton.instance.listaEnemigos.actualizar(idEnemigo, enemigo)
            }

            finish()

        }
    }
}