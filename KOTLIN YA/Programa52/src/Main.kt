// PROBLEMA PROPUESTO 52
/* Confeccionar un programa que lea n pares de datos, cada par de datos corresponde a la medida de la base y la altura de un triángulo.
   El programa deberá informar:
   a) De cada triángulo la medida de su base, su altura y su superficie (base * altura / 2).
   b) La cantidad de triángulos cuya superficie es mayor a 12.
*/

fun main(parametro: Array<String>) {
    var cantidad = 0 // Variable para contar cuántos triángulos tienen superficie mayor a 12

    print("Cuantos triángulos procesará:") // Se pide al usuario cuántos triángulos va a ingresar
    val n = readln().toInt() // Se lee el número total de triángulos

    // Bucle que se repite 'n' veces para procesar cada triángulo
    for(i in 1..n) {
        print("Ingrese el valor de la base:") // Se pide la base del triángulo
        val base = readln().toInt() // Se lee y guarda la base

        print("Ingrese el valor de la altura:") // Se pide la altura del triángulo
        val altura = readln().toInt() // Se lee y guarda la altura

        val superficie = base * altura / 2 // Se calcula la superficie del triángulo
        println("La superficie es de $superficie") // Se muestra la superficie

        if (superficie > 12) // Si la superficie es mayor a 12
            cantidad++ // Se incrementa el contador
    }

    // Al finalizar, se imprime cuántos triángulos tienen superficie mayor a 12
    print("La cantidad de triángulos con superficie superior a 12 son: $cantidad")
}
