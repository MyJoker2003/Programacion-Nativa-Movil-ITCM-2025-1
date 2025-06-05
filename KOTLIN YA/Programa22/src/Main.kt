// PROBLEMA PROPUESTO P22
/* Un postulante a un empleo realiza un test de capacitación. Se ingresa:
   - Cantidad total de preguntas realizadas.
   - Cantidad de preguntas contestadas correctamente.
   El programa debe calcular el porcentaje de respuestas correctas y mostrar el nivel alcanzado:
      - Nivel máximo: porcentaje >= 90%
      - Nivel medio:  porcentaje >= 75% y < 90%
      - Nivel regular:porcentaje >= 50% y < 75%
      - Fuera de nivel: porcentaje < 50%
*/

fun main(parametro: Array<String>) {
    // Solicita al usuario ingresar la cantidad total de preguntas
    print("Ingrese la cantidad total de preguntas del examen:")
    val totalPreguntas = readln().toInt()  // Convierte la entrada a entero

    // Solicita al usuario ingresar la cantidad de respuestas correctas
    print("Ingrese la cantidad total de preguntas contestadas correctamente:")
    val totalCorrectas = readln().toInt()  // Convierte la entrada a entero

    // Calcula el porcentaje de respuestas correctas
    val porcentaje = totalCorrectas * 100 / totalPreguntas

    // Según el porcentaje obtenido, determina el nivel
    if (porcentaje >= 90)
        println("Nivel máximo")
    else
        if (porcentaje >= 75)
            println("Nivel medio")
        else
            if (porcentaje >= 50)
                println("Nivel regular")
            else
                println("Fuera de nivel")
}
