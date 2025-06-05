// Función principal del programa, recibe argumentos desde la línea de comandos
fun main(argumento: Array<String>) {

    // Se definen tres variables inmutables (val) con valores Float que representan los pesos de tres personas
    val peso1 = 89.4f       // Peso de la primera persona
    val peso2 = 67f         // Peso de la segunda persona
    val peso3 = 87.45f      // Peso de la tercera persona

    // Se calcula el promedio sumando los tres pesos y dividiéndolos entre 3
    val promedio = (peso1 + peso2 + peso3) / 3

    // Se muestra el promedio en consola
    println("El promedio de los tres pesos de personas es $promedio")
}
