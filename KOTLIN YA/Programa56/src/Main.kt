// PROBLEMA PROPUESTO 56
/* Realizar un programa que lea los lados de n triángulos, e informar:
a) De cada uno de ellos, qué tipo de triángulo es: equilátero (tres lados iguales), isósceles (dos lados iguales), o escaleno (ningún lado igual)
b) Cantidad de triángulos de cada tipo. */

fun main(argumento: Array<String>) {
    // Contadores para cada tipo de triángulo
    var cant1 = 0 // Cantidad de equiláteros
    var cant2 = 0 // Cantidad de isósceles
    var cant3 = 0 // Cantidad de escalenos

    // Solicita al usuario cuántos triángulos quiere ingresar
    print("Ingrese la cantidad de triángulos:")
    val n = readln().toInt() // Lee la cantidad de triángulos

    // Bucle para procesar cada triángulo
    for(i in 1..n) {
        // Solicita los tres lados del triángulo
        print("Ingrese lado 1:")
        val lado1 = readln().toInt()
        print("Ingrese lado 2:")
        val lado2 = readln().toInt()
        print("Ingrese lado 3:")
        val lado3 = readln().toInt()

        // Determina el tipo de triángulo
        if (lado1 == lado2 && lado1 == lado3) {
            println("Es un triángulo equilatero.")
            cant1++ // Aumenta el contador de equiláteros
        } else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
            println("Es un triángulo isósceles.")
            cant2++ // Aumenta el contador de isósceles
        } else {
            println("Es un triángulo escaleno.")
            cant3++ // Aumenta el contador de escalenos
        }
    }

    // Imprime los resultados finales
    println("Cantidad de triángulos equilateros: $cant1")
    println("Cantidad de triángulos isósceles: $cant2")
    println("Cantidad de triángulos escalenos: $cant3")
}
