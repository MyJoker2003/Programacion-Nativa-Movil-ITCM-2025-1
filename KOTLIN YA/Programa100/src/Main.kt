fun main(parametro: Array<String>) {
    // Creamos un arreglo de 10 elementos tipo entero
    val arreglo = IntArray(10)

    // Cargamos los elementos del arreglo desde el teclado
    for (i in 0..arreglo.size - 1) {
        print("Ingrese elemento: ")
        arreglo[i] = readLine()!!.toInt()  // Convertimos el valor ingresado a Int y lo almacenamos
    }

    // Suponemos que el arreglo está ordenado (de menor a mayor)
    var ordenado = true

    // Verificamos si los elementos están ordenados de menor a mayor
    for (i in 0..arreglo.size - 2) {
        if (arreglo[i + 1] < arreglo[i])  // Si el siguiente es menor que el actual
            ordenado = false              // Entonces el arreglo no está ordenado
    }

    // Mostramos el resultado
    if (ordenado)
        print("Los elementos están ordenados de menor a mayor")
    else
        print("Los elementos no están ordenados de menor a mayor")
}
