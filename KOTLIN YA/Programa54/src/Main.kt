// PROBLEMA PROPUESTO 54
/* Desarrollar un programa que muestre la tabla de multiplicar del 5 (del 5 al 50) */

fun main(parametro: Array<String>) {
    // Bucle que recorre los múltiplos de 5 desde 5 hasta 50 (inclusive), de 5 en 5
    for(tabla5 in 5..50 step 5)
        println(tabla5) // Muestra cada múltiplo en pantalla
}
