fun main(argumento: Array<String>) {
    // Muestra un mensaje en consola solicitando el primer valor
    print("Ingrese primer valor:")

    // Lee la entrada del usuario desde consola, la convierte a entero y la guarda en valor1
    val valor1 = readLine()!!.toInt()

    // Muestra un mensaje solicitando el segundo valor
    print("Ingrese segundo valor:")

    // Lee la entrada del usuario y la guarda como entero en valor2
    val valor2 = readLine()!!.toInt()

    // Calcula la suma de los dos valores ingresados
    val suma = valor1 + valor2

    // Imprime el resultado de la suma
    println("La suma de $valor1 y $valor2 es $suma")

    // Calcula el producto de los dos valores ingresados
    val producto = valor1 * valor2

    // Imprime el resultado del producto
    println("El producto de $valor1 y $valor2 es $producto")
}
