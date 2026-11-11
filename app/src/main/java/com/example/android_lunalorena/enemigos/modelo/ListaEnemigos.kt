package com.example.android_lunalorena.enemigos.modelo

import com.example.android_lunalorena.enemigos.datos.DatosEnemigo
import com.example.android_lunalorena.enemigos.datos.RepositorioEnemigos
import com.example.android_lunalorena.enemigos.datos.Ubicacion

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

    override fun buscarPorUbicacion(ubicacion: Ubicacion): List<DatosEnemigo> {
        return lista.filter { it.ubicacion == ubicacion }
    }

    override fun longitud(): Int {
        return lista.size
    }
}