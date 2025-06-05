// PROBLEMA PROPUESTO P21
/* Confeccionar un programa que permita cargar un número entero positivo de hasta tres cifras y muestre un mensaje indicando
   si tiene 1, 2, o 3 cifras. Mostrar un mensaje de error si el número de cifras es mayor. */

fun main(parametro: Array<String>) {
    // Solicita al usuario que ingrese un número entero de hasta tres cifras
    print("Ingrese un valor entero con 1, 2 o 3 cifras:")
    val valor = readln().toInt()  // Convierte la entrada de texto en un entero

    // Verifica si el número tiene una cifra (menor que 10)
    if (valor < 10)
        println("Tiene un dígito")
    else
    // Verifica si el número tiene dos cifras (de 10 a 99)
        if (valor < 100)
            println("Tiene dos dígitos")
        else
        // Verifica si el número tiene tres cifras (de 100 a 999)
            if (valor < 1000)
                println("Tiene tres dígitos")
            else
            // Si el número es mayor o igual a 1000, muestra un mensaje de error
                println("Error en la entrada de datos.")
}
