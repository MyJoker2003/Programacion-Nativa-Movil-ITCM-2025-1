// Función que recibe un String y devuelve su longitud (cantidad de caracteres)
fun largo(nombre: String): Int {
    return nombre.length // Retorna la longitud del nombre ingresado
}

fun main(parametro: Array<String>) {
    // Solicita al usuario que ingrese un nombre
    print("Ingrese un nombre:")
    val nombre1 = readLine()!! // Lee el primer nombre ingresado por el usuario

    // Solicita al usuario que ingrese otro nombre
    print("Ingrese otro nombre:")
    val nombre2 = readLine()!! // Lee el segundo nombre ingresado por el usuario

    // Compara las longitudes de los dos nombres
    when {
        largo(nombre1) == largo(nombre2) -> // Si los nombres tienen la misma longitud
            println("Los nombres: $nombre1 y $nombre2 tienen la misma cantidad de caracteres")
        largo(nombre1) > largo(nombre2) -> // Si el primer nombre es más largo
            println("$nombre1 es más largo")
        else -> // Si el segundo nombre es más largo
            println("$nombre2 es más largo")
    }
}
