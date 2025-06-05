fun main(parametro: Array<String>) {
    // Solicita al usuario que ingrese el precio de un producto
    print("Ingrese el precio del producto:")

    // Lee la entrada, la convierte a Double (para admitir decimales) y la almacena en 'precio'
    val precio = readLine()!!.toDouble()

    // Solicita al usuario que ingrese la cantidad de productos
    print("Ingrese la cantidad de productos:")

    // Lee la entrada, la convierte a Int y la almacena en 'cantidad'
    val cantidad = readLine()!!.toInt()

    // Calcula el total multiplicando precio por cantidad
    val total = precio * cantidad

    // Muestra el total a pagar en consola
    println("El total a pagar es $total")
}
