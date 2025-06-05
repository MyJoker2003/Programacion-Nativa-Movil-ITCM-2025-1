// Función que recibe el valor del lado de un cuadrado y retorna el perímetro
fun devolverPerimetro(lado: Int) = lado * 4

fun main(parametro: Array<String>) {
    // Solicitar el valor del lado del cuadrado al usuario
    print("Ingrese el lado del cuadrado:")
    val lado = readln().toInt()  // Leer la entrada del usuario y convertirla a entero

    // Mostrar el resultado del cálculo del perímetro
    print("El perimetro es: ${devolverPerimetro(lado)}")
}
