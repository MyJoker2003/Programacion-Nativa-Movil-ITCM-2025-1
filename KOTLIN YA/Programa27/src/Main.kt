// PROBLEMA PROPUESTO P27
/* Se ingresan por teclado tres números, si todos los valores ingresados son menores a 10,
   imprimir en pantalla la leyenda "Todos los números son menores a diez". */

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

    // Verifica si los tres números son menores a 10
    if (valor1 < 10 && valor2 < 10 && valor3 < 10)
    // Si la condición se cumple, imprime el mensaje correspondiente
        print("Todos los números son menores a diez");
}
