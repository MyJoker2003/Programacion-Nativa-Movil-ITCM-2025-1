package Nulabilidad

fun main() {
    //TEMA 2-3: Uso de Varaibles Nulas

    //Subtema: uso del operador Elvis (?:)
    var favoriteActor: String? = "Sandra Oh"

    /*El operador '?:' es una forma de condicional abreviada
    * Se agrega despues de una condicion of expresion que
    * retorne un valor booleano y el ':' indica que hacer si
    * la condicion no se cumple*/

    val lengthOfName = favoriteActor?.length ?: 0
    /*El caso anterior indica que lengthOfName tome el valor
    * de favoriteActor?.length pero si favoriteActor es null
    * no se ejecuta el metodo length y al impelementar
    * el operador Elvis se define una alternativa (else)
    * Por tanto si favoriteActor es null lengthOfName es 0*/

    //Se imprime un mensaje que incluye el valor de lengthOfName
    println("The number of characters in your favorite actor's name is $lengthOfName.")
}