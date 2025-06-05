package Condicionales

/**
 * Función principal que ejecuta el programa.
 * Demuestra el uso avanzado de la expresión `when` para evaluar tipos y rangos de valores.
 */
fun main() {
    // Declara una variable inmutable 'x' de tipo Any e inicialízala con un valor entero.
    // 'Any' es el supertipo de todos los tipos no nulos en Kotlin.
    val x: Any = 20

    // Utiliza una expresión 'when' para evaluar el valor de 'x'.
    when (x) {
        // Primera rama: Si 'x' es igual a 2, 3, 5 o 7, imprime que es un número primo entre 1 y 10.
        2, 3, 5, 7 -> println("x is a prime number between 1 and 10.")
        // Segunda rama: Si 'x' está en el rango inclusivo de 1 a 10 (ambos incluidos),
        // imprime que es un número entre 1 y 10, pero no un primo (ya cubierto por la rama anterior).
        in 1..10 -> println("x is a number between 1 and 10, but not a prime number.")
        // Tercera rama: Si 'x' es una instancia de tipo Int (un número entero),
        // imprime que es un entero pero no está entre 1 y 10 (las ramas anteriores ya lo habrían capturado).
        is Int -> println("x is an integer number, but not between 1 and 10.")
        // Rama 'else': Si 'x' no coincide con ninguna de las condiciones anteriores,
        // imprime que no es un número entero.
        else -> println("x isn't an integer number.")
    }
}