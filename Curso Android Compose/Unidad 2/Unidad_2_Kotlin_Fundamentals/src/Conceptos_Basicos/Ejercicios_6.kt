package Conceptos_Basicos

// Teléfonos plegables-----------------------------------------------------------

/**
 * Clase base que representa un teléfono.
 *
 * @property isScreenLightOn Indica si la pantalla del teléfono está encendida.
 * Por defecto es `false` (apagada).
 */
open class Phone(var isScreenLightOn: Boolean = false) {

    /**
     * Enciende la pantalla del teléfono.
     * Este método puede ser sobrescrito por subclases para añadir lógica específica.
     */
    open fun switchOn() {
        isScreenLightOn = true
    }

    /**
     * Apaga la pantalla del teléfono.
     */
    fun switchOff() {
        isScreenLightOn = false
    }

    /**
     * Comprueba y muestra el estado actual de la luz de la pantalla del teléfono.
     * Imprime un mensaje indicando si la pantalla está "on" (encendida) o "off" (apagada).
     */
    fun checkPhoneScreenLight() {
        // Determina la cadena de texto basada en el estado de isScreenLightOn.
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

/**
 * Clase que representa un teléfono plegable, heredando de [Phone].
 *
 * @property isFolded Indica si el teléfono está plegado.
 * Por defecto es `true` (plegado).
 */
class FoldablePhone(var isFolded: Boolean = true): Phone() {

    /**
     * Sobrescribe el método `switchOn` de la clase base [Phone].
     * La pantalla solo se enciende si el teléfono no está plegado (`isFolded` es `false`).
     */
    override fun switchOn() {
        // La pantalla solo se enciende si el teléfono está desplegado.
        if (!isFolded) {
            isScreenLightOn = true
        }
    }

    /**
     * Pliega el teléfono.
     * Establece la propiedad `isFolded` a `true`.
     */
    fun fold() {
        isFolded = true
    }

    /**
     * Despliega el teléfono.
     * Establece la propiedad `isFolded` a `false`.
     */
    fun unfold() {
        isFolded = false
    }
}

/**
 * Función principal que demuestra el uso de las clases [Phone] y [FoldablePhone].
 */
fun main() {
    // Crea una nueva instancia de FoldablePhone. Por defecto, un teléfono plegable inicia plegado.
    val newFoldablePhone = FoldablePhone()

    // Intenta encender la pantalla del teléfono mientras está plegado.
    // La lógica de FoldablePhone.switchOn() previene que la pantalla se encienda si está plegado.
    newFoldablePhone.switchOn()

    // Comprueba y muestra el estado actual de la pantalla.
    // Debería imprimir "off" ya que el teléfono estaba plegado cuando se intentó encender.
    newFoldablePhone.checkPhoneScreenLight()

    // Despliega el teléfono.
    newFoldablePhone.unfold()

    // Intenta encender la pantalla nuevamente ahora que el teléfono está desplegado.
    // La pantalla debería encenderse esta vez.
    newFoldablePhone.switchOn()

    // Comprueba y muestra el estado actualizado de la pantalla.
    // Debería imprimir "on".
    newFoldablePhone.checkPhoneScreenLight()
}