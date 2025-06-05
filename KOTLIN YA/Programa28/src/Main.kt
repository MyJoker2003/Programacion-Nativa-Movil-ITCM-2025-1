// PROBLEMA PROPUESTO P28
/* Se ingresan por teclado tres números, si al menos uno de los valores ingresados es menor a 10,
   imprimir en pantalla la leyenda "Alguno de los números es menor a diez". */

fun main(parametro: Array<String>) {
    // Solicita al usuario el primer número y lo convierte a entero
    print("Ingrese primer valor:")
    val valor1 = readln().toInt()

    // Solicita al usuario el segundo número y lo convierte a entero
    print("Ingrese segundo valor:")
    val valor2 = readln().toInt()

    // Solicita al usuario el tercer número y lo convierte a entero
    print("Ingrese tercer valor:")
    val valor3 = readln().toInt()

    // Verifica si al menos uno de los tres números es menor a 10
    if (valor1 < 10 || valor2 < 10 || valor3 < 10)
    // Si la condición se cumple, imprime el mensaje correspondiente
        print("Alguno de los números es menor a diez")
}
