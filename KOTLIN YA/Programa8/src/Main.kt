// PROBLEMA PROPUESTO P8
/* Escribir un programa en el cual se ingresen cuatro números enteros, calcular e
   informar la suma de los dos primeros y el producto del tercero y el cuarto. */

fun main(parametro: Array<String>) {
    // Solicita al usuario el primer número entero
    print("Ingrese primer valor:")
    val v1 = readln().toInt() // Lee y convierte el valor ingresado a entero

    // Solicita el segundo número entero
    print("Ingrese segundo valor:")
    val v2 = readln().toInt() // Lee y convierte el segundo valor a entero

    // Solicita el tercer número entero
    print("Ingrese tercer valor:")
    val v3 = readln().toInt() // Lee y convierte el tercer valor a entero

    // Solicita el cuarto número entero
    print("Ingrese cuarto valor:")
    val v4 = readln().toInt() // Lee y convierte el cuarto valor a entero

    // Calcula la suma de los dos primeros valores
    val suma = v1 + v2

    // Muestra el resultado de la suma
    println("La suma de $v1 y $v2 es $suma")

    // Calcula el producto del tercer y cuarto valor
    val producto = v3 * v4

    // Muestra el resultado del producto
    println("El producto de $v3 y $v4 es $producto")
}