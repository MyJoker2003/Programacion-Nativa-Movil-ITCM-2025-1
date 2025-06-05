fun main(parametro: Array<String>){
    // Se solicita al usuario ingresar un valor entero positivo entre 1 y 99999
    print("Ingrese un valor entero positivo comprendido entre 1 y 99999:")
    val valor = readLine()!!.toInt()  // Se lee el valor ingresado y se convierte a entero

    // Estructura 'when' que evalúa el número de dígitos del valor ingresado
    when (valor){
        in 1..9 -> print("Tiene 1 dígito")  // Si el valor está entre 1 y 9, tiene 1 dígito
        in 10..99 -> print("Tiene 2 dígitos")  // Si el valor está entre 10 y 99, tiene 2 dígitos
        in 100..999 -> print("Tiene 3 dígitos")  // Si el valor está entre 100 y 999, tiene 3 dígitos
        in 1000..9999 -> print("Tiene 4 dígitos")  // Si el valor está entre 1000 y 9999, tiene 4 dígitos
        in 10000..99999 -> print("Tiene 5 dígitos")  // Si el valor está entre 10000 y 99999, tiene 5 dígitos
        else -> print("No se encuentra comprendido en el rango indicado")  // Si el valor no está en el rango 1-99999, se imprime este mensaje
    }
}
