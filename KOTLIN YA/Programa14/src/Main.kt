// PROBLEMA PROPUESTO P14
/*
   El objetivo es ingresar un número entre 1 y 99
   y determinar si tiene uno o dos dígitos.
*/

fun main(parametro: Array<String>) {
    // Solicita al usuario que ingrese un número del 1 al 99
    print("Ingrese un valor comprendido entre 1 y 99:")

    // Convierte la entrada del usuario a un número entero
    val num = readln().toInt()

    // Verifica si el número es menor a 10
    if (num < 10)
        println("Tiene un dígito") // Si es menor a 10, tiene un solo dígito
    else
        println("Tiene dos dígitos") // Si es 10 o más, tiene dos dígitos
}
