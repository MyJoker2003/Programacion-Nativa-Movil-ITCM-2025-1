// Función que calcula y muestra el perímetro de un cuadrado
fun mostrarPerimetro(lado: Int) {
    val perimetro = lado * 4
    println("El perímetro es $perimetro")
}

// Función que calcula y muestra la superficie de un cuadrado
fun mostrarSuperficie(lado: Int) {
    val superficie = lado * lado
    println("La superficie es $superficie")
}

fun main(parametro: Array<String>) {
    print("Ingrese el valor del lado de un cuadrado: ")
    val la = readLine()!!.toInt()

    print("¿Quiere calcular el perímetro o la superficie? [ingresar texto: perimetro/superficie]: ")
    val respuesta = readLine()!!.lowercase() // convierte a minúsculas para evitar errores por mayúsculas

    when (respuesta) {
        "perimetro" -> mostrarPerimetro(la)
        "superficie" -> mostrarSuperficie(la)
        else -> println("Opción no válida") // control de error si escribe algo diferente
    }
}
