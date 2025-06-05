fun main(parametros: Array<String>) {
    // Solicita las tres notas al usuario
    print("Ingrese primer nota:")
    val nota1 = readLine()!!.toInt()

    print("Ingrese segunda nota:")
    val nota2 = readLine()!!.toInt()

    print("Ingrese tercer nota:")
    val nota3 = readLine()!!.toInt()

    // Calcula el promedio
    val promedio = (nota1 + nota2 + nota3) / 3

    // Muestra el resultado según el promedio
    when {
        promedio >= 7 -> print("Promocionado")  // Promocionado si el promedio es 7 o más
        promedio >= 4 -> print("Regular")       // Regular si es entre 4 y 6
        else -> print("Reprobado")              // Reprobado si es menor que 4
    }
}
