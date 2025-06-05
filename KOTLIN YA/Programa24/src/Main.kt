fun main(parametro: Array<String>) {
    // Solicita el día y lo convierte a entero
    print("Ingrese día:")
    val dia = readLine()!!.toInt()

    // Solicita el mes y lo convierte a entero
    print("Ingrese mes:")
    val mes = readLine()!!.toInt()

    // Solicita el año y lo convierte a entero
    print("Ingrese Año:")
    val año = readLine()!!.toInt()

    // Verifica si el mes ingresado está dentro del primer trimestre (enero, febrero o marzo)
    if (mes == 1 || mes == 2 || mes == 3)
        print("Corresponde al primer trimestre")
}
