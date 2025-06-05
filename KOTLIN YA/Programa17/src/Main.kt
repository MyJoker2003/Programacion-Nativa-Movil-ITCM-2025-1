fun main(parametro: Array<String>) {
    // Solicita al usuario un número entre 1 y 99
    print("Ingrese un valor entero comprendido entre 1 y 99:")
    val valor = readln().toInt() // Convierte la entrada a entero

    // Determina la cantidad de dígitos: si es menor a 10, tiene 1 dígito; si no, tiene 2
    val cantidad = if (valor < 10) 1 else 2

    // Muestra cuántos dígitos tiene el número ingresado
    println("El número $valor tiene $cantidad dígito/s")
}
