package Condicionales

/**
 * Función principal que simula la lógica de un semáforo.
 * Demuestra cómo usar una expresión `if-else` para asignar un valor a una variable.
 */
fun main() {
    // Declara una variable inmutable 'trafficLightColor' e inicialízala con un color.
    val trafficLightColor = "Black"

    // Utiliza una expresión if-else if-else para asignar un mensaje a la variable 'message'
    // basándose en el valor de 'trafficLightColor'. En Kotlin, 'if' es una expresión,
    // lo que significa que puede retornar un valor.
    val message =
        if (trafficLightColor == "Red") "Stop" // Si el color es "Red", el mensaje es "Stop".
        else if (trafficLightColor == "Yellow") "Slow" // Si es "Yellow", el mensaje es "Slow".
        else if (trafficLightColor == "Green") "Go" // Si es "Green", el mensaje es "Go".
        else "Invalid traffic-light color" // Para cualquier otro color, el mensaje es de error.

    // Imprime el mensaje resultante.
    println(message)
}