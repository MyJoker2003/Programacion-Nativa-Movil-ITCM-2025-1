package Condicionales

/**
 * Función principal que simula la lógica de un semáforo.
 * Demuestra cómo usar una expresión `when` para asignar un valor a una variable,
 * similar a cómo se usa un `if-else` como expresión.
 */
fun main() {
    // Declara una variable inmutable 'trafficLightColor' y la inicializa con el color "Amber".
    val trafficLightColor = "Amber"

    // Utiliza una expresión 'when' para evaluar el valor de 'trafficLightColor'
    // y asignar el resultado directamente a la variable 'message'.
    val message = when(trafficLightColor) {
        // Si el color es "Red", el mensaje asignado es "Stop".
        "Red" -> "Stop"
        // Si el color es "Yellow" o "Amber", el mensaje asignado es "Slow".
        // Esta es una forma concisa de manejar múltiples valores para la misma acción.
        "Yellow", "Amber" -> "Slow"
        // Si el color es "Green", el mensaje asignado es "Go".
        "Green" -> "Go"
        // Si el color no coincide con ninguna de las opciones anteriores,
        // el mensaje asignado es "Invalid traffic-light color".
        else -> "Invalid traffic-light color"
    }

    // Imprime el mensaje resultante, que contendrá el valor asignado por la expresión 'when'.
    println(message)
}