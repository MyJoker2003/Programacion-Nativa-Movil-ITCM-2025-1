package Nulabilidad

fun main() {
    //TEMA 2-3: Uso de Varaibles Nulas

    //Subtema: Operacion de metodos en variables nulas con '?'

    var favoriteActor: String? = "Sandra Oh"
    //var favoriteActor: String? = null

    /*Al acceder a metodos de un objeto que puede tomar
    * un valor null, se le agrega '?' antes de la llamada
    * al metodo por seguridad, de modo que si el valor es null
    * no se ejecuta el metodo y se retorna null*/
    println(favoriteActor?.length)
}