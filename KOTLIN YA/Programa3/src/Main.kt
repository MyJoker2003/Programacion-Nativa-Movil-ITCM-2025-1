// Función principal del programa, recibe un arreglo de Strings como argumentos desde la línea de comandos
fun main(argumento: Array<String>) {

    // Variable inmutable que representa el lado del cuadrado (50 unidades)
    val lado = 50

    // Variable inmutable que almacena el perímetro (suma de todos los lados: 4 * lado)
    val perimetro = lado * 4

    // Variable inmutable que almacena la superficie (lado al cuadrado)
    val superficie = lado * lado

    // Imprime en consola el perímetro y la superficie del cuadrado
    print("El perímetro de un cuadrado de lado $lado es $perimetro y su superficie es $superficie")
}
