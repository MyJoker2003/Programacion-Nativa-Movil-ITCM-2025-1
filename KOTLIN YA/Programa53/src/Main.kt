// PROBLEMA PROPUESTO 53
/* Desarrollar un programa que solicite la carga de 10 números
   e imprima la suma de los últimos 5 valores ingresados.
*/

fun main(parametro: Array<String>) {
    var suma = 0 // Variable que acumulará la suma de los últimos 5 valores

    // Bucle que se ejecuta 10 veces para ingresar los 10 valores
    for(i in 1..10) {
        print("Ingrese un valor entero:") // Solicita al usuario un número
        val valor = readln().toInt() // Lee y convierte el valor a entero

        if (i > 5) // Si el índice es mayor a 5, significa que es uno de los últimos 5 valores
            suma += valor // Se suma el valor a la variable suma
    }

    // Muestra la suma total de los últimos 5 valores
    print("La suma de los últimos 5 valores es: $suma")
}
