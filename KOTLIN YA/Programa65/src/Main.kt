fun main(argumento: Array<String>) {
    // Variables para contar la cantidad de triángulos de cada tipo
    var cant1 = 0  // Cantidad de triángulos equiláteros
    var cant2 = 0  // Cantidad de triángulos isósceles
    var cant3 = 0  // Cantidad de triángulos escalenos

    // Se pide al usuario que ingrese la cantidad de triángulos a procesar
    print("Ingrese la cantidad de triángulos:")
    val n = readln().toInt()

    // Se repite el proceso para cada triángulo (n veces)
    for(i in 1..n) {
        // Se piden los tres lados del triángulo
        print("Ingrese lado 1:")
        val lado1 = readln().toInt()
        print("Ingrese lado 2:")
        val lado2 = readln().toInt()
        print("Ingrese lado 3:")
        val lado3 = readln().toInt()

        // Usamos una estructura 'when' para determinar el tipo de triángulo
        when {
            // Si los tres lados son iguales, es un triángulo equilátero
            lado1 == lado2 && lado1 == lado3 -> {
                println("Es un triángulo equilátero.")
                cant1++  // Se incrementa el contador de triángulos equiláteros
            }
            // Si al menos dos lados son iguales, es un triángulo isósceles
            lado1 == lado2 || lado1 == lado3 || lado2 == lado3 -> {
                println("Es un triángulo isósceles.")
                cant2++  // Se incrementa el contador de triángulos isósceles
            }
            // Si ninguno de los lados es igual, es un triángulo escaleno
            else -> {
                println("Es un triángulo escaleno.")
                cant3++  // Se incrementa el contador de triángulos escalenos
            }
        }
    }

    // Al final, se imprime la cantidad de triángulos de cada tipo
    println("Cantidad de triángulos equiláteros: $cant1")
    println("Cantidad de triángulos isósceles: $cant2")
    println("Cantidad de triángulos escalenos: $cant3")
}
