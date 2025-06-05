package Condicionales

/**
 * Función principal que simula la lógica de un semáforo.
 * Evalúa el color de la luz del semáforo e imprime la acción correspondiente.
 */
fun main() {
    // Declara una variable inmutable 'trafficLightColor' e inicialízala con un color.
    val trafficLightColor = "Black"

    // Evalúa el valor de 'trafficLightColor' usando una cadena de condicionales if-else if-else.
    if (trafficLightColor == "Red") {
        // Si el color es "Red", imprime "Stop".
        println("Stop")
    } else if (trafficLightColor == "Yellow") {
        // Si el color es "Yellow", imprime "Slow".
        println("Slow")
    } else if (trafficLightColor == "Green") {
        // Si el color es "Green", imprime "Go".
        println("Go")
    } else {
        // Si el color no coincide con ninguno de los colores de semáforo válidos,
        // imprime un mensaje de error.
        println("Invalid traffic-light color")
    }
}