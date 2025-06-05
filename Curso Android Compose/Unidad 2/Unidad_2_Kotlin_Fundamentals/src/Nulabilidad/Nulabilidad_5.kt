package Nulabilidad

fun main() {
    //TEMA 2-3: Uso de Varaibles Nulas

    /*Subtema: Uso de Condicionales para verificacion
    * de variables nulas*/

    //Cadena que puede ser null
    var favoriteActor: String? = null

    //SI favoriteActor no es null
    if(favoriteActor != null) {
        println("The number of characters in your favorite actor's name is ${favoriteActor.length}.")
    } else { //De lo contrario.
        println("You didn't input a name.")
    }

    /*El uso del safe call '?' para el llamado de metodos
    * ese preferible cuando la instruccion es simple
    *
    * Sin embargo para la ejecucion de varias instrucciones
    * de acuerdo con el valor de la variable se recomienda
    * usar condicionales*/
}