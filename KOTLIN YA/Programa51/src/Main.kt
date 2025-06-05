fun main(parametros: Array<String>) {
    var cant = 0 // Variable para contar la cantidad de números pares ingresados

    print("Cuantos valores ingresará para analizar:") // Se solicita al usuario cuántos valores va a ingresar
    val cantidad = readLine()!!.toInt() // Se lee la cantidad de valores y se convierte a entero

    // Bucle que se repite la cantidad de veces indicada por el usuario
    for(i in 1..cantidad) {
        print("Ingrese valor:") // Se pide al usuario que ingrese un valor
        val valor = readLine()!!.toInt() // Se lee el valor ingresado y se convierte a entero

        if (valor % 2 == 0) // Se verifica si el valor es par (módulo 2 igual a 0)
            cant++ // Si es par, se incrementa el contador de pares
    }

    // Se imprime la cantidad total de valores pares ingresados
    println("Cantidad de pares: $cant")
}
