package Conceptos_Basicos

// Perfil de Internet-----------------------------------------------------------

/**
 * Función principal que sirve como punto de entrada de la aplicación.
 * Aquí se crean instancias de la clase [Person] y se demuestran sus funcionalidades.
 */
fun main() {
    // Crea una instancia de la clase Person para Amanda.
    // Amanda tiene 33 años, le gusta "play tennis" y no tiene un referente.
    val amanda = Person("Amanda", 33, "play tennis", null)

    // Crea una instancia de la clase Person para Atiqah.
    // Atiqah tiene 28 años, le gusta "climb" y su referente es Amanda.
    val atiqah = Person("Atiqah", 28, "climb", amanda)

    /**
     * Llama al método [showProfile] de la instancia [amanda] para imprimir
     * los detalles del perfil de Amanda en la consola.
     */
    amanda.showProfile()

    /**
     * Llama al método [showProfile] de la instancia [atiqah] para imprimir
     * los detalles del perfil de Atiqah en la consola, incluyendo su referente.
     */
    atiqah.showProfile()
}

/**
 * Clase que representa a una persona con sus atributos básicos y la capacidad de tener un referente.
 *
 * @property name El nombre de la persona.
 * @property age La edad de la persona.
 * @property hobby El hobby de la persona. Puede ser `null` si no tiene un hobby.
 * @property referrer Una referencia a otra instancia de [Person] que es el referente de esta persona.
 * Puede ser `null` si no tiene un referente.
 */
class Person(
    val name: String, // Propiedad que almacena el nombre de la persona.
    val age: Int, // Propiedad que almacena la edad de la persona.
    val hobby: String?, // Propiedad que almacena el hobby de la persona, puede ser nulo.
    val referrer: Person? // Propiedad que almacena la referencia a otra persona, puede ser nula.
) {
    /**
     * Imprime los detalles del perfil de la persona en la consola.
     * Incluye nombre, edad, hobby (si existe) e información del referente (si existe).
     */
    fun showProfile() {
        println("Name: $name") // Imprime el nombre de la persona.
        println("Age: $age") // Imprime la edad de la persona.

        // Verifica si la persona tiene un hobby.
        if (hobby != null) {
            print("Likes to $hobby. ") // Si tiene hobby, lo imprime en la misma línea.
        }

        // Verifica si la persona tiene un referente.
        if (referrer != null) {
            // Si tiene un referente, imprime su nombre.
            print("Has a referrer named ${referrer.name}")

            // Verifica si el referente también tiene un hobby.
            if (referrer.hobby != null) {
                // Si el referente tiene hobby, lo imprime.
                print(", who likes to ${referrer.hobby}.")
            } else {
                // Si el referente no tiene hobby, solo cierra la frase con un punto.
                print(".")
            }
        } else {
            // Si la persona no tiene un referente, lo indica.
            print("Doesn't have a referrer.")
        }

        print("\n\n") // Imprime dos saltos de línea para separar los perfiles en la salida.
    }
}