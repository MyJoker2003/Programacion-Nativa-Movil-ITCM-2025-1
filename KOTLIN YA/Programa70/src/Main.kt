// Función que muestra el mensaje de presentación
fun presentacion() {
    println("Programa que permite cargar dos valores por teclado.")
    println("Efectua la suma de los valores")
    println("Muestra el resultado de la suma")
    println("*******************************")
}

// Función que se encarga de solicitar dos valores, sumarlos y mostrar el resultado
fun cargarSumar() {
    print("Ingrese el primer valor:") // Pide el primer número al usuario
    val valor1 = readLine()!!.toInt() // Lee y convierte el primer valor a entero

    print("Ingrese el segundo valor:") // Pide el segundo número al usuario
    val valor2 = readLine()!!.toInt() // Lee y convierte el segundo valor a entero

    val suma = valor1 + valor2 // Realiza la suma de los dos valores
    println("La suma de los dos valores es: $suma") // Muestra el resultado
}

// Función que muestra el mensaje final de despedida
fun finalizacion() {
    println("*******************************")
    println("Gracias por utilizar este programa")
}

// Función principal que ejecuta el orden lógico del programa
fun main(parametro: Array<String>) {
    presentacion()  // Llama a la función de presentación
    cargarSumar()   // Llama a la función para sumar los valores
    finalizacion()  // Llama a la función de cierre del programa
}
