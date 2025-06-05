package Nulabilidad

/**
 * Función principal que demuestra el manejo básico de variables nulables en Kotlin.
 */
fun main() {
    // Declara una variable mutable 'favoriteActor' de tipo String? (String nulable).
    // Se inicializa con el valor "Sandra Oh". El '?' indica que la variable puede contener null.
    var favoriteActor: String? = "Sandra Oh"
    // Imprime el valor actual de 'favoriteActor'.
    println(favoriteActor)

    // Reasigna 'favoriteActor' a null. Esto es posible porque la variable fue declarada como nulable.
    favoriteActor = null
    // Imprime el nuevo valor de 'favoriteActor', que ahora es null.
    println(favoriteActor)
}