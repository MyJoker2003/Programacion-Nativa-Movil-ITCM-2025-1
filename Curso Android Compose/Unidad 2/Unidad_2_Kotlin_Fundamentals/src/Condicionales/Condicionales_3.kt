package Condicionales

/**
 * Función principal que simula la lógica de un semáforo utilizando una expresión `when`.
 * Evalúa el color de la luz del semáforo e imprime la acción correspondiente.
 */
fun main() {
    // Declara una variable inmutable 'trafficLightColor' y la inicializa con el color "Yellow".
    val trafficLightColor = "Yellow"

    // Utiliza una expresión 'when' para evaluar el valor de 'trafficLightColor'.
    when (trafficLightColor) {
        // Si 'trafficLightColor' es "Red", imprime "Stop".
        "Red" -> println("Stop")
        // Si 'trafficLightColor' es "Yellow", imprime "Slow".
        "Yellow" -> println("Slow")
        // Si 'trafficLightColor' es "Green", imprime "Go".
        "Green" -> println("Go")
        // Si 'trafficLightColor' no coincide con ninguna de las ramas anteriores,
        // se ejecuta este bloque 'else', imprimiendo un mensaje de error.
        else -> println("Invalid traffic-light color")
    }
}