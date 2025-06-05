// Función que solicita la carga de tres valores y muestra el menor de ellos
fun menorValor() {
    print("Ingrese primer valor:") // Solicita el primer número
    val valor1 = readln().toInt() // Convierte el valor leído a entero

    print("Ingrese segundo valor:") // Solicita el segundo número
    val valor2 = readln().toInt() // Convierte el valor leído a entero

    print("Ingrese tercer valor:") // Solicita el tercer número
    val valor3 = readln().toInt() // Convierte el valor leído a entero

    print("Menor de los tres: ") // Muestra el texto antes del resultado

    // Determina cuál de los tres valores es el menor usando la estructura when
    when {
        valor1 < valor2 && valor1 < valor3 -> println(valor1) // Si valor1 es menor que los otros dos
        valor2 < valor3 -> println(valor2) // Si valor2 es menor que valor3 (y no fue menor que valor1)
        else -> println(valor3) // En cualquier otro caso, el menor es valor3
    }
}

// Función principal que llama dos veces a menorValor sin usar estructuras repetitivas
fun main(parametro: Array<String>) {
    menorValor() // Primera llamada a la función
    menorValor() // Segunda llamada a la función
}
