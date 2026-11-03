package com.example.aplicacionlista.datos

import com.example.aplicacionlista.modelo.DatosEnemigo
import com.example.aplicacionlista.modelo.Ubicacion

interface RepositorioEnemigos {
    fun poblar(){
        nuevoEnemigo(
            DatosEnemigo(
                "El fabricante de Muñecas",
                Ubicacion.TRENINFERNAL,
                "Es la encarnación del País de las Maravillas del Dr. Angus Bumby. Fue el cerebro detrás del Tren Infernal y la corrupción del País de las Maravillas. Tras su derrota y la muerte de su contraparte del mundo real, Alice Liddell pudo una vez más salvarse a sí misma y sus recuerdos.",
                "Arañazo de Uñas : La mano clavará sus garras en el cristal bajo Alice y lo arrastrará por la superficie, produciendo un ruido fuerte y agudo.",
                "Residuo : La mano trazará una fina línea en el cristal y soplará el residuo químico hacia Alice.",
                500,
                5.0f
            )
        )

        nuevoEnemigo(
            DatosEnemigo(
                "Ruina insidiosa",
                Ubicacion.VALLELAGRIMAS,
                "Una combinación antinatural y hostil de piezas mecánicas destrozadas vomita contaminación y arrasa con todo a su paso. Como una enfermedad industrial sin sentido, rezuma grasa y lodo mecánico y empuña un arma peligrosa. Su sonido repugnante y su hedor nauseabundo completan su aura amenazante. Una cabeza espantosa acentúa aún más su aspecto repulsivo.",
                "Zarpazo : Insidious Ruin intentará atacar a Alice si se acerca demasiado.",
                "Impulso: habilidad mediante la cual sus motores la impulsan hacia adelante, para acercarse rápidamente a Alice y atacarla.",
                3,
                1.0f
            )
        )

        nuevoEnemigo(
            DatosEnemigo(
                "Niña Muñeca",
                Ubicacion.CASAMUNECAS,
                "La Muñeca es el doble de grande que Alicia y no tiene ojos. Está armada con dos mitades de unas tijeras y suele blandirlas juguetonamente hacia Alicia, quien grita y se tambalea. También puede encontrarse con una variante con garfios en lugar de manos. Camina como un bebé y ríe histéricamente cuando \"ve\" a Alicia.",
                "Corte giratorio : La Chica Muñeca gira rápidamente, dejando estelas en el aire. El contacto con sus cuchillas en ese momento causará mucho daño.",
                "Golpe descendente : La Chica Muñeca baja su arma a una velocidad extrema.",
                35,
                4.0f
            )
        )

        nuevoEnemigo(
            DatosEnemigo(
                "Protector de tarjeta blindado",
                Ubicacion.QUEENSLAND,
                "Las cuencas oculares del Guardia de Cartas Acorazado brillan con un rojo intenso. Está cubierto con una cota de malla y porta un hacha de asta con la hoja en forma de corazón. La armadura le otorga una invulnerabilidad casi total a todo tipo de ataque, y el hacha de asta inflige un daño considerable.",
                "Golpe : El Guardia de Cartas Acorazado blandirá su hacha de guerra y la estrellará contra Alice. Si este ataque falla, quedará aturdido durante unos segundos y vulnerable.",
                "No tiene ataque secundario.",
                30,
                2.0f
            )
        )

        nuevoEnemigo(
            DatosEnemigo(
                "Caballero Rojo",
                Ubicacion.QUEENSLAND,
                "Los Caballeros Rojos son completamente rojos desde la melena hasta el tronco y visten armadura de caballero en la parte superior del cuerpo, y solo poseen una espada para atacar.",
                "Zarpazo : El caballero blandirá su espada violentamente contra Alicia.",
                "No tiene ataque secundario.",
                20,
                2.0f
            )
        )


        nuevoEnemigo(
            DatosEnemigo(
                "Ruina Amenazadora",
                Ubicacion.CASAMUNECAS,
                "",
                "",
                "",
                1,
                1.0f
            )
        )


        nuevoEnemigo(
            DatosEnemigo(
                "El Juguetero",
                Ubicacion.TRENINFERNAL,
                "",
                "",
                "",
                43,
                1.0f
            )
        )
        /*nuevoEnemigo(
            DatosEnemigo(
                "Loco del Capirote",
                Ubicacion.NOMBREUBICACION,
                "",
                "",
                "",
                12,
                1.0f
            )
        )*/
        /*nuevoEnemigo(
            DatosEnemigo(
                "Pernólula",
                Ubicacion.NOMBREUBICACION,
                "",
                "",
                "",
                2,
                1.0f
            )
        )*/
        nuevoEnemigo(
            DatosEnemigo(
                "Reina de Corazones",
                Ubicacion.QUEENSLAND,
                "",
                "",
                "",
                38,
                1.0f
            )
        )
        /*nuevoEnemigo(
            DatosEnemigo(
                "Ricura",
                Ubicacion.NOMBREUBICACION,
                "",
                "",
                "",
                1,
                1.0f
            )
        )*/
        nuevoEnemigo(
            DatosEnemigo(
                "Tetera Ojo",
                Ubicacion.DOMINIOSOMBRERERO,
                "",
                "",
                "",
                6,
                1.0f
            )
        )
        nuevoEnemigo(
            DatosEnemigo(
                "Cangrejo Cañon",
                Ubicacion.DOMINIOSOMBRERERO,
                "",
                "",
                "",
                8,
                1.0f
            )
        )

    }
    fun nuevoEnemigo(p: DatosEnemigo)
    fun actualizar(id: Int, p: DatosEnemigo)
    fun borrar(id:Int)
    fun buscar(id: Int): DatosEnemigo
    fun longitud(): Int
}