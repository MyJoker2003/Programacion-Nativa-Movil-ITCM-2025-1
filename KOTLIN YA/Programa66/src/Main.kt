fun main(parametro: Array<String>) {
    // Se solicita al usuario ingresar un valor entero entre 1 y 5
    print("Ingrese un valor entero entre 1 y 5:")
    val valor = readLine()!!.toInt()  // Se lee el valor ingresado y se convierte a entero

    // Estructura 'when' que evalúa el valor ingresado
    when (valor) {
        1 -> print("uno")  // Si el valor es 1, se imprime "uno"
        2 -> print("dos")  // Si el valor es 2, se imprime "dos"
        3 -> print("tres") // Si el valor es 3, se imprime "tres"
        4 -> print("cuatro") // Si el valor es 4, se imprime "cuatro"
        5 -> print("cinco") // Si el valor es 5, se imprime "cinco"
        else -> print("valor fuera de rango") // Si el valor no es entre 1 y 5, se imprime el mensaje de error
    }
}
