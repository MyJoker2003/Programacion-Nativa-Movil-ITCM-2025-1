// Función que pide dos valores al usuario, los suma y muestra el resultado
fun cargarSuma() {
    print("Ingrese el primer valor:") // Solicita el primer número
    val valor1 = readLine()!!.toInt() // Lee el primer valor y lo convierte a entero

    print("Ingrese el segundo valor:") // Solicita el segundo número
    val valor2 = readLine()!!.toInt() // Lee el segundo valor y lo convierte a entero

    val suma = valor1 + valor2 // Calcula la suma de los dos valores
    println("La suma de los dos valores es: $suma") // Muestra la suma por pantalla
}

// Función que imprime una línea de separación
fun separacion() {
    println("*******************************") // Línea visual para separar cada suma
}

// Función principal del programa
fun main(parametro: Array<String>) {
    // Bucle que repite el proceso 5 veces
    for (i in 1..5) {
        cargarSuma()   // Llama a la función que suma dos valores
        separacion()   // Llama a la función que imprime la separación
    }
}
