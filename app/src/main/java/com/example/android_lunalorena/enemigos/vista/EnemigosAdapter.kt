package com.example.android_lunalorena.enemigos.vista

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.example.android_lunalorena.enemigos.EnemigoActivity
import com.example.android_lunalorena.R
import com.example.android_lunalorena.enemigos.datos.Ubicacion
import com.example.android_lunalorena.enemigos.modelo.RepositorioSingleton

class AdaptadorLista(val context: Context, val ubicacion: Ubicacion? = null) :
    RecyclerView.Adapter<AdaptadorLista.CreadorItems>() {

    companion object {
        const val NUMERO_PERS = "numero enemigo"
    }

    val lista = RepositorioSingleton.instance.listaEnemigos
    val inflador = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    private var indices: List<Int> = calcularIndices()

    private fun calcularIndices(): List<Int> =
        (0 until lista.longitud()).filter { id ->
            ubicacion == null || lista.buscar(id).ubicacion == ubicacion
        }

    fun refrescar() {
        indices = calcularIndices()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreadorItems {
        val vista = inflador.inflate(R.layout.tarjeta_enemigo, parent, false)
        return CreadorItems(vista)
    }

    override fun onBindViewHolder(holder: CreadorItems, position: Int) {
        val id = indices[position]
        val enemigo = lista.buscar(id)

        holder.itemView.findViewById<TextView>(R.id.tarjeta_nombre).text = enemigo.nombre
        holder.itemView.findViewById<TextView>(R.id.tarjeta_breve).text = enemigo.descripcionBreve
        val draw = AppCompatResources.getDrawable(context, enemigo.ubicacion.imagen)
        holder.itemView.findViewById<ImageView>(R.id.icono_pequenno).setImageDrawable(draw)

        holder.itemView.findViewById<LinearLayout>(R.id.base_tarjeta).setOnClickListener {
            val intent = Intent(context, EnemigoActivity::class.java)
            intent.putExtra(NUMERO_PERS, id)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = indices.size

    class CreadorItems(itemView: View) : RecyclerView.ViewHolder(itemView)
}