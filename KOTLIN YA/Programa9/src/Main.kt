// PROBLEMA PROPUESTO P9
/* Realizar un programa que lea por teclado cuatro valores numéricos
   enteros e informar su suma y promedio. */

fun main(parametro: Array<String>) {
    // Solicita el primer número al usuario
    print("Ingrese primer valor:")
    val v1 = readln().toInt() // Convierte la entrada a entero

    // Solicita el segundo número
    print("Ingrese segundo valor:")
    val v2 = readln().toInt()

    // Solicita el tercer número
    print("Ingrese tercer valor:")
    val v3 = readln().toInt()

    // Solicita el cuarto número
    print("Ingrese cuarto valor:")
    val v4 = readln().toInt()

    // Calcula la suma de los cuatro valores
    val suma = v1 + v2 + v3 + v4

    // Muestra la suma por consola
    println("La suma de los cuatro valores es $suma")

    // Calcula el promedio dividiendo la suma entre 4
    val prom = suma / 4

    // Muestra el promedio por consola
    println("El promedio de los cuatro valores es $prom")
}
