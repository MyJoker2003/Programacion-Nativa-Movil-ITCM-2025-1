fun main(parametro: Array<String>) {
    print("Cuantos empleados tiene la empresa:")  // Solicita al usuario cuántos empleados tiene la empresa
    val n = readln().toInt()  // Lee el número de empleados y lo convierte a un entero

    var x = 1  // Inicializa el contador de empleados
    var conta1 = 0  // Inicializa el contador de empleados con sueldos entre 100 y 300
    var conta2 = 0  // Inicializa el contador de empleados con sueldos mayores a 300
    var gastos = 0.0  // Inicializa la variable para acumular los gastos en sueldos

    // Inicia el ciclo para ingresar el sueldo de cada empleado
    while (x <= n) {
        print("Ingrese el sueldo del empleado:")  // Solicita el sueldo del empleado
        val sueldo = readln().toDouble()  // Lee el sueldo y lo convierte a un valor de tipo Double

        if (sueldo <= 300)  // Si el sueldo es menor o igual a 300
            conta1 = conta1 + 1  // Incrementa el contador de empleados con sueldos entre 100 y 300
        else  // Si el sueldo es mayor a 300
            conta2 = conta2 + 1  // Incrementa el contador de empleados con sueldos mayores a 300

        gastos = gastos + sueldo  // Suma el sueldo al total de los gastos
        x = x + 1  // Incrementa el contador de empleados
    }

    println("Cantidad de empleados con sueldos entre 100 y 300: $conta1")  // Muestra cuántos empleados ganan entre 100 y 300
    println("Cantidad de empleados con sueldos mayor a 300: $conta2")  // Muestra cuántos empleados ganan más de 300
    System.out.print("Gastos total de la empresa en sueldos: $gastos")  // Muestra el total gastado en sueldos
}
