fun main(parametro: Array<String>) {
    // Solicita el primer valor al usuario y lo convierte a entero
    print("Ingrese primer valor:")
    val num1 = readLine()!!.toInt()

    // Solicita el segundo valor al usuario y lo convierte a entero
    print("Ingrese segundo valor:")
    val num2 = readLine()!!.toInt()

    // Solicita el tercer valor al usuario y lo convierte a entero
    print("Ingrese tercer valor:")
    val num3 = readLine()!!.toInt()

    // Compara si el primer número es mayor que los otros dos
    if (num1 > num2 && num1 > num3)
        print(num1) // Si num1 es el mayor, lo muestra
    else
    // Si no, compara si el segundo número es mayor que el tercero
        if (num2 > num3)
            print(num2) // Si num2 es el mayor, lo muestra
        else
            print(num3) // Si no, significa que num3 es el mayor, lo muestra
}
