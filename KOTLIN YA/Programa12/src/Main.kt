fun main(parametro: Array<String>) {
    // Solicita al usuario que ingrese el primer número
    print("Ingrese el primer valor:")
    val valor1 = readLine()!!.toInt() // Convierte la entrada a entero

    // Solicita el segundo número
    print("Ingrese el segundo valor:")
    val valor2 = readLine()!!.toInt() // Convierte la entrada a entero

    // Condición: si el primer valor es menor que el segundo
    if (valor1 < valor2) {
        val suma = valor1 + valor2 // Suma ambos valores
        val resta = valor1 - valor2 // Resta valor1 - valor2
        println("La suma de los dos valores es: $suma") // Imprime la suma
        println("La resta de los dos valores es: $resta") // Imprime la resta
    } else {
        val producto = valor1 * valor2 // Multiplica los dos valores
        val division = valor1 / valor2 // Divide valor1 entre valor2 (división entera)
        println("El producto de los dos valores es: $producto") // Imprime el producto
        println("La división de los dos valores es: $division") // Imprime la división
    }
}
