// Punto 13: Evaluar si un alumno está promocionado según su promedio

fun main(parametro: Array<String>) {
    // Solicita la primera nota al usuario
    print("Ingrese primer nota:")
    val nota1 = readln().toInt() // Convierte la entrada a entero

    // Solicita la segunda nota
    print("Ingrese segunda nota:")
    val nota2 = readln().toInt()

    // Solicita la tercera nota
    print("Ingrese tercer nota:")
    val nota3 = readln().toInt()

    // Calcula el promedio de las tres notas (división entera)
    var promedio = (nota1 + nota2 + nota3) / 3

    // Si el promedio es mayor o igual a 7, se muestra el mensaje de "Promocionado"
    if (promedio >= 7)
        println("Promocionado")
}
