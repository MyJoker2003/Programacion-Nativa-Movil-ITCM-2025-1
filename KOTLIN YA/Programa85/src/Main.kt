// Función que calcula la superficie de un cuadrado. Recibe un entero (lado) y retorna su superficie.
fun calcularSuperficieCuadrado(lado: Int) = lado * lado

fun main(parametro: Array<String>) {
    // Solicita al usuario que ingrese el valor del lado del cuadrado
    print("Ingrese el valor del lado del cuadrado:")
    val la = readLine()!!.toInt() // Lee el valor ingresado y lo convierte a entero

    // Muestra el resultado de la superficie calculada llamando a la función
    println("La superficie del cuadrado es ${calcularSuperficieCuadrado(la)}")
}
