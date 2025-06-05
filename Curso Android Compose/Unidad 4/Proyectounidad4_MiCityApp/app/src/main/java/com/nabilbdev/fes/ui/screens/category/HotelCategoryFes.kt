package com.nabilbdev.fes.ui.screens.category

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import com.nabilbdev.fes.data.model.Recommendation

/**
 * Composable que representa la pantalla de categoría para Hoteles.
 *
 * Esta pantalla reutiliza el componente [BaseCategoryScreen] para mostrar una lista de hoteles,
 * ya que la lógica de visualización de una cuadrícula de recomendaciones es común.
 *
 * @param hotelsList La lista de objetos [Recommendation] que representan los hoteles a mostrar.
 * @param onRecommendationCardPressed La función lambda que se invoca cuando se presiona
 * una tarjeta de hotel. Recibe el objeto [Recommendation] correspondiente.
 * @param contentPadding Los valores de relleno que se aplicarán alrededor del contenido de la cuadrícula,
 * usualmente provistos por el Scaffold.
 */
@Composable
fun HotelCategoryScreen(
    hotelsList: List<Recommendation>,
    onRecommendationCardPressed: (Recommendation) -> Unit,
    contentPadding: PaddingValues
) {
    // Reutiliza el BaseCategoryScreen para mostrar la lista de hoteles en una cuadrícula.
    BaseCategoryScreen(
        recommendationList = hotelsList, // Pasa la lista de hoteles como recomendaciones.
        onRecommendationCardPressed = onRecommendationCardPressed, // Pasa la acción a ejecutar al presionar una tarjeta.
        contentPadding = contentPadding // Pasa el relleno del contenido.
    )
}