package com.example.android_lunalorena.modelo

public data class DatosEnemigo(
    var id : Int,
    val nombre: String,
    val ubicacion: String,
    var descripcion: String = "",
    val ataquePrincipal: String,
    val ataqueSecundario: String,
    var numeroDientes: Int = 0,
    var dificultadEnemigo : Int = 0
)