fun main(parametro: Array<String>) {
    // Se inicializa la variable 'x' en 1 y 'suma' en 0 para realizar la suma
    var x = 1
    var suma = 0

    // Se ejecuta un ciclo while que se repite 10 veces
    while (x <= 10) {
        // Se solicita al usuario ingresar un valor
        print("Ingrese un valor:")
        val valor = readLine()!!.toInt()  // Se convierte el valor ingresado a un número entero

        // Se agrega el valor ingresado a la variable 'suma'
        suma = suma + valor

        // Se incrementa 'x' en 1 para avanzar al siguiente ciclo
        x = x + 1
    }

    // Imprime la suma total de los 10 valores ingresados
    println("La suma de los 10 valores ingresados es $suma")

    // Calcula el promedio dividiendo la suma entre 10
    val promedio = suma / 10

    // Imprime el promedio
    println("El promedio es $promedio")
}
