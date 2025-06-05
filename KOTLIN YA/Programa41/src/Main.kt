fun main(parametro: Array<String>) {
    // Inicialización de las variables que contarán los números pares e impares
    var pares = 0
    var impares = 0

    // Se solicita el número de valores que se ingresarán
    print("Cuantos números ingresará:")
    val n = readln().toInt()

    // Inicialización de un contador para el ciclo while
    var x = 1

    // Bucle while para ingresar n valores
    while (x <= n) {
        // Solicitar el valor al usuario
        print("Ingrese el valor:")
        val valor = readln().toInt()

        // Comprobar si el número es par (el resto de la división entre 2 es 0)
        if (valor % 2 == 0) {
            // Si el número es par, aumentar el contador de pares
            pares = pares + 1
        } else {
            // Si el número es impar, aumentar el contador de impares
            impares = impares + 1
        }

        // Incrementar el contador del ciclo
        x = x + 1
    }

    // Mostrar la cantidad de números pares e impares
    println("Cantidad de pares: $pares")
    println("Cantidad de impares: $impares")
}
