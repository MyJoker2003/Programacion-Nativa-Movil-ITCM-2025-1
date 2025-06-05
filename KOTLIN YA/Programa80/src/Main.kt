fun retornarMayor(v1: Int, v2: Int): Int {
    // Compara v1 con v2 y retorna el mayor de los dos
    if (v1 > v2)
        return v1
    else
        return v2
}
fun main(parametro: Array<String>) {
    print("Ingrese el primer valor:")
    val valor1 = readLine()!!.toInt() // Lee el primer valor
    print("Ingrese el segundo valor:")
    val valor2 = readLine()!!.toInt() // Lee el segundo valor
    println("El mayor entre $valor1 y $valor2 es ${retornarMayor(valor1, valor2)}") // Muestra el mayor
}
