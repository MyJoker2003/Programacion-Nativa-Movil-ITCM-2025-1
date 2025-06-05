fun main(parametro: Array<String>) {
    // Solicita al usuario que ingrese la medida del lado del cuadrado
    print("Ingrese la medida del lado del cuadrado:")

    // Lee la entrada desde consola, la convierte a entero y la almacena en la variable 'lado'
    val lado = readLine()!!.toInt()

    // Calcula el perímetro del cuadrado (lado * 4)
    val perimetro = lado * 4

    // Muestra el resultado del perímetro en consola
    println("El perímetro del cuadrado es $perimetro")
}