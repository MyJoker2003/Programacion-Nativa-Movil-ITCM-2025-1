fun main(parametro: Array<String>) {
    print("Cuantas alturas ingresará?:")  // Solicita al usuario cuántas alturas se van a ingresar
    val n = readln().toInt()  // Lee el número de alturas que se ingresarán y lo convierte a un entero

    var x = 1  // Inicializa el contador de alturas ingresadas
    var suma = 0.0  // Inicializa la variable para sumar las alturas

    // Inicia el ciclo para ingresar cada altura, repitiendo hasta que 'x' sea mayor que 'n'
    while (x <= n) {
        print("Ingrese la altura de la persona(Ej:1.76) :")  // Solicita la altura de la persona
        val altura = readln().toDouble()  // Lee la altura y la convierte a un valor de tipo Double
        suma = suma + altura  // Suma la altura a la variable 'suma'
        x = x + 1  // Incrementa el contador de alturas ingresadas
    }

    val promedio = suma / n  // Calcula el promedio de las alturas
    println("Altura promedio: $promedio")  // Muestra el promedio de las alturas
}
