fun main(parametro: Array<String>) {
    var total = 0
    for(i in 1..10) {
        print("Ingrese sueldo del operario: ")
        val sueldo = readLine()!!.toInt()

        when {
            sueldo > 5000 -> {
                println("Sueldo alto")
                total += sueldo  // Solo sumamos sueldos altos al total
            }
            sueldo > 2000 -> println("Sueldo medio") // Solo mostramos mensaje, no sumamos
            else -> println("Sueldo bajo") // Solo mostramos mensaje, no sumamos
        }
    }
    println("Gastos totales en sueldos altos: $total")
}
