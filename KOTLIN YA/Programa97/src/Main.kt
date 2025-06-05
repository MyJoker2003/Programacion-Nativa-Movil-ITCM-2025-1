// PROBLEMA PROPUESTO 97
/* Confeccionar una función que permita cargar dos enteros y nos muestre el mayor de ellos.
   Realizar esta actividad con 5 pares de valores.
   Implementar una función interna que retorne el mayor de dos enteros. */

// Función principal que controla la carga y comparación de valores
fun mostrarMayor() {

    // Función interna que retorna el mayor de dos enteros usando una expresión if/else
    fun mayor(x1: Int, x2: Int) = if (x1 > x2) x1 else x2

    // Bucle que se repite 5 veces para ingresar y comparar 5 pares de valores
    for (i in 1..5) {
        print("Ingrese primer valor: ")
        val valor1 = readln().toInt()  // Se lee el primer número y se convierte a entero
        print("Ingrese segundo valor: ")
        val valor2 = readln().toInt()  // Se lee el segundo número

        // Se muestra el mayor entre los dos valores utilizando la función mayor
        println("El mayor entre $valor1 y $valor2 es ${mayor(valor1, valor2)}")
    }
}

// Función main que llama a la función mostrarMayor
fun main(parametro: Array<String>) {
    mostrarMayor()
}
