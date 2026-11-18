package com.example.android_lunalorena.enemigos.datos

public data class DatosEnemigo(
    var nombre: String,
    var ubicacion: Ubicacion,
    var descripcionBreve: String,
    var descripcion: String = "",
    var ataquePrincipal: String,
    var ataqueSecundario: String,
    var numeroDientes: Int = 0,
    var dificultadEnemigo : Float = 0f,
    var imagen: Int = 0

)