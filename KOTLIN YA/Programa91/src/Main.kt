// Función que devuelve la cantidad de caracteres de un nombre
fun largoNom(nombre: String) = nombre.length

fun main(parametro: Array<String>) {
    // Solicitar los dos nombres al usuario
    print("Ingrese un nombre: ")
    val nombre1 = readln()
    print("Ingrese otro nombre: ")
    val nombre2 = readln()

    // Comparar los largos de los dos nombres
    if (largoNom(nombre1) == largoNom(nombre2)) {
        println("Los nombres: $nombre1 y $nombre2 tienen la misma cantidad de caracteres")
    } else if (largoNom(nombre1) > largoNom(nombre2)) {
        println("$nombre1 es más largo")
    } else {
        println("$nombre2 es más largo")
    }
}
