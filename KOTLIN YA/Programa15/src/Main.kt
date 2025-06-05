fun main(parametro: Array<String>) {
    // Solicita al usuario el primer valor
    print("Ingrese primer valor:")
    val valor1 = readLine()!!.toInt() // Lee y convierte el primer valor a entero

    // Solicita el segundo valor
    print("Ingrese segundo valor:")
    val valor2 = readLine()!!.toInt() // Lee y convierte el segundo valor a entero

    // Usa una expresión if para determinar cuál es el mayor de los dos valores
    val mayor = if (valor1 > valor2) valor1 else valor2

    // Muestra el resultado en consola
    println("El mayor entre $valor1 y $valor2 es $mayor")
}
