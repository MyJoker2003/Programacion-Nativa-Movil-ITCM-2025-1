fun main(parametro: Array<String>) {
    // Inicialización de las variables que contarán las piezas en cada categoría
    var cant1 = 0  // Piezas con un peso superior a 10.2
    var cant2 = 0  // Piezas aptas (peso entre 9.8 y 10.2)
    var cant3 = 0  // Piezas con un peso inferior a 9.8

    // Ciclo que sigue pidiendo datos mientras el peso ingresado sea distinto de 0
    do {
        // Pide al usuario que ingrese el peso de la pieza
        print("Ingrese el peso de la pieza (0 para finalizar):")
        val peso = readLine()!!.toDouble()  // Convierte el valor ingresado en un número decimal (Double)

        // Verifica el peso ingresado y lo clasifica en una de las tres categorías
        if (peso > 10.2)  // Si el peso es mayor a 10.2, aumenta el contador de la categoría 1
            cant1++
        else
            if (peso >= 9.8)  // Si el peso está entre 9.8 y 10.2, aumenta el contador de la categoría 2 (piezas aptas)
                cant2++
            else
                if (peso > 0)  // Si el peso es positivo y menor a 9.8, aumenta el contador de la categoría 3
                    cant3++

    } while(peso != 0.0)  // El ciclo termina cuando el usuario ingresa 0 como peso

    // Imprime los resultados para cada categoría de piezas
    println("Piezas aptas: $cant2")  // Piezas con peso entre 9.8 y 10.2
    println("Piezas con un peso superior a 10.2: $cant1")  // Piezas con peso superior a 10.2
    println("Piezas con un peso inferior a 9.8: $cant3")  // Piezas con peso inferior a 9.8

    // Calcula el total de piezas procesadas sumando las tres categorías
    val suma = cant1 + cant2 + cant3
    println("Cantidad total de piezas procesadas: $suma")  // Muestra el total de piezas procesadas
}
