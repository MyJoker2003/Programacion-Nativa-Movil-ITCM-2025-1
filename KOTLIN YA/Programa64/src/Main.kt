fun main(parametro: Array<String>) {
    // Inicializamos la variable suma en 0, donde se acumularán los valores mayores
    var suma = 0

    // Se repite 5 veces, tal como lo indica el enunciado
    for(i in 1..5) {
        // Solicitamos al usuario que ingrese tres valores enteros
        print("Ingrese primer valor:")
        val valor1 = readln().toInt()
        print("Ingrese segundo valor:")
        val valor2 = readln().toInt()
        print("Ingrese tercer valor:")
        val valor3 = readln().toInt()

        // Usamos 'when' para determinar cuál de los tres valores es el mayor
        // Solo acumulamos el mayor de los tres valores
        suma += when {
            valor1 > valor2 && valor1 > valor3 -> valor1   // Si el primer valor es mayor que los otros dos, lo acumulamos
            valor2 > valor3 -> valor2                       // Si el segundo valor es mayor que el tercero, lo acumulamos
            else -> valor3                                 // Si el tercer valor es el mayor, lo acumulamos
        }
    }

    // Imprimimos el resultado final: la suma de los valores mayores de cada conjunto
    println("El valor acumulado de los mayores de cada lista de 3 valores es: $suma")
}
