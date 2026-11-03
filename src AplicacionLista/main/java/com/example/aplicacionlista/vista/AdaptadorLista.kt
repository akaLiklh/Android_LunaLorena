package com.example.aplicacionlista.vista

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacionlista.MainActivity
import com.example.aplicacionlista.R

class AdaptadorLista(val context: Context): RecyclerView.Adapter<AdaptadorLista.CreadorItems>() {
    val inflador= context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CreadorItems {
        val vista = inflador.inflate((R.layout.tarjeta_enemigo),parent, false)
        return CreadorItems(vista)
    }

    override fun onBindViewHolder(
        holder: CreadorItems,
        position: Int
    ) {
        val enemigo = MainActivity.listaEnemigos.buscar(position)
        holder.itemView.findViewById<TextView>(R.id.tarjeta_nombre)
            .text = enemigo.nombre
    }

    override fun getItemCount(): Int {
        return MainActivity.listaEnemigos.longitud()
    }

    class CreadorItems(itemView: View) : RecyclerView.ViewHolder(itemView){
    }
}