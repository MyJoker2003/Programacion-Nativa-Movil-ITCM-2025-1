fun main(parametro: Array<String>) {
    // Solicita al usuario que ingrese el primer valor
    print("Ingrese primer valor:")
    val valor1 = readLine()!!.toInt() // Lee el valor ingresado y lo convierte a entero

    // Solicita al usuario que ingrese el segundo valor
    print("Ingrese segundo valor:")
    val valor2 = readLine()!!.toInt() // Lee el segundo valor y lo convierte a entero

    // Compara los dos valores
    if (valor1 > valor2)
        print("El mayor valor es $valor1") // Si valor1 es mayor, lo muestra como el mayor
    else
        print("El mayor valor es $valor2") // Si no, muestra valor2 como el mayor
}
