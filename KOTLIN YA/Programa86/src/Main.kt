// Función que devuelve el mayor de los dos valores pasados como parámetros
fun devolverMayor(v1: Int, v2: Int) = if (v1 > v2) v1 else v2

fun main(parametro: Array<String>) {
    // Solicita al usuario que ingrese el primer valor
    print("Ingrese el primer valor:")
    val valor1 = readLine()!!.toInt() // Lee el valor ingresado y lo convierte a entero

    // Solicita al usuario que ingrese el segundo valor
    print("Ingrese el segundo valor:")
    val valor2 = readLine()!!.toInt() // Lee el segundo valor ingresado y lo convierte a entero

    // Llama a la función devolverMayor para determinar cuál es el mayor de los dos
    // Luego, imprime el resultado en la consola
    println("El mayor entre $valor1 y $valor2 es ${devolverMayor(valor1, valor2)}")
}
