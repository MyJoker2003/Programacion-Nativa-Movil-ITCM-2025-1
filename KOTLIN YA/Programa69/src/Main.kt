fun main(parametro: Array<String>) {
    // Inicialización de contadores para las familias con 0, 1, 2 o más hijos
    var conta1 = 0
    var conta2 = 0
    var conta3 = 0
    var conta4 = 0

    // Bucle que solicita la cantidad de hijos por cada familia en 10 iteraciones
    for(i in 1..10) {
        print("Ingrese la cantidad de hijos de la familia:")
        val cantidad = readln().toInt()  // Lee el valor de la cantidad de hijos

        // Evaluación de la cantidad de hijos con 'when' y actualización de contadores
        when (cantidad) {
            0 -> conta1++  // Si tiene 0 hijos, incrementa el contador de 'conta1'
            1 -> conta2++  // Si tiene 1 hijo, incrementa el contador de 'conta2'
            2 -> conta3++  // Si tiene 2 hijos, incrementa el contador de 'conta3'
            else -> conta4++  // Si tiene más de 2 hijos, incrementa el contador de 'conta4'
        }
    }

    // Imprime los resultados
    println("Cantidad de familias con 0 hijos: $conta1")
    println("Cantidad de familias con 1 hijo: $conta2")
    println("Cantidad de familias con 2 hijos: $conta3")
    println("Cantidad de familias con más de 2 hijos: $conta4")
}
