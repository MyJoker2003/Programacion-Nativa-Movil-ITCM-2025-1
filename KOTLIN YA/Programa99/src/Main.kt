fun main(parametro: Array<String>) {
    // Declaramos un arreglo de 5 elementos tipo Float para almacenar las alturas
    val alturas = FloatArray(5)

    // Variable para acumular la suma total de las alturas
    var suma = 0f

    // Recorremos el arreglo para cargar las alturas y acumular la suma
    for (i in 0..alturas.size - 1) {
        print("Ingrese la altura: ")
        alturas[i] = readLine()!!.toFloat()  // Leemos y convertimos el dato a Float
        suma += alturas[i]                   // Sumamos la altura al total
    }

    // Calculamos el promedio dividiendo la suma total entre la cantidad de alturas
    val promedio = suma / alturas.size
    println("Altura promedio: $promedio")

    // Variables para contar cuántas personas son más altas o más bajas que el promedio
    var altos = 0
    var bajos = 0

    // Recorremos el arreglo de alturas para comparar con el promedio
    for (i in 0..alturas.size - 1) {
        if (alturas[i] > promedio)
            altos++   // Si es mayor al promedio, incrementamos el contador de altos
        else
            bajos++   // Si es igual o menor, incrementamos el contador de bajos
    }

    // Mostramos los resultados
    println("Cantidad de personas más altas que el promedio: $altos")
    println("Cantidad de personas más bajas que el promedio: $bajos")
}
