// Función que calcula y retorna la superficie de un rectángulo
fun devolverSuperficie(lado1: Int, lado2: Int): Int = lado1 * lado2

fun main(parametro: Array<String>) {
    println("Primer rectángulo")
    print("Ingrese lado menor del rectángulo: ")
    val lado1 = readln().toInt()
    print("Ingrese lado mayor del rectángulo: ")
    val lado2 = readln().toInt()

    println("Segundo rectángulo")
    print("Ingrese lado menor del rectángulo: ")
    val lado3 = readln().toInt()
    print("Ingrese lado mayor del rectángulo: ")
    val lado4 = readln().toInt()

    // Comparación de las superficies de los dos rectángulos
    if (devolverSuperficie(lado1, lado2) == devolverSuperficie(lado3, lado4)) {
        println("Los dos rectángulos tienen la misma superficie.")
    } else if (devolverSuperficie(lado1, lado2) > devolverSuperficie(lado3, lado4)) {
        println("El primer rectángulo tiene una superficie mayor.")
    } else {
        println("El segundo rectángulo tiene una superficie mayor.")
    }
}
