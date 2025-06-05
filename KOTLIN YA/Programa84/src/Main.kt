// Función que calcula la superficie de un rectángulo recibiendo como parámetros
// los dos lados del rectángulo (lado1 y lado2).
fun retornarSuperficie(lado1: Int, lado2: Int): Int {
    // La superficie de un rectángulo se calcula multiplicando su largo por su ancho
    return lado1 * lado2
}

fun main(parametro: Array<String>) {
    // Solicitar al usuario los lados del primer rectángulo
    println("Primer rectángulo")
    print("Ingrese lado menor del rectángulo:")
    val lado1 = readln().toInt() // Lee el primer lado del rectángulo
    print("Ingrese lado mayor del rectángulo:")
    val lado2 = readln().toInt() // Lee el segundo lado del rectángulo

    // Solicitar al usuario los lados del segundo rectángulo
    println("Segundo rectángulo")
    print("Ingrese lado menor del rectángulo:")
    val lado3 = readln().toInt() // Lee el primer lado del segundo rectángulo
    print("Ingrese lado mayor del rectángulo:")
    val lado4 = readln().toInt() // Lee el segundo lado del segundo rectángulo

    // Comparar las superficies de los dos rectángulos
    if (retornarSuperficie(lado1, lado2) == retornarSuperficie(lado3, lado4)) {
        // Si las superficies son iguales
        println("Los dos rectángulos tienen la misma superficie")
    } else if (retornarSuperficie(lado1, lado2) > retornarSuperficie(lado3, lado4)) {
        // Si el primer rectángulo tiene mayor superficie
        println("El primer rectángulo tiene una superficie mayor")
    } else {
        // Si el segundo rectángulo tiene mayor superficie
        println("El segundo rectángulo tiene una superficie mayor")
    }
}
