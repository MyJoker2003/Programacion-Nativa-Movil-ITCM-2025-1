// PROBLEMA PROPUESTO P30
/* Escribir un programa en el cual: dada una lista de tres valores enteros ingresados por teclado
   se guarde en otras dos variables el menor y el mayor de esa lista.
   Utilizar el if como expresión para obtener el mayor y el menor.
   Imprimir luego las dos variables. */

fun main(parametro: Array<String>) {
    // Solicita el primer valor al usuario
    print("Ingrese primer valor:")
    val valor1 = readln().toInt()

    // Solicita el segundo valor al usuario
    print("Ingrese segundo valor:")
    val valor2 = readln().toInt()

    // Solicita el tercer valor al usuario
    print("Ingrese tercer valor:")
    val valor3 = readln().toInt()

    // Determina el menor valor utilizando if como expresión
    val menor = if (valor1 < valor2 && valor1 < valor3) valor1 else if (valor2 < valor3) valor2 else valor3

    // Determina el mayor valor utilizando if como expresión
    val mayor = if (valor1 > valor2 && valor1 > valor3) valor1 else if (valor2 > valor3) valor2 else valor3

    // Muestra el mayor y menor valor encontrados
    print("El mayor de la lista es $mayor y el menor $menor")
}
