package Conceptos_Basicos

fun main() {
    // Llama a 'printFinalTemperature' para convertir 27 grados Celsius a Fahrenheit.
    // La fórmula de conversión se proporciona como una función lambda: (9/5) * temperatura + 32.
    printFinalTemperature(27.0, "Celsius", "Fahrenheit") { 9.0 / 5.0 * it + 32 }

    // Llama a 'printFinalTemperature' para convertir 350 grados Kelvin a Celsius.
    // La fórmula de conversión se proporciona como una función lambda: temperatura - 273.15.
    printFinalTemperature(350.0, "Kelvin", "Celsius") { it - 273.15 }

    // Llama a 'printFinalTemperature' para convertir 10 grados Fahrenheit a Kelvin.
    // La fórmula de conversión se proporciona como una función lambda: (5/9) * (temperatura - 32) + 273.15.
    printFinalTemperature(10.0, "Fahrenheit", "Kelvin") { 5.0 / 9.0 * (it - 32) + 273.15 }
}

// Define la función 'printFinalTemperature' que se encarga de realizar y mostrar una conversión de temperatura.
// initialMeasurement: Es el valor numérico de la temperatura inicial.
// initialUnit: Es una cadena de texto que describe la unidad de la temperatura inicial (ej., "Celsius").
// finalUnit: Es una cadena de texto que describe la unidad a la que se desea convertir (ej., "Fahrenheit").
// conversionFormula: Es una función lambda que toma un Double (la temperatura inicial) y retorna un Double (la temperatura convertida).
fun printFinalTemperature(
    initialMeasurement: Double,                   // Temperatura inicial (número decimal)
    initialUnit: String,                          // Unidad de la temperatura inicial (ej. Celsius)
    finalUnit: String,                            // Unidad a la que se quiere convertir (ej. Fahrenheit)
    conversionFormula: (Double) -> Double        // Función que recibe la temperatura inicial y devuelve la convertida
) {
    // Aplica la fórmula de conversión a la temperatura inicial.
    // El resultado se formatea a dos decimales usando String.format("%.2f").
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement))

    // Imprime el resultado de la conversión en un formato legible.
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}