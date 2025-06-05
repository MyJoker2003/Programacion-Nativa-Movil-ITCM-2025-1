fun main(parametro: Array<String>) {
    var suma = 0  // Variable que acumula la suma de los valores ingresados

    // El ciclo do-while se ejecuta hasta que se ingresa el valor 9999
    do {
        // Pide al usuario ingresar un valor
        print("Ingrese un valor (finalizar con 9999):")
        val valor = readln().toInt()  // Lee el valor ingresado como entero

        // Si el valor no es 9999, lo agrega a la suma
        if (valor != 9999)
            suma += valor  // Acumula el valor en la variable suma

    } while (valor != 9999)  // El ciclo sigue hasta que el valor ingresado sea 9999

    // Al finalizar el ciclo, muestra el valor acumulado
    println("El valor acumulado es $suma")

    // Verifica si el valor acumulado es cero, positivo o negativo
    if (suma == 0)
        println("El valor acumulado es cero.")  // Si la suma es cero
    else
        if (suma > 0)
            println("El valor acumulado es positivo.")  // Si la suma es mayor a cero
        else
            println("El valor acumulado es negativo")  // Si la suma es menor a cero
}
