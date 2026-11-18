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
        const val NUMERO_PERS = "numero enemigo"

        private var instance: AdaptadorLista? = null

        fun getInstance(): AdaptadorLista {
            if (instance == null) instance = AdaptadorLista()
            return instance!!
        }
    }

    private val lista = RepositorioSingleton.instance.listaEnemigos
    private var indices = calcularIndices()

    private fun calcularIndices(): List<Int> {
        return (0 until lista.longitud()).filter { id ->
            ubicacion == null || lista.buscar(id).ubicacion == ubicacion
        }
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
        val id = indices.getOrNull(position) ?: return
        if (id !in 0 until lista.longitud()) return

        val enemigo = lista.buscar(id)
        val foto = if (enemigo.imagen != 0) enemigo.imagen else enemigo.ubicacion.imagen

        holder.itemView.findViewById<TextView>(R.id.tarjeta_numero).text = (position + 1).toString()
        holder.itemView.findViewById<TextView>(R.id.tarjeta_nombre).text = enemigo.nombre
        holder.itemView.findViewById<TextView>(R.id.tarjeta_breve).text = enemigo.descripcionBreve
        holder.itemView.findViewById<ImageView>(R.id.icono_pequenno).setImageDrawable(
            AppCompatResources.getDrawable(holder.itemView.context, foto)
        )

        holder.itemView.findViewById<LinearLayout>(R.id.base_tarjeta).setOnClickListener {
            if (id in 0 until lista.longitud()) {
                val intent = Intent(holder.itemView.context, EnemigoActivity::class.java)
                intent.putExtra(EnemigoActivity.NUMERO_PERS, id)
                holder.itemView.context.startActivity(intent)
            } else {
                refrescar()
            }
        }
    }

    override fun getItemCount(): Int = indices.size

    class CreadorItems(itemView: View) : RecyclerView.ViewHolder(itemView)
}