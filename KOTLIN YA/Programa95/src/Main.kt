// PROBLEMA PROPUESTO 95
/* Elaborar una función que muestre la tabla de multiplicar del valor que le enviemos como parámetro.
   Definir un segundo parámetro llamado 'terminos' que por defecto almacene el valor 10.
   Se deben mostrar tantos términos de la tabla de multiplicar como lo indica el segundo parámetro.
   Llamar a la función desde la main con argumentos nombrados.
*/

// Definición de la función 'tabla' que recibe dos parámetros: el número base y la cantidad de términos a mostrar.
// El parámetro 'terminos' tiene un valor por defecto de 10.
fun tabla(numero: Int, terminos: Int = 10) {
    // Se utiliza un bucle 'for' con el rango desde 'numero' hasta 'numero * terminos', incrementando de 'numero' en 'numero'.
    // Esto genera los múltiplos del número base.
    for(i in numero..numero*terminos step numero)
        println(i) // Se imprime cada término de la tabla de multiplicar
}

fun main(parametro: Array<String>) {
    // Se muestra la tabla del 3 con los 10 primeros términos (por defecto).
    println("Tabla del 3")
    tabla(3)

    // Se muestra la tabla del 3 pero con solo 5 términos.
    println("Tabla del 3 con 5 terminos")
    tabla(3, 5)

    // Se muestra la tabla del 3 con 20 términos utilizando argumentos nombrados.
    println("Tabla del 3 con 20 terminos")
    tabla(terminos = 20, numero = 3)
}
