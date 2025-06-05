// PROBLEMA PROPUESTO P26
/* Se ingresan tres valores por teclado, si todos son iguales
   calcular el cubo del número y mostrarlo. */

fun main(parametro: Array<String>) {
    // Se solicita el primer valor y se convierte a entero
    print("Ingrese primer valor:")
    val valor1 = readln().toInt()

    // Se solicita el segundo valor y se convierte a entero
    print("Ingrese segundo valor:")
    val valor2 = readln().toInt()

    // Se solicita el tercer valor y se convierte a entero
    print("Ingrese tercer valor:")
    val valor3 = readln().toInt()

    // Se verifica si los tres valores son iguales
    if (valor1 == valor2 && valor1 == valor3) {
        // Se calcula el cubo del valor ingresado
        val cubo = valor1 * valor1 * valor3
        // Se muestra el resultado
        print("El cubo de $valor1 es $cubo")
    }
}
