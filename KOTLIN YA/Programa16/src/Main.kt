fun main(parametro: Array<String>) {
    // Solicita al usuario que ingrese un número entero
    print("Ingrese un valor entero:")
    val valor = readLine()!!.toInt() // Lee la entrada y la convierte a entero

    // Usa una expresión if para calcular el cuadrado si es par, o el cubo si es impar
    val resultado = if (valor % 2 == 0) {
        print("Cuadrado:")         // Muestra "Cuadrado:" si el número es par
        valor * valor              // Devuelve el cuadrado del número
    } else {
        print("Cubo:")             // Muestra "Cubo:" si el número es impar
        valor * valor * valor      // Devuelve el cubo del número
    }

    // Muestra el resultado final (cuadrado o cubo)
    print(resultado)
}
