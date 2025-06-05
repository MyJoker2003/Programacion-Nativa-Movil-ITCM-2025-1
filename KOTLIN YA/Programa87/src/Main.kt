// Función que convierte un número entero a su equivalente en español
fun convertirCastelano(valor: Int) = when (valor) {
    1 -> "uno"      // Si el valor es 1, devuelve "uno"
    2 -> "dos"      // Si el valor es 2, devuelve "dos"
    3 -> "tres"     // Si el valor es 3, devuelve "tres"
    4 -> "cuatro"   // Si el valor es 4, devuelve "cuatro"
    5 -> "cinco"    // Si el valor es 5, devuelve "cinco"
    else -> "error" // Para cualquier otro valor, devuelve "error"
}

fun main(parametro: Array<String>) {
    // Ciclo for que recorre los números del 1 al 6
    for (i in 1..6)
    // Llama a la función convertirCastelano para cada número i y muestra el resultado
        println(convertirCastelano(i))
}
