package com.nabilbdev.fes.ui.screens.category

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import com.nabilbdev.fes.data.model.Recommendation


/**
 * Composable que representa la pantalla de categoría para Restaurantes.
 *
 * Reutiliza el componente [BaseCategoryScreen] para mostrar una lista de restaurantes,
 * ya que la lógica de visualización de una cuadrícula de recomendaciones es común.
 *
 * @param restaurantsList La lista de objetos [Recommendation] que representan los restaurantes a mostrar.
 * @param onRecommendationCardPressed La función lambda que se invoca cuando se presiona
 * una tarjeta de restaurante. Recibe el objeto [Recommendation] correspondiente.
 * @param contentPadding Los valores de relleno que se aplicarán alrededor del contenido de la cuadrícula,
 * usualmente provistos por el Scaffold.
 */
@Composable
fun RestaurantCategoryScreen(
    restaurantsList: List<Recommendation>,
    onRecommendationCardPressed: (Recommendation) -> Unit,
    contentPadding: PaddingValues
) {
    // Reutiliza el BaseCategoryScreen para mostrar la lista de restaurantes en una cuadrícula.
    BaseCategoryScreen(
        recommendationList = restaurantsList, // Pasa la lista de restaurantes como recomendaciones.
        onRecommendationCardPressed = onRecommendationCardPressed, // Pasa la acción a ejecutar al presionar una tarjeta.
        contentPadding = contentPadding // Pasa el relleno del contenido.
    )
}