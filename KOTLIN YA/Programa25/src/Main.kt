// PROBLEMA PROPUESTO P25
/* Realizar un programa que pida cargar una fecha cualquiera,
   luego verificar si dicha fecha corresponde a Navidad. */

fun main(parametro: Array<String>) {
    // Solicita el día al usuario y lo convierte a entero
    print("Ingrese día:")
    val dia = readln().toInt()

    // Solicita el mes al usuario y lo convierte a entero
    print("Ingrese mes:")
    val mes = readln().toInt()

    // Solicita el año al usuario y lo convierte a entero
    print("Ingrese Año:")
    val año = readln().toInt()

    // Verifica si el día es 25 y el mes es 12 (diciembre)
    if (mes == 12 && dia == 25)
        print("La fecha ingresada corresponde a navidad.")
}
