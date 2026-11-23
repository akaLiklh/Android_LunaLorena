package com.example.android_lunalorena.enemigos

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RatingBar
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.android_lunalorena.R
import com.example.android_lunalorena.enemigos.datos.DatosEnemigo
import com.example.android_lunalorena.enemigos.datos.Ubicacion
import com.example.android_lunalorena.enemigos.modelo.RepositorioSingleton

class EditarEnemigoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_editar_enemigo)

        val repo = RepositorioSingleton.instance.listaEnemigos
        val idEnemigo = intent.getIntExtra(EnemigoActivity.NUMERO_PERS, -1)
        val esEdicion = idEnemigo >= 0 && idEnemigo < repo.longitud()

        val nom = findViewById<EditText>(R.id.editarNombre)
        val ubi = findViewById<Spinner>(R.id.spinner)
        val desBrev = findViewById<EditText>(R.id.editarDescripcionBreve)
        val des = findViewById<EditText>(R.id.editarDescripcion)
        val ataPr = findViewById<EditText>(R.id.editarAtaquePrin)
        val ataSe = findViewById<EditText>(R.id.editarAtaqueSec)
        val dnt = findViewById<EditText>(R.id.editarDientes)
        val dif = findViewById<RatingBar>(R.id.editarDificultadEnemigo)

        val ubicaciones = Ubicacion.values()
        val nombres = mutableListOf<String>()

        for (lugar in ubicaciones) {
            nombres.add(lugar.nombre)
        }
        val adaptadorUbi = ArrayAdapter(this, android.R.layout.simple_spinner_item, nombres)
        adaptadorUbi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        ubi.adapter = adaptadorUbi

        findViewById<ImageButton>(R.id.atrasButton5).setOnClickListener { finish() }

        if (esEdicion) {
            val enemigo = repo.buscar(idEnemigo)
            nom.setText(enemigo.nombre)
            ubi.setSelection(enemigo.ubicacion.ordinal)
            desBrev.setText(enemigo.descripcionBreve)
            des.setText(enemigo.descripcion)
            ataPr.setText(enemigo.ataquePrincipal)
            ataSe.setText(enemigo.ataqueSecundario)
            dnt.setText(enemigo.numeroDientes.toString())
            dif.rating = enemigo.dificultadEnemigo
        } else {
            findViewById<TextView>(R.id.textTituloEditarEnemigo).text = "Nuevo enemigo"
            val zona = intent.getStringExtra(UbicacionActivity.UBICACION)
            if (zona != null) {
                ubi.setSelection(Ubicacion.valueOf(zona).ordinal)
            }
        }

        findViewById<Button>(R.id.bGuardar).setOnClickListener {
            if (nom.text.isEmpty()) {
                nom.error = "Escribe un nombre"
            } else {
                val ubicacion = ubicaciones[ubi.selectedItemPosition]
                val dientes = dnt.text.toString().toIntOrNull() ?: 0

                if (esEdicion) {
                    val enemigo = repo.buscar(idEnemigo)
                    enemigo.nombre = nom.text.toString()
                    enemigo.ubicacion = ubicacion
                    enemigo.descripcionBreve = desBrev.text.toString()
                    enemigo.descripcion = des.text.toString()
                    enemigo.ataquePrincipal = ataPr.text.toString()
                    enemigo.ataqueSecundario = ataSe.text.toString()
                    enemigo.numeroDientes = dientes
                    enemigo.dificultadEnemigo = dif.rating
                } else {
                    repo.nuevoEnemigo(
                        DatosEnemigo(
                            nombre = nom.text.toString(),
                            ubicacion = ubicacion,
                            descripcionBreve = desBrev.text.toString(),
                            descripcion = des.text.toString(),
                            ataquePrincipal = ataPr.text.toString(),
                            ataqueSecundario = ataSe.text.toString(),
                            numeroDientes = dientes,
                            dificultadEnemigo = dif.rating
                        )
                    )
                }
                finish()
            }
        }
    }
}