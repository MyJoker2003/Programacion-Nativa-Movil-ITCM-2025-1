fun main(parametro: Array<String>) {
    // Inicialización de variables
    var x = 1
    var suma1 = 0

    // Ingreso de valores para la primera lista
    println("Ingreso de la primer lista de valores")
    while (x <= 5) {
        // Se solicita el ingreso de un valor para la lista 1
        print("Ingrese valor:")
        val valor = readln().toInt()

        // Se suma el valor ingresado a la suma total de la lista 1
        suma1 = suma1 + valor

        // Incremento del contador
        x = x + 1
    }

    // Inicialización de variables para la segunda lista
    println("Ingreso de la segunda lista de valores")
    x = 1  // Reinicia el contador
    var suma2 = 0

    // Ingreso de valores para la segunda lista
    while (x <= 5) {
        // Se solicita el ingreso de un valor para la lista 2
        print("Ingrese valor:")
        val valor = readln().toInt()

        // Se suma el valor ingresado a la suma total de la lista 2
        suma2 = suma2 + valor

        // Incremento del contador
        x = x + 1
    }

    // Comparación de las sumas de las dos listas y muestra del resultado
    if (suma1 > suma2) {
        print("Lista 1 mayor.")
    } else if (suma2 > suma1) {
        print("Lista 2 mayor.")
    } else {
        print("Listas iguales.")
    }
}
