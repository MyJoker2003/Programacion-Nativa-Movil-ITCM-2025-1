package Conceptos_Basicos


// Catálogo de canciones-----------------------------------------------------------

/**
 * Función principal que sirve como punto de entrada de la aplicación.
 * Aquí se crean instancias de la clase [Song] y se demuestran sus funcionalidades.
 */
fun main() {
    // Crea una instancia de la clase Song con los detalles de la canción "We Don't Talk About Bruno".
    val brunoSong = Song("We Don't Talk About Bruno", "Encanto Cast", 2022, 1_000_000)

    /**
     * Llama al método [printDescription] de la instancia [brunoSong] para imprimir
     * una descripción formateada de la canción en la consola.
     */
    brunoSong.printDescription()

    /**
     * Imprime en la consola el estado de popularidad de la canción.
     * La propiedad [isPopular] devuelve `true` si el conteo de reproducciones
     * es igual o superior a 1000, de lo contrario devuelve `false`.
     */
    println(brunoSong.isPopular)
}

/**
 * Clase que representa una canción con sus propiedades básicas.
 *
 * @property title El título de la canción.
 * @property artist El artista o grupo que interpreta la canción.
 * @property yearPublished El año en que la canción fue publicada.
 * @property playCount El número total de veces que la canción ha sido reproducida.
 */
class Song(
    val title: String, // Propiedad que almacena el título de la canción.
    val artist: String, // Propiedad que almacena el nombre del artista.
    val yearPublished: Int, // Propiedad que almacena el año de publicación de la canción.
    val playCount: Int // Propiedad que almacena el número de reproducciones de la canción.
) {
    /**
     * Propiedad calculada que determina si la canción es considerada popular.
     * Una canción es popular si su [playCount] es igual o superior a 1000.
     *
     * @return `true` si la canción es popular, `false` en caso contrario.
     */
    val isPopular: Boolean
        get() = playCount >= 1000 // La lógica para determinar la popularidad.

    /**
     * Imprime una descripción legible de la canción en la consola.
     * El formato incluye el título, artista y año de publicación.
     */
    fun printDescription() {
        // Usa interpolación de cadenas para construir y imprimir la descripción.
        println("$title, performed by $artist, was released in $yearPublished.")
    }
}