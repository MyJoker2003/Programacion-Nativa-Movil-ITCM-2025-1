fun main(parametro: Array<String>) {
    // Solicita la coordenada x
    print("Ingrese coordenada x del punto:")
    val x = readLine()!!.toInt()

    // Solicita la coordenada y
    print("Ingrese coordenada y del punto:")
    val y = readLine()!!.toInt()

    // Verifica en qué cuadrante o eje se encuentra el punto
    when {
        x > 0 && y > 0 -> println("Primer cuadrante")
        x < 0 && y > 0 -> println("Segundo cuadrante")
        x < 0 && y < 0 -> println("Tercer cuadrante")
        x > 0 && y < 0 -> println("Cuarto cuadrante")
        else -> println("El punto se encuentra en un eje")
    }
}
