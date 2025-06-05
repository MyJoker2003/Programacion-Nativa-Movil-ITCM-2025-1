fun main(parametro: Array<String>) {
    var suma = 0  // Variable que acumulará la suma de los valores ingresados
    for(i in 1..10) {  // Bucle que se ejecuta 10 veces
        print("Ingrese un valor:")  // Solicita al usuario que ingrese un valor
        val valor = readLine()!!.toInt()  // Lee el valor ingresado por el usuario y lo convierte a entero
        suma += valor  // Suma el valor ingresado a la variable 'suma'
    }
    println("La suma de los valores ingresados es $suma")  // Imprime la suma total de los valores ingresados
    val promedio = suma / 10  // Calcula el promedio de los 10 valores
    println("Su promedio es $promedio")  // Imprime el promedio
}
