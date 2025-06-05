// Función que calcula el sueldo de una persona, dados su nombre, el costo por hora trabajada y la cantidad de horas trabajadas.
fun calcularSueldo(nombre: String, costoHora: Double, cantidadHoras: Int) {
    // Se calcula el sueldo multiplicando el costo por hora por la cantidad de horas trabajadas.
    val sueldo = costoHora * cantidadHoras

    // Se imprime un mensaje detallando el nombre, las horas trabajadas, el costo por hora y el sueldo total.
    println("$nombre trabajó $cantidadHoras horas, se le paga por hora $costoHora por lo tanto le corresponde un sueldo de $sueldo")
}

fun main(parametro: Array<String>) {
    // Llamada a la función con argumentos en orden: nombre, costo por hora y cantidad de horas.
    calcularSueldo("juan", 10.5, 120)

    // Llamada a la función utilizando argumentos nombrados (pueden ir en cualquier orden).
    calcularSueldo(costoHora = 12.0, cantidadHoras = 40, nombre = "ana")

    // Otro ejemplo con argumentos nombrados y en diferente orden.
    calcularSueldo(cantidadHoras = 90, nombre = "luis", costoHora = 7.25)
}
