package com.example.aplicacionlista.datos

import com.example.aplicacionlista.modelo.DatosEnemigo

class ListaEnemigos : RepositorioEnemigos {
    val lista: MutableList<DatosEnemigo> = mutableListOf()

    override fun nuevoEnemigo(p: DatosEnemigo) {
        lista.add(p)
    }

    override fun actualizar(id: Int, p: DatosEnemigo) {
        lista[id] = p
    }

    override fun borrar(id: Int) {
        lista.removeAt(id)
    }

    override fun buscar(id: Int): DatosEnemigo = lista[id]

    override fun longitud(): Int {
        return lista.size
    }
}