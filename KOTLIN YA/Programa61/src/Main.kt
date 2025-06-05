fun main(parametro: Array<String>) {
    var cant1 = 0 // Contador de piezas con peso superior a 10.2
    var cant2 = 0 // Contador de piezas con peso entre 9.8 y 10.2
    var cant3 = 0 // Contador de piezas con peso inferior a 9.8

    do {
        print("Ingrese el peso de la pieza (0 para finalizar): ")
        val peso = readLine()!!.toDouble()

        // Validación para evitar piezas con peso negativo
        if (peso < 0) {
            println("El peso no puede ser negativo. Intente nuevamente.")
            continue
        }

        // Procesamiento de las piezas según el peso
        when {
            peso > 10.2 -> cant1++   // Piezas con peso superior a 10.2
            peso >= 9.8 -> cant2++    // Piezas con peso entre 9.8 y 10.2
            peso > 0 -> cant3++       // Piezas con peso inferior a 9.8
        }
    } while (peso != 0.0)

    // Resultados finales
    println("Piezas aptas (peso entre 9.8 y 10.2): $cant2")
    println("Piezas con un peso superior a 10.2: $cant1")
    println("Piezas con un peso inferior a 9.8: $cant3")

    // Total de piezas procesadas
    val suma = cant1 + cant2 + cant3
    println("Cantidad total de piezas procesadas: $suma")
}
