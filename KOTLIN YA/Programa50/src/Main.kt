fun main(parametro: Array<String>) {
    var mult3 = 0  // Variable para contar los múltiplos de 3
    var mult5 = 0  // Variable para contar los múltiplos de 5
    var mult9 = 0  // Variable para contar los múltiplos de 9

    // Bucle que recorre los números del 1 al 10000
    for(i in 1..10000) {
        if (i % 3 == 0)  // Si el número es divisible por 3
            mult3++  // Incrementa el contador de múltiplos de 3
        if (i % 5 == 0)  // Si el número es divisible por 5
            mult5++  // Incrementa el contador de múltiplos de 5
        if (i % 8 == 0)  // Si el número es divisible por 8
            mult9++  // Incrementa el contador de múltiplos de 8
    }

    // Imprime el resultado de la cantidad de múltiplos de 3, 5 y 9
    println("Cantidad de múltiplos de 3: $mult3")
    println("Cantidad de múltiplos de 5: $mult5")
    println("Cantidad de múltiplos de 9: $mult9")
}
