// Función que recibe tres enteros como parámetros y retorna el promedio de esos valores.
fun retornarPromedio(v1: Int, v2: Int, v3: Int): Int {
    // Calcula el promedio de los tres números
    val promedio = (v1 + v2 + v3) / 3
    return promedio // Devuelve el valor del promedio
}

fun main(parametro: Array<String>) {
    // Solicita al usuario que ingrese el primer valor
    print("Ingrese primer valor:")
    val valor1 = readln().toInt() // Lee y convierte el primer valor ingresado

    // Solicita al usuario que ingrese el segundo valor
    print("Ingrese segundo valor:")
    val valor2 = readln().toInt() // Lee y convierte el segundo valor ingresado

    // Solicita al usuario que ingrese el tercer valor
    print("Ingrese tercer valor:")
    val valor3 = readln().toInt() // Lee y convierte el tercer valor ingresado

    // Calcula y muestra el promedio de los tres valores ingresados
    println("Valor promedio de los tres números ingresados es ${retornarPromedio(valor1, valor2, valor3)}")
}
