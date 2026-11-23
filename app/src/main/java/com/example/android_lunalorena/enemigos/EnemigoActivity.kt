package com.example.android_lunalorena.enemigos

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.Toolbar
import com.example.android_lunalorena.R
import com.example.android_lunalorena.enemigos.modelo.RepositorioSingleton

class EnemigoActivity : AppCompatActivity() {

    companion object {
        const val NUMERO_PERS = "numero enemigo"
    }

    private var idEnemigo = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_enemigo)

        idEnemigo = intent.getIntExtra(NUMERO_PERS, -1)

        val barra = findViewById<Toolbar>(R.id.toolbarEnemigo)
        setSupportActionBar(barra)
        supportActionBar?.setDisplayShowTitleEnabled(false)

    }

    override fun onResume() {
        super.onResume()

        val repo = RepositorioSingleton.instance.listaEnemigos
        if (idEnemigo < 0 || idEnemigo >= repo.longitud()) {
            finish()
            return
        }

        val enemigo = repo.buscar(idEnemigo)
        val foto = if (enemigo.imagen != 0) enemigo.imagen else enemigo.ubicacion.imagen

        findViewById<TextView>(R.id.textNombre).text = enemigo.nombre
        findViewById<ImageView>(R.id.iconoGrande).setImageDrawable(
            AppCompatResources.getDrawable(this, foto)
        )
        findViewById<TextView>(R.id.textDescripcion).text = enemigo.descripcion
        findViewById<TextView>(R.id.textAtaquePrin).text = enemigo.ataquePrincipal
        findViewById<TextView>(R.id.textAtaqueSec).text = enemigo.ataqueSecundario
        findViewById<TextView>(R.id.textDientes).text = enemigo.numeroDientes.toString()
        findViewById<RatingBar>(R.id.dificultadEnemigo).rating = enemigo.dificultadEnemigo
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_editar_eliminar_enemigo,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val idBoton = item.itemId
        return when (idBoton) {
            R.id.boton_menu_editar -> {
                val intent = Intent(this, EditarEnemigoActivity::class.java)
                intent.putExtra(NUMERO_PERS,idEnemigo)
                startActivity(intent)
                true
            }

            R.id.boton_menu_atras -> {
                finish()
                true
            }

            R.id.boton_menu_eliminar -> {
                AlertDialog.Builder(this)
                    .setTitle("Eliminar enemigo")
                    .setMessage("¿Seguro que quieres eliminar este enemigo?")
                    .setNegativeButton("Cancelar", null)
                    .setPositiveButton("Eliminar") { _, _ ->
                        RepositorioSingleton.instance.listaEnemigos.borrar(idEnemigo)
                        finish()
                    }
                    .show()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}