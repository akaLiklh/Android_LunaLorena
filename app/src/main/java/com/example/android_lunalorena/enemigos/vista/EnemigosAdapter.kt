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
import com.example.android_lunalorena.enemigos.modelo.RepositorioSingleton

class AdaptadorLista(val context: Context): RecyclerView.Adapter<AdaptadorLista.CreadorItems>() {
    companion object{
        const val NUMERO_PERS = "numero enemigo"
    }
    val lista = RepositorioSingleton.instance.listaEnemigos
    val inflador= context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CreadorItems {
        val vista = inflador.inflate((R.layout.tarjeta_enemigo),parent, false)
        return CreadorItems(vista,context)
    }

    override fun onBindViewHolder(
        holder: CreadorItems,
        position: Int
    ) {
        val enemigo = lista.buscar(position)
        holder.itemView.findViewById<TextView>(R.id.tarjeta_nombre)
            .text = enemigo.nombre
        holder.itemView.findViewById<TextView>(R.id.tarjeta_breve)
            .text=enemigo.descripcionBreve
        /*holder.itemView.findViewById<TextView>(R.id.tarjeta_ataquePrin)
            .text=enemigo.ataquePrincipal
        holder.itemView.findViewById<TextView>(R.id.tarjeta_ataqueSec)
            .text=enemigo.ataqueSecundario
        holder.itemView.findViewById<TextView>(R.id.tarjeta_numDientes)
            .text=enemigo.numeroDientes.toString()
        holder.itemView.findViewById<RatingBar>(R.id.tarjeta_dificultad)
            .rating=enemigo.dificultadEnemigo*/
        val draw = AppCompatResources.getDrawable(context,enemigo.ubicacion.imagen)
        holder.itemView.findViewById<ImageView>(R.id.icono_pequenno)
            .setImageDrawable(draw)
    }

    override fun getItemCount(): Int {
        return lista.longitud()
    }

    class CreadorItems(itemView: View, val context: Context) : RecyclerView.ViewHolder(itemView){

        init{
            val layout = itemView.findViewById<LinearLayout>(R.id.base_tarjeta)
            layout.setOnClickListener {
                val position= bindingAdapterPosition
                val intent = Intent(context, EnemigoActivity::class.java)
                intent.putExtra(NUMERO_PERS,position)
                context.startActivity(intent)
            }
        }
    }
}