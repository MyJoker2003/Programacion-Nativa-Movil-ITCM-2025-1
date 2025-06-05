fun main(parametro: Array<String>) {
    var cant = 0  // Variable que cuenta cuántos valores han sido ingresados
    var suma = 0  // Variable que acumula la suma de los valores ingresados
    var valor: Int // Variable para almacenar el valor ingresado por el usuario

    do {
        // Pide al usuario que ingrese un valor. Si el valor es 0, finalizará el ciclo
        print("Ingrese un valor (0 para finalizar):")
        valor = readLine()!!.toInt()

        // Si el valor no es 0, suma el valor ingresado a la variable 'suma' y aumenta el contador 'cant'
        if (valor != 0) {
            suma += valor  // Suma el valor ingresado a la variable suma
            cant++  // Incrementa el contador de valores ingresados
        }
    } while (valor != 0)  // El ciclo sigue pidiendo valores hasta que el usuario ingresa 0

    // Verifica si se ingresaron valores diferentes de 0
    if (cant != 0) {
        // Si se ingresaron valores, calcula el promedio
        val promedio = suma / cant
        print("El promedio de los valores ingresados es: $promedio")  // Muestra el promedio
    } else {
        // Si no se ingresaron valores, muestra un mensaje indicando que no se ingresaron valores
        print("No se ingresaron valores.")
    }
}
