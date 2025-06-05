package Condicionales

/**
 * Función principal que simula la lógica de un semáforo utilizando una expresión `when`.
 * Demuestra la capacidad de agrupar múltiples valores en una sola rama del `when`.
 */
fun main() {
    // Declara una variable inmutable 'trafficLightColor' y la inicializa con el color "Amber".
    val trafficLightColor = "Amber"

    // Utiliza una expresión 'when' para evaluar el valor de 'trafficLightColor'.
    when (trafficLightColor) {
        // Si 'trafficLightColor' es "Red", imprime "Stop".
        "Red" -> println("Stop")
        // Si 'trafficLightColor' es "Yellow" O "Amber", imprime "Slow".
        // Esta rama demuestra cómo agrupar múltiples condiciones con una coma.
        "Yellow", "Amber" -> println("Slow")
        // Si 'trafficLightColor' es "Green", imprime "Go".
        "Green" -> println("Go")
        // Si 'trafficLightColor' no coincide con ninguna de las ramas anteriores,
        // se ejecuta este bloque 'else', imprimiendo un mensaje de error.
        else -> println("Invalid traffic-light color")
    }
}