// Función que muestra un mensaje decorado entre líneas de asteriscos
fun mostrarMensaje(mensaje: String) {
    println("*************************************************")
    println(mensaje)
    println("*************************************************")
}

// Función que solicita dos valores, los suma y muestra el resultado
fun cargarSumarPrograma70() {
    print("Ingrese el primer valor:") // Solicita el primer número
    val valor1 = readLine()!!.toInt() // Convierte el valor leído a entero

    print("Ingrese el segundo valor:") // Solicita el segundo número
    val valor2 = readLine()!!.toInt() // Convierte el valor leído a entero

    val suma = valor1 + valor2 // Calcula la suma
    println("La suma de los dos valores es: $suma") // Muestra el resultado
}

// Función principal del programa
fun main(parametro: Array<String>) {
    mostrarMensaje("El programa calcula la suma de dos valores ingresados por teclado.") // Mensaje inicial
    cargarSumarPrograma70() // Llama a la función para ingresar valores y sumarlos
    mostrarMensaje("Gracias por utilizar este programa") // Mensaje de despedida
}
