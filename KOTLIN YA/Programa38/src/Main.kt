fun main(parametro: Array<String>) {
    // Inicializa el primer término de la serie, que es 11
    var termino = 11

    // Inicializa un contador para controlar cuántos términos se han mostrado
    var x = 1

    // Bucle para imprimir los primeros 25 términos de la serie
    while (x <= 25) {
        println(termino)  // Imprime el término actual de la serie
        termino = termino + 11  // Incrementa el término en 11 para el siguiente valor de la serie
        x = x + 1  // Incrementa el contador
    }
}
