fun main(parametro: Array<String>) {
    // Solicita al usuario que ingrese el sueldo del empleado
    print("Ingrese el sueldo del empleado:")

    // Lee la entrada como String, la convierte a Double (para manejar decimales) y la almacena en 'sueldo'
    val sueldo = readLine()!!.toDouble()

    // Si el sueldo es mayor que 3000, se imprime que el empleado debe pagar impuestos
    if (sueldo > 3000) {
        println("Debe pagar impuestos")
    }
}
