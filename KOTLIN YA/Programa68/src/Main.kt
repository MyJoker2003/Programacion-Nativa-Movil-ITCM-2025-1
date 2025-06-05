fun main(parametro: Array<String>) {
    // Inicialización de variables para contar los números 0 y los números 1, 5, 10
    var cant1 = 0
    var cant2 = 0

    // Bucle que se ejecuta 10 veces para ingresar 10 valores
    for (i in 1..10) {
        // Solicita al usuario ingresar un valor entero
        print("Ingrese un valor entero:")
        val valor = readLine()!!.toInt()

        // Evaluación del valor ingresado usando 'when'
        when (valor) {
            0 -> cant1++  // Si el valor es 0, aumenta la cantidad de 'cant1'
            1, 5, 10 -> cant2++  // Si el valor es 1, 5 o 10, aumenta la cantidad de 'cant2'
        }
    }

    // Muestra en pantalla la cantidad de números 0 ingresados
    println("Cantidad de números 0 ingresados: $cant1")

    // Muestra en pantalla la cantidad de números 1, 5 o 10 ingresados
    println("Cantidad de números 1, 5 o 10 ingresados: $cant2")
}
