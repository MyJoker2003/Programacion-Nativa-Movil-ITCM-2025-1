package Conceptos_Basicos


fun main() { // Define la función principal 'main', que es el punto de entrada del programa.
    val child = 5 // Declara una variable inmutable 'child' y le asigna el valor 5 (edad de un niño).
    val adult = 28 // Declara una variable inmutable 'adult' y le asigna el valor 28 (edad de un adulto).
    val senior = 87 // Declara una variable inmutable 'senior' y le asigna el valor 87 (edad de una persona mayor).

    val isMonday = true // Declara una variable inmutable booleana 'isMonday' y la inicializa a 'true', indicando que el día actual es lunes.

    // Imprime en la consola el precio del boleto para una persona con la edad de 'child'.
    // Llama a la función 'ticketPrice' pasando la edad y si es lunes para obtener el precio.
    println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday)}.")
    // Imprime en la consola el precio del boleto para una persona con la edad de 'adult'.
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
    // Imprime en la consola el precio del boleto para una persona con la edad de 'senior'.
    println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}.")
}

// Define la función 'ticketPrice' que calcula el precio del boleto de cine.
// Toma dos parámetros: 'age' (la edad como entero) y 'isMonday' (un booleano que indica si es lunes).
// Retorna un valor entero, que es el precio calculado.
fun ticketPrice(age: Int, isMonday: Boolean): Int {
    // Utiliza una expresión 'when' para determinar el precio basándose en la edad.
    return when(age) {
        in 0..12 -> 15 // Si la edad está entre 0 y 12 (inclusive), el precio es 15.
        in 13..60 -> if (isMonday) 25 else 30 // Si la edad está entre 13 y 60 (inclusive):
        // Si 'isMonday' es verdadero, el precio es 25.
        // De lo contrario (si no es lunes), el precio es 30.
        in 61..100 -> 20 // Si la edad está entre 61 y 100 (inclusive), el precio es 20.
        else -> -1 // Si la edad no está en ninguno de los rangos anteriores (edad inválida o fuera de rango), retorna -1.
    }
}