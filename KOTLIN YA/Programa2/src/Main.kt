/*fun main(parametro: Array<String>) { // Función principal que recibe argumentos de tipo Array<String>
    val valor1: Int               // Declaración de la variable inmutable valor1 de tipo Int
    val valor2: Int               // Declaración de la variable inmutable valor2 de tipo Int
    valor1 = 100                  // Asignación del valor 100 a valor1
    valor2 = 400                  // Asignación del valor 400 a valor2
    var resultado: Int           // Declaración de variable mutable resultado de tipo Int
    resultado = valor1 + valor2  // Se calcula la suma de valor1 y valor2, y se guarda en resultado
    println("La suma de $valor1 + $valor2 es $resultado") // Se imprime el resultado de la suma
    resultado = valor1 * valor2  // Se calcula el producto y se guarda en la misma variable
    println("El producto de $valor1 * $valor2 es $resultado") // Se imprime el resultado del producto
}*/

/*CONCISO 1
fun main(parametro: Array<String>) {
    val valor1: Int = 100               // Declaración y asignación en una sola línea con tipo explícito
    val valor2: Int = 400               // Igual que arriba
    var resultado: Int = valor1 + valor2 // Declaración, cálculo y asignación al mismo tiempo
    println("La suma de $valor1 + $valor2 es $resultado") // Imprime el resultado de la suma
    resultado = valor1 * valor2         // Se reutiliza la variable para el producto
    println("El producto de $valor1 * $valor2 es $resultado") // Imprime el producto
}*/

//CONCISO 2 (más idiomático en Kotlin)
fun main(parametro: Array<String>) {
    val valor1 = 100                     // El compilador infiere el tipo Int automáticamente
    val valor2 = 400                     // También infiere el tipo
    var resultado = valor1 + valor2      // Cálculo y asignación directa
    println("La suma de $valor1 + $valor2 es $resultado") // Muestra suma
    resultado = valor1 * valor2          // Calcula el producto
    println("El producto de $valor1 * $valor2 es $resultado") // Muestra producto
}