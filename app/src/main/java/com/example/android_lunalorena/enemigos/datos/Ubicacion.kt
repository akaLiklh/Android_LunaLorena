package com.example.android_lunalorena.enemigos.datos
import com.example.android_lunalorena.R
enum class Ubicacion(val nombre: String, val imagen: Int, val frase: String) {
    VALLELAGRIMAS("Valle de Lágrimas", R.drawable.vallelagrimas,
        "No he vuelto aquí buscando pelea.¿De verdad? Qué pena, porque hay una que sí te está buscando a ti."),
    DOMINIOSOMBRERERO("Dominio del Sombrerero", R.drawable.dominiosombrerero,
        "Contéstame, Sombrerero, estoy sufriendo. Y los cambios aquí son la causa, o son un reflejo, o el efecto. ¿Qué está pasando?"),
    QUEENSLAND("Queensland", R.drawable.queensland,
        "¡Si me destruyes, te destruyes a ti misma! Vete ahora y una parte hueca de ti puede sobrevivir. Quédate y te derribaré; ¡Estarás perdida para siempre!"),
    CASAMUNECAS("Casa de Muñecas", R.drawable.casamunecas,
        "¿No soy el juguete del destino más lamentable y egoísta?"),
    TRENINFERNAL("Tren Infernal", R.drawable.treninfernal,
        "Las vías no llevan a ningún sitio y, aun así, el tren no se detiene. ¿De quién intenta escapar?")
}