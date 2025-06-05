fun main(parametro: Array<String>) {
    print("Cuantas piezas procesará:")  // Solicita al usuario cuántas piezas procesará
    val n = readLine()!!.toInt()  // Lee la cantidad de piezas que se procesarán y la convierte a un entero

    var x = 1  // Inicializa el contador de piezas
    var cantidad = 0  // Inicializa el contador de piezas aptas

    // Inicia el ciclo para procesar cada pieza, repitiendo hasta que 'x' sea mayor que 'n'
    while (x <= n) {
        print("Ingrese la medida de la pieza:")  // Solicita el largo de la pieza
        val largo = readLine()!!.toDouble()  // Lee el largo de la pieza y lo convierte a un valor de tipo Double

        // Si la medida de la pieza está entre 1.20 y 1.30, se incrementa el contador de piezas aptas
        if (largo >= 1.20 && largo <= 1.30)
            cantidad = cantidad +1  // Incrementa la cantidad de piezas aptas

        x = x + 1  // Incrementa el contador de piezas procesadas
    }

    print("La cantidad de piezas aptas son: $cantidad")  // Muestra la cantidad de piezas aptas
}
