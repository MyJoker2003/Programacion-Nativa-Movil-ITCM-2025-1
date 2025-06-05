fun retornarSuperficie(lado: Int): Int {
    val sup = lado * lado  // Calcula el área del cuadrado
    return sup             // Devuelve el valor calculado
}
fun main(parametro: Array<String>) {
    print("Ingrese el valor del lado del cuadrado:")
    val la = readLine()!!.toInt()           // Lee el lado desde teclado
    val superficie = retornarSuperficie(la) // Llama a la función y guarda el resultado
    println("La superficie del cuadrado es $superficie") // Muestra el resultado
}
