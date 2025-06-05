// PROBLEMA PROPUESTO 58
/* Se realiza la carga de 10 valores enteros por teclado. Se desea conocer:
   a) La cantidad de valores ingresados negativos.
   b) La cantidad de valores ingresados positivos.
   c) La cantidad de múltiplos de 15.
   d) El valor acumulado de los números ingresados que son pares. */

fun main(parametro: Array<String>) {
    var negativos = 0    // Contador de números negativos
    var positivos = 0    // Contador de números positivos
    var mult15 = 0       // Contador de múltiplos de 15
    var sumapares = 0    // Acumulador de números pares

    // Bucle que se repite 10 veces para ingresar valores
    for(i in 1..10) {
        print("Ingrese valor:")
        val valor = readln().toInt()  // Se lee un número entero

        // Si es negativo, aumenta el contador de negativos
        if (valor < 0)
            negativos++
        else if (valor > 0)  // Si es positivo, aumenta el contador de positivos
            positivos++

        // Si es múltiplo de 15
        if (valor % 15 == 0)
            mult15++

        // Si es par, se suma al acumulador
        if (valor % 2 == 0)
            sumapares += valor
    }

    // Muestra los resultados en pantalla
    println("Cantidad de valores negativos: $negativos")
    println("Cantidad de valores positivos: $positivos")
    println("Cantidad de valores múltiplos de 15: $mult15")
    println("Suma de los valores pares: $sumapares")
}
