// Función que imprime un título seguido de un subrayado con un carácter determinado.
fun tituloSubrayado(titulo: String, caracter: String = "*") {
    println(titulo)  // Imprime el título
    println(caracter.repeat(titulo.length))  // Imprime el subrayado usando la función repeat
}

fun main(parametro: Array<String>) {
    // Llamada a la función con el valor por defecto para el carácter de subrayado
    tituloSubrayado("Sistema de Administracion")
    // Llamada a la función con un carácter de subrayado personalizado
    tituloSubrayado("Ventas", "-")
}
