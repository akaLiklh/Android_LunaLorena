package com.example.android_lunalorena.enemigos.vista

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.example.android_lunalorena.R
import com.example.android_lunalorena.enemigos.EnemigoActivity
import com.example.android_lunalorena.enemigos.datos.Ubicacion
import com.example.android_lunalorena.enemigos.modelo.RepositorioSingleton

class AdaptadorLista(val ubicacion: Ubicacion? = null) :
    RecyclerView.Adapter<AdaptadorLista.CreadorItems>() {

    companion object {
        val instance = AdaptadorLista()
    }

    private val lista = RepositorioSingleton.instance.listaEnemigos
    private var indices = calcularIndices()

    private fun calcularIndices(): MutableList<Int> {
        val resultado = mutableListOf<Int>()
        for (i in 0 until lista.longitud()) {
            if (ubicacion == null || lista.buscar(i).ubicacion == ubicacion) {
                resultado.add(i)
            }
        }
        return resultado
    }

    fun refrescar() {
        indices = calcularIndices()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreadorItems {
        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_tarjeta_enemigo, parent, false)
        return CreadorItems(vista)
    }

    override fun onBindViewHolder(holder: CreadorItems, position: Int) {
        val vista = holder.itemView
        val id = indices[position]
        val enemigo = lista.buscar(id)

        var foto = enemigo.imagen
        if (foto == 0) {
            foto = enemigo.ubicacion.imagen
        }

        vista.findViewById<TextView>(R.id.tarjeta_numero).text = (position + 1).toString()
        vista.findViewById<TextView>(R.id.tarjeta_nombre).text = enemigo.nombre
        vista.findViewById<TextView>(R.id.tarjeta_breve).text = enemigo.descripcionBreve
        vista.findViewById<ImageView>(R.id.icono_pequenno)
            .setImageDrawable(AppCompatResources.getDrawable(vista.context, foto))

        vista.findViewById<LinearLayout>(R.id.base_tarjeta).setOnClickListener {
            val intent = Intent(vista.context, EnemigoActivity::class.java)
            intent.putExtra(EnemigoActivity.NUMERO_PERS, id)
            vista.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = indices.size

    class CreadorItems(itemView: View) : RecyclerView.ViewHolder(itemView)
}