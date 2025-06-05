fun main(parametro: Array<String>) {
    var suma = 0.0  // Variable que acumula la suma de los saldos acreedores

    // El ciclo do-while continúa hasta que se ingresa un número de cuenta negativo
    do {
        // Pide al usuario ingresar el número de cuenta
        print("Ingrese número de cuenta:")
        val cuenta = readln().toInt()  // Lee el número de cuenta como entero

        // Si el número de cuenta es positivo o cero (es decir, válido)
        if (cuenta >= 0) {
            // Pide al usuario ingresar el saldo de la cuenta
            print("Ingrese saldo:")
            val saldo = readln().toDouble()  // Lee el saldo de la cuenta como número decimal (Double)

            // Verifica el estado de la cuenta según el saldo
            if (saldo > 0) {
                println("Saldo Acreedor.")  // Si el saldo es mayor que cero, la cuenta está en estado acreedor
                suma += saldo  // Acumula el saldo acreedor en la variable suma
            } else if (saldo < 0) {
                println("Saldo Deudor.")  // Si el saldo es menor que cero, la cuenta está en estado deudor
            } else {
                println("Saldo Nulo.")  // Si el saldo es igual a cero, la cuenta está en estado nulo
            }
        }
    } while (cuenta >= 0)  // El ciclo se repite mientras que el número de cuenta sea no negativo

    // Al final, muestra la suma total de los saldos acreedores
    println("Total de saldos Acreedores: $suma")
}
