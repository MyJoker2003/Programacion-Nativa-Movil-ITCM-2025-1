// Función que recibe entre 2 y 5 enteros y devuelve la suma de esos valores.
// Los tres últimos parámetros tienen valores por defecto de 0.
fun sumar(v1: Int, v2: Int, v3: Int = 0, v4: Int = 0, v5: Int = 0): Int {
    // Retorna la suma de los cinco parámetros, si se omiten los últimos tres, se asumen como 0.
    return v1 + v2 + v3 + v4 + v5
}

fun main(parametro: Array<String>) {
    // Ejemplo de suma con 2 valores. Los últimos tres parámetros se toman como 0 por defecto.
    println("La suma de 5 + 6 es ${sumar(5, 6)}")

    // Ejemplo de suma con 3 valores. El último parámetro se toma como 0 por defecto.
    println("La suma de 1 + 2 + 3 es ${sumar(1, 2, 3)}")

    // Ejemplo de suma con 5 valores. Todos los parámetros son proporcionados explícitamente.
    println("La suma de 1 + 2 + 3 + 4 + 5 es ${sumar(1, 2, 3, 4, 5)}")
}
