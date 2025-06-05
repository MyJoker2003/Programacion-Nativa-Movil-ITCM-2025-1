fun main(parametro: Array<String>) {
    var aprobados = 0  // Variable para contar los alumnos aprobados
    var reprobados = 0  // Variable para contar los alumnos reprobados
    for(i in 1..10) {  // Bucle que se ejecuta 10 veces, una por cada alumno
        print("Ingrese nota:")  // Solicita al usuario ingresar la nota del alumno
        val nota = readLine()!!.toInt()  // Lee la nota ingresada y la convierte a un entero
        if (nota >= 7)  // Si la nota es mayor o igual a 7, el alumno está aprobado
            aprobados++  // Aumenta el contador de aprobados
        else  // Si la nota es menor a 7, el alumno está reprobado
            reprobados++  // Aumenta el contador de reprobados
    }
    println("Cantidad de alumnos con notas mayores o iguales a 7: $aprobados")  // Imprime la cantidad de alumnos aprobados
    println("Cantidad de alumnos con notas menores a 7: $reprobados")  // Imprime la cantidad de alumnos reprobados
}
