// Función que recibe tres valores enteros y retorna el promedio de los mismos
fun devolverPromedio(v1: Int, v2: Int, v3: Int) = (v1 + v2 + v3) / 3

fun main(parametro: Array<String>) {
    // Solicitar el primer valor al usuario
    print("Ingrese primer valor:")
    val valor1 = readln().toInt()  // Leer y convertir el valor a entero

    // Solicitar el segundo valor al usuario
    print("Ingrese segundo valor:")
    val valor2 = readln().toInt()  // Leer y convertir el valor a entero

    // Solicitar el tercer valor al usuario
    print("Ingrese tercer valor:")
    val valor3 = readln().toInt()  // Leer y convertir el valor a entero

    // Llamar a la función devolverPromedio y mostrar el resultado
    println("Valor promedio de los tres números ingresados es ${devolverPromedio(valor1, valor2, valor3)}")
}
