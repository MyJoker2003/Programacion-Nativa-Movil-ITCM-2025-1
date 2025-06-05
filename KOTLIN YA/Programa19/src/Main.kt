// PROBLEMA PROPUESTO P19
/* Se cargan por teclado tres números distintos.
   Mostrar por pantalla el mayor de ellos. */

fun main(parametro: Array<String>) {
    // Solicita al usuario ingresar el primer valor
    print("Ingrese primer valor:")
    val valor1 = readln().toInt()

    // Solicita al usuario ingresar el segundo valor
    print("Ingrese segundo valor:")
    val valor2 = readln().toInt()

    // Solicita al usuario ingresar el tercer valor
    print("Ingrese tercer valor:")
    val valor3 = readln().toInt()

    // Comienza la comparación para determinar el mayor valor
    if (valor1 > valor2) {
        // Si valor1 es mayor que valor2, se compara con valor3
        if (valor1 > valor3)
            print(valor1) // valor1 es el mayor
        else
            print(valor3) // valor3 es el mayor
    } else {
        // Si valor2 es mayor o igual que valor1, se compara con valor3
        if (valor2 > valor3)
            print(valor2) // valor2 es el mayor
        else
            print(valor3) // valor3 es el mayor
    }
}
