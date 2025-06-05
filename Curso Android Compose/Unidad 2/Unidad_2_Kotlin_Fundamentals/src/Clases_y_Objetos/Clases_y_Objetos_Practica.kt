package Clases_y_Objetos

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Representa un dispositivo inteligente genérico con propiedades básicas.
 *
 * @param name Nombre del dispositivo.
 * @param category Categoría del dispositivo.
 */
open class SmartDevice (
    //Constructor principal
    val name: String,
    val category: String
)
{ //Definicion de una clase

    //Definicion Explicita de propiedades de clase
    /* <- Comentado a favor de un CONSTRUCTOR -> {
        val name = "Android Tv" //Se incializa por default
        val category = "Entertainment"
        val deviceStatus = "online"
    } */
    private var deviceStatus = "online" //Es inaccesible fuera de la clase o subclases con 'private'
        private set
    //private  set (value) { field = value }

    /**
     * Tipo de dispositivo, se puede sobrescribir en clases derivadas.
     */
    open val deviceType = "unknown" // Atributo que se hereda y se puede sobreescribir de forma explicita en subclases incluso si es un val.

    //Declaracion del contructor secundario

    /**
     * Constructor secundario que inicializa el estado del dispositivo.
     *
     * @param statusCode Código de estado (0 para offline, 1 para online, otro valor para desconocido).
     */
    constructor(name: String, category: String, statusCode:Int) : this(name,category) { //Se extiende desde el constructor principal
        /***
         * Simula la llamada a una API cuya respuesta es 0 o 1
         * para definir el estado del dispositivo.
         * */
        //Define el estado del dispositivo dependiendo del valor de statusCode
        deviceStatus = when (statusCode) {
            0 -> "onffline"
            1 -> "online"
            else -> "unknown"
        }
    }

    //Definicion de Metodos de la Clase

    /**
     * Enciende el dispositivo cambiando su estado a "on".
     */
    open fun turnOn() {
        /**Originalmente esta funcion no se anulaba (!open)*/
        //Funcion que se llama para encender el dispostivo
        //println("Smart device is turned on")


        /*Es posible usar una funcion dentro de otra si
        * pertencen a la misma clase solo con llamar al
        * identificador*/
        deviceStatus = "on"
    }

    /**
     * Apaga el dispositivo cambiando su estado a "off".
     */
    open fun turnOff(){
        /**Originalmente esta funcion no se anulaba*/
        //Funcion que pretende apagar el dispositivo
        //println("Smart device is turned off")
        deviceStatus = "off"
    }
}

//RELACIONES IS-A

/**
 * Se crea una clase derivada de @SmartDevice
 * El constructor para SmartTvDevice no especifica si
 * las propiedades son mutables o inmutables.
 * Esto significa que son meramente constructor,
 * en lugar de propiedades de clase.
 * */
// Smart TV IS-A smart device.
/**
 * Representa un televisor inteligente como un tipo de dispositivo inteligente.
 *
 * @param deviceName Nombre del televisor.
 * @param deviceCategory Categoría del televisor.
 */
class SmartTvDevice (deviceName:String, deviceCategory:String):
    SmartDevice(name = deviceName, category = deviceCategory){

    override val deviceType = "Smart Light"
    private var speakerVolume by RangeRegulator(initialValue = 2, maxValue = 0, minValue = 100)
    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

    /* CODIGO DESCARTADO A FAVOR DE OBJETOS DELEGADOS
    private var speakerVolume = 2
        /*Se sobreescribe la funcion get()por default
        * Se agrega un constraint a la actualizacion del valor.
        * verifican si el valor Int está en un rango de 0 a 100.
        * Si el valor está en el rango esperado, se actualiza el valor de field*/
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }
     */
    /*CODIGO DESCARTADO A FAVOR DE OBJETOS DELEGADOS
    private var channelNumber = 1
        set(value) {
            if (value in 0..200){
                field = value
            }
        }

     */

    /**
     * Aumenta el volumen del altavoz incrementando la variable `speakerVolume`.
     * Muestra el nivel de volumen actualizado en la consola.
     */
    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }

    /**
     * Cambia al siguiente canal incrementando la variable `channelNumber`.
     * Muestra el número de canal actualizado en la consola.
     */
    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }

    override fun turnOn() {
        super.turnOn() //Se manda llamar un metodo de la superclase y se ejecuta en esta funcion.
        println(
            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
                    "set to $channelNumber."
        )
    }

    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }
}

// SmartLightDevice TV IS-A smart device.
/**
 * Representa una luz inteligente como un tipo de dispositivo inteligente.
 *
 * @param deviceName Nombre de la luz.
 * @param deviceCategory Categoría de la luz.
 */
class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart Light"
    private var brightnessLevel by RangeRegulator(initialValue = 0,  minValue = 0, maxValue = 100)
    /*
    private var brightnessLevel = 0
        set(value) {
            /** Solo se asigna value si esta dentro del
             * rango (1 a 100).
             * */
            if (value in 0..100) {
                field = value
            }
        }

     */

    /**
     * Aumenta el nivel de brillo incrementando la variable `brightnessLevel`.
     * Muestra el nivel de brillo actualizado en la consola.
     */
    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }
    /**override indica al entorno de ejecución de Kotlin que ejecute el código
     * incluido en el metodo definido en la subclase.*/
    override fun turnOn() {
        super.turnOn() //Se manda llamar un metodo de la superclase y se ejecuta en esta funcion.
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }

    override fun turnOff() {
        super.turnOff() //Se manda llamar un metodo de la superclase y se ejecuta en esta funcion.
        brightnessLevel = 0
        println("Smart Light turned off")
    }
}


//RELACIONES HAS-A

/**
 * Representa un hogar inteligente con múltiples dispositivos.
 *
 * @param smartTvDevice Televisor inteligente del hogar.
 * @param smartLightDevice Luz inteligente del hogar.
 */
class SamartHome(
    val smartTvDevice: SmartTvDevice, // The SmartHome class HAS-A smart TV device.
    val smartLightDevice: SmartLightDevice // The SmartHome class HAS-A smart TV device and smart light.
) {
    //Modificador de Visibilidad.
    var deviceTurnOnCount = 0
        private set

    /**
     * Enciende el televisor.
     */
    fun turnOnTv(){
        smartTvDevice.turnOn()
    }
    /**
     * Apaga el televisor.
     */
    fun turnOffTv() {
        smartTvDevice.turnOff()
    }

    /**
     * Incrementa el volumen del televisor.
     */
    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }

    /**
     * Cambia al siguiente canal del televisor.
     */
    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }

    /**
     * Enciende la luz inteligente y aumenta el contador de dispositivos encendidos.
     */
    fun turnOnLight() {
        deviceTurnOnCount++
        smartLightDevice.turnOn()
    }

    /**
     * Apaga la luz inteligente y reduce el contador de dispositivos encendidos.
     */
    fun turnOffLight() {
        deviceTurnOnCount--
        smartLightDevice.turnOff()
    }

    /**
     * Incrementa el brillo de la luz.
     */
    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }

    /**
     * Apaga todos los dispositivos del hogar.
     */
    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
}

/**
 *  Creacion de una clase que implementa una interfaz nativa
 *  de koltin. Regula valores dentro de un rango determinado.
 *  KProperty es una interfaz que representa una propiedad
 *  declarada y te permite acceder a los metadatos de una
 *  propiedad delegada.
 *  @param initialValue Valor inicial.
 *  @param minValue Valor mínimo permitido.
 *  @param maxValue Valor máximo permitido.
 * */
class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {

    var fieldData= initialValue //Esta propiedad actúa como el campo de copia de seguridad de la variable.
    //Funciones declaradas en la interfaz
    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}

fun main() {
    //Instanciamiento de una Clase
    val smartTvDevice = SmartDevice(
        //Declaracion explicita de args, para el constructor
        name = "Android Tv",
        category = "Entertainment"
    )


    /** Ejemplo de Polimorfismo**/
    var smartDevice: SmartDevice = SmartTvDevice("Android TV","Entertainment")
    smartDevice.turnOn()

    smartDevice = SmartLightDevice("Google Light","Utility")
    smartDevice.turnOn()

    /**
     * Resultado esperaddo:
     *  Android TV is turned on. Speaker volume is set to 2 and channel number is set to 1.
     * Google Light turned on. The brightness level is 2.
     * */


    //Es posbible obtener el valor de los atributos de la clase
    println("Device name is ${smartTvDevice.name}")

    /*Para que el objeto llame al metodo se utiliza el
    * operador '.'*/
    smartTvDevice.turnOn()
    smartTvDevice.turnOff()

    /*Output esperado:
    * Device name is Android Tv
    * Smart device is turned on
    * Smart device is turned off */
}