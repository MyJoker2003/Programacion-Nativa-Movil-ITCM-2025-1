// Función que recibe el valor del lado de un cuadrado y retorna su perímetro.
fun retornarPerimetro(lado: Int): Int {
    // El perímetro de un cuadrado es 4 veces el valor de su lado
    val perimetro = lado * 4
    return perimetro // Devuelve el perímetro calculado
}

fun main(parametro: Array<String>) {
    // Solicita al usuario que ingrese el valor del lado del cuadrado
    print("Ingrese el lado del cuadrado:")
    val lado = readln().toInt() // Lee y convierte el valor ingresado a un número entero

    // Muestra el resultado del perímetro del cuadrado calculado con la función
    println("El perimetro es: ${retornarPerimetro(lado)}")
}
