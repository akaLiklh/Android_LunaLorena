package com.example.android_lunalorena.enemigos.modelo

import com.example.android_lunalorena.enemigos.datos.RepositorioEnemigos

class RepositorioSingleton private constructor(){

    companion object{
        val instance = RepositorioSingleton()
    }

    val listaEnemigos: RepositorioEnemigos = ListaEnemigos();

    init {
        listaEnemigos.poblar()
    }


}