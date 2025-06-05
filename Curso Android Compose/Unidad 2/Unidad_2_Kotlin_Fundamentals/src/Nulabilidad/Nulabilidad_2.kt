package Nulabilidad

/**
 * Función principal que demuestra el manejo de variables nulables con tipos numéricos en Kotlin.
 */
fun main() {
    // Declara una variable mutable 'number' de tipo Int? (entero nulable).
    // Se inicializa con el valor 10. El '?' después de 'Int' indica que esta variable
    // puede almacenar un valor entero o `null`.
    var number: Int? = 10
    // Imprime el valor actual de 'number', que es 10.
    println(number)

    // Reasigna 'number' a `null`. Esto es permitido porque la variable fue declarada como nulable.
    number = null
    // Imprime el nuevo valor de 'number', que ahora es `null`.
    println(number)
}