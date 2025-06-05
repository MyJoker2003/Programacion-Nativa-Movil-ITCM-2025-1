// Función que muestra los tres valores ordenados de menor a mayor
fun ordenarMayorMenor(valor1: Int, valor2: Int, valor3: Int) {
    val lista = listOf(valor1, valor2, valor3).sorted()
    println("Ordenados de menor a mayor: ${lista[0]} ${lista[1]} ${lista[2]}")
}

fun main(parametros: Array<String>) {
    print("Ingrese primer valor: ")
    val valor1 = readln().toInt()

    print("Ingrese segundo valor: ")
    val valor2 = readln().toInt()

    print("Ingrese tercer valor: ")
    val valor3 = readln().toInt()

    ordenarMayorMenor(valor1, valor2, valor3)
}
