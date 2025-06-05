package Nulabilidad

fun main() {
    //TEMA 2-3: Uso de Varaibles Nulas

    var favoriteActor: String? = null

    /*El uso de '!!' en la llamada a un metodo indica que el compilador
    * debe asumir que el valor que hace la llamada no es null,
    * esto independientemente del valor real.
    *
    * Esta llamada puede provocar un NullPointerException por lo que
    * se deben tomar las precauciones adecuadas para el manejo de
    * exepciones al momento de usarlo*/
    println(favoriteActor!!.length)
}