package Conceptos_Basicos

// Subasta especial-----------------------------------------------------------

/**
 * Función principal que demuestra el funcionamiento de la lógica de subasta.
 */
fun main() {
    // Crea una instancia de Bid (oferta) con un monto de 5000 y el nombre del ofertante.
    val winningBid = Bid(5000, "Private Collector")

    // Llama a la función auctionPrice con una oferta válida y un precio mínimo.
    // Si hay una oferta, la función devuelve el monto de la oferta.
    println("Item A is sold at ${auctionPrice(winningBid, 2000)}.")

    // Llama a auctionPrice con una oferta nula (sin oferta) y un precio mínimo.
    // Si no hay oferta, la función devuelve el precio mínimo.
    println("Item B is sold at ${auctionPrice(null, 3000)}.")
}

/**
 * Clase que representa una oferta en una subasta.
 *
 * @property amount El monto de la oferta.
 * @property bidder El nombre del ofertante.
 */
class Bid(val amount: Int, val bidder: String)

/**
 * Determina el precio final de un artículo en una subasta.
 *
 * @param bid Una instancia de [Bid] si se ha realizado una oferta, o `null` si no hay ofertas.
 * @param minimumPrice El precio mínimo aceptable para el artículo.
 * @return El precio final de venta del artículo. Si existe una oferta (`bid` no es nulo),
 * se retorna el [Bid.amount]. De lo contrario, se retorna el [minimumPrice].
 */
fun auctionPrice(bid: Bid?, minimumPrice: Int): Int {
    // Utiliza el operador Elvis (?:) para retornar el monto de la oferta si existe,
    // o el precio mínimo si la oferta es nula.
    return bid?.amount ?: minimumPrice
}