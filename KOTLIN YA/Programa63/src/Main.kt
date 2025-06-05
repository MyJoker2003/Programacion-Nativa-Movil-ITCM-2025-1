fun main(parametro: Array<String>) {
    // Pedimos al usuario que ingrese un valor entero
    print("Ingrese un valor entero: ")
    val valor = readln().toInt()  // Convertimos la entrada en un número entero

    // Usamos 'when' para verificar en qué categoría cae el valor ingresado
    when {
        valor == 0 -> println("Se ingresó el cero")  // Si el valor es cero, mostramos este mensaje
        valor > 0 -> println("Se ingresó un valor positivo")  // Si el valor es mayor que cero, mostramos que es positivo
        valor < 0 -> println("Se ingresó un valor negativo")  // Si el valor es menor que cero, mostramos que es negativo
    }
}
