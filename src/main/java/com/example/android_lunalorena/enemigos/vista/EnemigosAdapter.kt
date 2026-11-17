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

class AdaptadorLista(val ubicacion: Ubicacion? = null) :
    RecyclerView.Adapter<AdaptadorLista.CreadorItems>() {

    companion object {
        const val NUMERO_PERS = "numero enemigo"
        private var instance: AdaptadorLista? = null
        fun getInstance(): AdaptadorLista {
            if (instance != null) {
                return instance!!
            } else {
                instance = AdaptadorLista()
                return instance!!
            }
        }
    }

    val lista = RepositorioSingleton.instance.listaEnemigos
    private var indices: List<Int> = calcularIndices()
    private fun calcularIndices(): List<Int> =
        (0 until lista.longitud()).filter { id ->
            ubicacion == null || lista.buscar(id).ubicacion == ubicacion
        }

    fun refrescar() {
        indices = calcularIndices()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreadorItems {
        val contexto = parent.context
        val inflador = contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val vista = inflador.inflate(R.layout.tarjeta_enemigo, parent, false)
        return CreadorItems(vista, parent.context)
    }

    override fun onBindViewHolder(holder: CreadorItems, position: Int) {
        val id = indices[position]
        val enemigo = lista.buscar(id)

        holder.itemView.findViewById<TextView>(R.id.tarjeta_nombre).text = enemigo.nombre
        holder.itemView.findViewById<TextView>(R.id.tarjeta_breve).text = enemigo.descripcionBreve
        val draw = AppCompatResources.getDrawable(holder.contexto, enemigo.ubicacion.imagen)
        holder.itemView.findViewById<ImageView>(R.id.icono_pequenno).setImageDrawable(draw)

    }

    override fun getItemCount(): Int = indices.size

    class CreadorItems(itemView: View, val contexto: Context) : RecyclerView.ViewHolder(itemView) {
        init {
            val layout = itemView.findViewById<LinearLayout>(R.id.base_tarjeta)
            layout.setOnClickListener {
                val position = bindingAdapterPosition
                val intent = Intent(contexto, EnemigoActivity::class.java)
                intent.putExtra(EnemigoActivity.NUMERO_PERS, position)
                contexto.startActivity(intent)
            }
        }
    }
}