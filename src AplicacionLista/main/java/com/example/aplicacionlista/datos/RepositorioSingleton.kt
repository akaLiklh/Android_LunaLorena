package com.example.aplicacionlista.datos

class RepositorioSingleton private constructor(){

    companion object{
        val instance = RepositorioSingleton()
    }

    val listaEnemigos: RepositorioEnemigos= ListaEnemigos();

    init {
        listaEnemigos.poblar()
    }


}