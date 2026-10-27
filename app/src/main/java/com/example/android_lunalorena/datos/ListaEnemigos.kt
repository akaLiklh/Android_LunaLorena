package com.example.android_lunalorena.datos

import com.example.android_lunalorena.modelo.DatosEnemigo

class ListaEnemigos : RepositorioEnemigos {
    private val listaEnemigos: MutableList<DatosEnemigo> = mutableListOf()

    override fun nuevoEnemigo(p: DatosEnemigo) {
        listaEnemigos.add(p)
    }

    override fun actualizar(id: Int, p: DatosEnemigo) {
        listaEnemigos[id] = p
    }

    override fun borrar(id: Int) {
        listaEnemigos.removeAt(id)
    }

    override fun buscar(id: Int): DatosEnemigo = listaEnemigos[id]

    override fun longitud(): Int {
        return listaEnemigos.size
    }
}