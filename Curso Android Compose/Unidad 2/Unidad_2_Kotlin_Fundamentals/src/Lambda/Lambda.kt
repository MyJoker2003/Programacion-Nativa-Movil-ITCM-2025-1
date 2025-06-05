package Lambda


/**
 * Determina si se realiza un "truco" o se entrega un "dulce" y devuelve
 * una función (lambda) que ejecuta la acción correspondiente.
 *
 * @param isTrick Un valor booleano que indica si la acción es un truco (`true`) o un dulce (`false`).
 * @param treatMessage Una función lambda nulable que toma un `Int` y devuelve un `String`.
 * Se usa para generar el mensaje del dulce. Si es `null`, no hay mensaje especial de dulce.
 * @return Una función lambda `() -> Unit` que representa la acción a realizar
 * (imprimir "No treats!" para un truco, o un mensaje de dulce seguido de "Have a treat!" para un dulce).
 */
fun trickOrTreat(isTrick: Boolean, treatMessage: ((Int) -> String)?): () -> Unit {
    // Si es un truco, devuelve una lambda que simplemente imprime "No treats!".
    return if (isTrick) {
        {
            println("No treats!")
        }
    } else {
        // Si no es un truco (es un dulce), devuelve una lambda que maneja la entrega del dulce.
        {
            // Solo imprime el mensaje especial del dulce la primera vez que se llama a la función.
            if (!hasPrintedMessage) {
                // Utiliza '?.let' para llamar a 'treatMessage' solo si no es nula.
                treatMessage?.let {
                    // Llama a la función 'treatMessage' con el valor 5 y imprime su resultado.
                    println(it(5))
                }
                // Marca la bandera para evitar que el mensaje especial se imprima de nuevo.
                hasPrintedMessage = true
            }
            // Imprime el mensaje general de "Have a treat!".
            println("Have a treat!")
        }
    }
}

/**
 * Una variable global mutable para controlar si el mensaje especial del dulce
 * ("5 quarters") ya ha sido impreso.
 * Se inicializa en `false` para asegurar que se imprima la primera vez.
 */
var hasPrintedMessage = false

/**
 * Función principal que ejecuta el programa y demuestra el uso de `trickOrTreat`.
 */
fun main() {
    // Define 'treatFunction' llamando a 'trickOrTreat' con 'isTrick' como `false`
    // y una lambda para el mensaje del dulce que formatea un número en "X quarters".
    val treatFunction = trickOrTreat(false) { "$it quarters" }

    // Define 'trickFunction' llamando a 'trickOrTreat' con 'isTrick' como `true`
    // y pasando `null` para el mensaje del dulce, ya que no aplica para un truco.
    val trickFunction = trickOrTreat(true, null)

    // Llama a 'treatFunction' una vez. Esto imprimirá "5 quarters" (por primera y única vez)
    // y "Have a treat!".
    treatFunction()

    // Llama a 'treatFunction' 4 veces adicionales.
    // En estas llamadas, solo se imprimirá "Have a treat!" ya que "5 quarters" ya se imprimió.
    repeat(4) {
        treatFunction()
    }

    // Llama a 'trickFunction' una vez. Esto imprimirá "No treats!".
    trickFunction()
}