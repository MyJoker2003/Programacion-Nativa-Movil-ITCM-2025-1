// PROBLEMA PROPUESTO P29
/* Escribir un programa que pida ingresar la coordenada de un punto en el plano, es decir dos valores enteros x e y (distintos a cero).
   Posteriormente imprimir en pantalla en qué cuadrante se ubica dicho punto.
   (1º Cuadrante si x > 0 y y > 0, 2º Cuadrante: x < 0 y y > 0, etc.) */

fun main(parametro: Array<String>) {
    // Solicita al usuario que ingrese la coordenada X
    print("Ingrese coordenada x:")
    val x = readln().toInt()

    // Solicita al usuario que ingrese la coordenada Y
    print("Ingrese coordenada y:")
    val y = readln().toInt()

    // Verifica si el punto se encuentra en el primer cuadrante (x > 0, y > 0)
    if (x > 0 && y > 0)
        print("Se encuentra en el primer cuadrante")
    else
    // Verifica si está en el segundo cuadrante (x < 0, y > 0)
        if (x < 0 && y > 0)
            print("Se encuentra en el segundo cuadrante")
        else
        // Verifica si está en el tercer cuadrante (x < 0, y < 0)
            if (x < 0 && y < 0)
                print("Se encuentra en el tercer cuadrante")
            else
            // Verifica si está en el cuarto cuadrante (x > 0, y < 0)
                if (x > 0 && y < 0)
                    print("Se encuentra en el cuarto cuadrante")
                else
                // Si no se encuentra en ninguno de los cuadrantes anteriores, está sobre un eje
                    print("Se encuentra en un eje")
}
