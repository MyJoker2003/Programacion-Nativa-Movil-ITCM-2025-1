// Función que solicita un número entero y muestra su cuadrado
fun calculaCuadrado() {
    print("Ingrese un entero:") // Solicita al usuario que ingrese un número
    val valor = readln().toInt() // Lee el número ingresado y lo convierte a entero
    val cuadrado = valor * valor // Calcula el cuadrado del número
    println("El cuadrado es $cuadrado") // Muestra el resultado
}

// Función que solicita dos números enteros y muestra su producto
fun calcularProducto() {
    print("Ingrese primer valor:") // Solicita el primer valor
    val valor1 = readln().toInt() // Lee y convierte a entero el primer valor

    print("Ingrese segundo valor:") // Solicita el segundo valor
    val valor2 = readln().toInt() // Lee y convierte a entero el segundo valor

    val producto = valor1 * valor2 // Calcula el producto de los dos valores
    println("El producto de los valores es: $producto") // Muestra el resultado
}

// Función principal que llama a las dos funciones anteriores
fun main(parametro: Array<String>) {
    calculaCuadrado()     // Llama a la función para calcular el cuadrado
    calcularProducto()    // Llama a la función para calcular el producto
}
