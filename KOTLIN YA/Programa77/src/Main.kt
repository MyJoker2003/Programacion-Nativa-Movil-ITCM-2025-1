// Función que compara dos claves y muestra si son iguales o no
fun verificarClaves(clave1: String, clave2: String) {
    if (clave1 == clave2)
        println("Se ingresó la misma clave dos veces.")
    else
        println("Las claves ingresadas son distintas.")
}

fun main(parametro: Array<String>) {
    print("Ingrese la primera clave: ")
    val clave1 = readln()

    print("Repita el ingreso de la misma clave: ")
    val clave2 = readln()

    verificarClaves(clave1, clave2)
}
