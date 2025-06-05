// PROBLEMA PROPUESTO 55
/* Confeccionar un programa que permita ingresar un valor del 1 al 10 y nos muestre la tabla de multiplicar del mismo
   (los primeros 12 términos). Ejemplo: Si ingresó 3 deberá aparecer en pantalla los valores 3, 6, 9, hasta el 36. */

fun main(argumento: Array<String>) {
    // Solicita al usuario que ingrese un valor entre 1 y 10
    print("Ingrese un valor entre 1 y 10:")
    val valor = readln().toInt() // Convierte la entrada en entero y la guarda en la variable 'valor'

    // Bucle que imprime los múltiplos del número ingresado, desde el número mismo hasta el número multiplicado por 12
    for(i in valor..valor * 12 step valor)
        println(i) // Muestra cada múltiplo
}
