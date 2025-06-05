fun main(parametro: Array<String>) {
    // Se solicita al usuario que ingrese un valor
    print("Ingrese un valor:")
    val valor = readLine()!!.toInt()  // Se convierte la entrada en un número entero

    // Se inicializa la variable 'x' con el valor 1
    var x = 1

    // El ciclo while se ejecuta mientras 'x' sea menor o igual al valor ingresado por el usuario
    while (x <= valor) {
        // Imprime el valor actual de 'x'
        println(x)

        // Incrementa 'x' en 1 en cada iteración
        x = x + 1
    }
}
