fun main(parametros: Array<String>) {
    // Solicita al usuario que ingrese la primera nota
    print("Ingrese primer nota:")
    val nota1 = readLine()!!.toInt()

    // Solicita al usuario que ingrese la segunda nota
    print("Ingrese segunda nota:")
    val nota2 = readLine()!!.toInt()

    // Solicita al usuario que ingrese la tercera nota
    print("Ingrese tercer nota:")
    val nota3 = readLine()!!.toInt()

    // Calcula el promedio sumando las tres notas y dividiéndolas entre 3
    val promedio = (nota1 + nota2 + nota3) / 3

    // Condición: si el promedio es 7 o más, el alumno está promocionado
    if (promedio >= 7)
        print("Promocionado")
    else
    // Si no, verifica si el promedio es al menos 4 para ser regular
        if (promedio >= 4)
            print("Regular")
        else
        // Si el promedio es menor a 4, el alumno está reprobado
            print("Reprobado")
}
