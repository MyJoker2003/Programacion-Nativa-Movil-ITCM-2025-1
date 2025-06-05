fun main(parametro: Array<String>) {
    // Declaramos un arreglo de enteros llamado 'sueldos'
    val sueldos: IntArray

    // Inicializamos el arreglo con capacidad para 5 elementos
    sueldos = IntArray(5)

    // Carga de los sueldos por teclado
    for (i in 0..4) {
        print("Ingrese sueldo: ")              // Se solicita un sueldo al usuario
        sueldos[i] = readLine()!!.toInt()      // Se lee el dato ingresado, se convierte a entero y se almacena en el arreglo
    }

    // Impresión de los sueldos almacenados en el arreglo
    for (i in 0..4) {
        println(sueldos[i])                    // Se muestra cada sueldo en una nueva línea
    }
}
