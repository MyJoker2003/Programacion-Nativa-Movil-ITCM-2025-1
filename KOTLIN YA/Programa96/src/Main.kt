// Definimos la función multiplos2y5 que no recibe parámetros y analiza 10 números ingresados por el usuario
fun multiplos2y5() {

    // Función interna que verifica si un número es múltiplo de otro
    fun multiplo(numero: Int, valor: Int) = numero % valor == 0

    // Contadores para la cantidad de múltiplos de 2 y de 5
    var mult2 = 0
    var mult5 = 0

    // Bucle que se repite 10 veces para pedir al usuario ingresar 10 valores
    for(i in 1..10) {
        print("Ingrese valor: ")
        val valor = readLine()!!.toInt() // Se lee el valor y se convierte a entero

        // Si el valor es múltiplo de 2, se incrementa el contador mult2
        if (multiplo(valor, 2))
            mult2++

        // Si el valor es múltiplo de 5, se incrementa el contador mult5
        if (multiplo(valor, 5))
            mult5++
    }

    // Se imprimen los resultados
    println("Cantidad de múltiplos de 2 : $mult2")
    println("Cantidad de múltiplos de 5 : $mult5")
}

// Función principal que llama a multiplos2y5
fun main(parametro: Array<String>) {
    multiplos2y5()
}
