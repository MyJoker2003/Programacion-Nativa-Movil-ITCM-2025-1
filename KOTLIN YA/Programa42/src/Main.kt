fun main(parametro: Array<String>) {
    var valor: Int
    do {
        // Solicita al usuario que ingrese un valor entre 0 y 999
        print("Ingrese un valor comprendido entre 0 y 999:")
        valor = readLine()!!.toInt()

        // Verificamos que el valor esté en el rango de 0 a 999
        if (valor in 0..999) {
            // Si el valor es menor a 10, tiene un dígito
            if (valor < 10) {
                println("El valor ingresado tiene un dígito")
            }
            // Si el valor es menor a 100 pero mayor o igual a 10, tiene dos dígitos
            else if (valor < 100) {
                println("El valor ingresado tiene dos dígitos")
            }
            // Si el valor es mayor o igual a 100, tiene tres dígitos
            else {
                println("El valor ingresado tiene tres dígitos")
            }
        } else {
            // Si el valor no está en el rango de 0 a 999, muestra un mensaje de error
            println("El valor ingresado no está en el rango permitido. Intente nuevamente.")
        }
    } while (valor != 0) // El ciclo continúa hasta que el usuario ingrese el valor 0
}
