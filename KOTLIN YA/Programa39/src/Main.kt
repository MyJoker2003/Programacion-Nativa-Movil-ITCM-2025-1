fun main(parametro: Array<String>) {
    // Inicializa la variable con el primer múltiplo de 8
    var mult8 = 8

    // Bucle para imprimir los múltiplos de 8 hasta 500
    while (mult8 <= 500) {
        // Imprime el múltiplo de 8 seguido de un guion
        print("$mult8 -")

        // Incrementa la variable mult8 en 8 para obtener el siguiente múltiplo
        mult8 = mult8 + 8
    }
}
