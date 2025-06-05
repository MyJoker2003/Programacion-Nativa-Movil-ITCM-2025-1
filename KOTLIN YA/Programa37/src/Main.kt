fun main(parametro: Array<String>) {
    // Solicita al usuario la cantidad de alturas que se ingresarán
    print("Cuantas alturas ingresará?:")
    val n = readln().toInt()  // Lee la cantidad de alturas y la convierte a un número entero

    var x = 1  // Inicializa un contador para el ciclo que recorre las alturas
    var suma = 0.0  // Inicializa una variable para acumular la suma de las alturas

    // Bucle para ingresar cada altura
    while (x <= n) {
        print("Ingrese la altura de la persona(Ej:1.76) :")  // Pide al usuario que ingrese una altura
        val altura = readln().toDouble()  // Lee la altura como un número de tipo Double
        suma = suma + altura  // Suma la altura ingresada al total acumulado
        x = x + 1  // Incrementa el contador
    }

    // Calcula el promedio dividiendo la suma de las alturas entre el número total de alturas ingresadas
    val promedio = suma / n
    println("Altura promedio: $promedio")  // Muestra el resultado del promedio en pantalla
}
