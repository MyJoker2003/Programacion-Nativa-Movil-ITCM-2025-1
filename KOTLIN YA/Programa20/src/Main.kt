// PROBLEMA PROPUESTO P20
/* Se ingresa por teclado un valor entero,
   mostrar una leyenda que indique si el número es positivo, nulo o negativo. */

fun main(parametro: Array<String>){
    // Solicita al usuario ingresar un valor entero
    print("Ingrese un valor entero:")
    val valor = readln().toInt()

    // Verifica si el valor ingresado es igual a 0
    if (valor == 0)
    // Si el valor es 0, muestra el mensaje correspondiente
        println("Se ingresó el cero")
    else
    // Si el valor no es 0, se realiza una segunda verificación
        if (valor > 0)
        // Si el valor es mayor que 0, muestra el mensaje de valor positivo
            println("Se ingresó un valor positivo")
        else
        // Si el valor no es 0 ni positivo, entonces es negativo, muestra el mensaje correspondiente
            println("Se ingresó un valor negativo")
}
