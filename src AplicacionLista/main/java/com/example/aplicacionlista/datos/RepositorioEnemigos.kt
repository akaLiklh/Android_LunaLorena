package com.example.aplicacionlista.datos

import com.example.aplicacionlista.modelo.DatosEnemigo

interface RepositorioEnemigos {
    fun poblar(){
        nuevoEnemigo(
            DatosEnemigo(
                "El fabricante de Muñecas",
                "Tren Infernal",
                "Es la encarnación del País de las Maravillas del Dr. Angus Bumby. Fue el cerebro detrás del Tren Infernal y la corrupción del País de las Maravillas. Tras su derrota y la muerte de su contraparte del mundo real, Alice Liddell pudo una vez más salvarse a sí misma y sus recuerdos.",
                "Arañazo de Uñas : La mano clavará sus garras en el cristal bajo Alice y lo arrastrará por la superficie, produciendo un ruido fuerte y agudo.",
                "Residuo : La mano trazará una fina línea en el cristal y soplará el residuo químico hacia Alice.",
                500,
                5)
        )

        nuevoEnemigo(
            DatosEnemigo(
                "Ruina insidiosa",
                "Valle de las Lágrimas",
                "Una combinación antinatural y hostil de piezas mecánicas destrozadas vomita contaminación y arrasa con todo a su paso. Como una enfermedad industrial sin sentido, rezuma grasa y lodo mecánico y empuña un arma peligrosa. Su sonido repugnante y su hedor nauseabundo completan su aura amenazante. Una cabeza espantosa acentúa aún más su aspecto repulsivo.",
                "Zarpazo : Insidious Ruin intentará atacar a Alice si se acerca demasiado.",
                "Impulso: habilidad mediante la cual sus motores la impulsan hacia adelante, para acercarse rápidamente a Alice y atacarla.",
                3,
                1
            )
        )

        nuevoEnemigo(
            DatosEnemigo(
                "Niña Muñeca",
                "Casa de Muñecas",
                "La Muñeca es el doble de grande que Alicia y no tiene ojos. Está armada con dos mitades de unas tijeras y suele blandirlas juguetonamente hacia Alicia, quien grita y se tambalea. También puede encontrarse con una variante con garfios en lugar de manos. Camina como un bebé y ríe histéricamente cuando \"ve\" a Alicia.",
                "Corte giratorio : La Chica Muñeca gira rápidamente, dejando estelas en el aire. El contacto con sus cuchillas en ese momento causará mucho daño.",
                "Golpe descendente : La Chica Muñeca baja su arma a una velocidad extrema.",
                35,
                4
            )
        )

        nuevoEnemigo(
            DatosEnemigo(
                "Protector de tarjeta blindado",
                "Queensland",
                "Las cuencas oculares del Guardia de Cartas Acorazado brillan con un rojo intenso. Está cubierto con una cota de malla y porta un hacha de asta con la hoja en forma de corazón. La armadura le otorga una invulnerabilidad casi total a todo tipo de ataque, y el hacha de asta inflige un daño considerable.",
                "Golpe : El Guardia de Cartas Acorazado blandirá su hacha de guerra y la estrellará contra Alice. Si este ataque falla, quedará aturdido durante unos segundos y vulnerable.",
                "No tiene ataque secundario.",
                30,
                2
            )
        )

        nuevoEnemigo(
            DatosEnemigo(
                "Caballero Rojo",
                "Queensland",
                "Los Caballeros Rojos son completamente rojos desde la melena hasta el tronco y visten armadura de caballero en la parte superior del cuerpo, y solo poseen una espada para atacar.",
                "Zarpazo : El caballero blandirá su espada violentamente contra Alicia.",
                "No tiene ataque secundario.",
                20,
                2
            )
        )


        nuevoEnemigo(
            DatosEnemigo(
                "Ruina Amenazadora",
                "Casa de Muñecas",
                "",
                "",
                "",
                1,
                1)
        )


        nuevoEnemigo(
            DatosEnemigo(
                "El Juguetero",
                "Tren Infernal",
                "",
                "",
                "",
                43,
                1)
        )
        nuevoEnemigo(
            DatosEnemigo(
                "Loco del Capirote",
                "",
                "",
                "",
                "",
                12,
                1)
        )
        nuevoEnemigo(
            DatosEnemigo(
                "Pernólula",
                "",
                "",
                "",
                "",
                2,
                1)
        )
        nuevoEnemigo(
            DatosEnemigo(
                "Reina de Corazones",
                "Tierra de la Reina",
                "",
                "",
                "",
                38,
                1)
        )
        nuevoEnemigo(
            DatosEnemigo(
                "Ricura",
                "",
                "",
                "",
                "",
                1,
                1)
        )
        nuevoEnemigo(
            DatosEnemigo(
                "Tetera Ojo",
                "Dominio del Sombrerero",
                "",
                "",
                "",
                6,
                1)
        )
        nuevoEnemigo(
            DatosEnemigo(
                "Cangrejo Cañon",
                "Dominio del Sombrerero",
                "",
                "",
                "",
                8,
                1)
        )

    }
    fun nuevoEnemigo(p: DatosEnemigo)
    fun actualizar(id: Int, p: DatosEnemigo)
    fun borrar(id:Int)
    fun buscar(id: Int): DatosEnemigo
    fun longitud(): Int
}