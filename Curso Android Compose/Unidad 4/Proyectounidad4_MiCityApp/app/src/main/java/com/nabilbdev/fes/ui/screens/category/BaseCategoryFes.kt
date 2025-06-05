package com.nabilbdev.fes.ui.screens.category

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.nabilbdev.fes.R
import com.nabilbdev.fes.data.model.Recommendation
import com.nabilbdev.fes.ui.screens.feed.RecommendationCard

/**
 * Composable de pantalla base para mostrar una lista de recomendaciones en un formato de cuadrícula.
 *
 * Este composable utiliza [LazyVerticalGrid] para renderizar eficientemente una colección
 * de elementos [RecommendationCard] en dos columnas, permitiendo el desplazamiento vertical.
 *
 * @param recommendationList La lista de objetos [Recommendation] a mostrar.
 * @param onRecommendationCardPressed La función lambda que se invoca cuando se presiona
 * una tarjeta de recomendación. Recibe el objeto [Recommendation] correspondiente.
 * @param contentPadding Los valores de relleno que se aplicarán alrededor del contenido de la cuadrícula.
 */
@Composable
fun BaseCategoryScreen(
    recommendationList: List<Recommendation>,
    onRecommendationCardPressed: (Recommendation) -> Unit,
    contentPadding: PaddingValues
) {
    // Un LazyVerticalGrid es una cuadrícula que solo compone y distribuye los elementos
    // visibles en la pantalla, lo que mejora el rendimiento con listas grandes.
    LazyVerticalGrid(
        contentPadding = contentPadding, // Aplica el relleno especificado al contenido de la cuadrícula.
        horizontalArrangement = Arrangement
            .spacedBy(dimensionResource(id = R.dimen.padding_very_small)), // Espacio horizontal entre las columnas.
        verticalArrangement = Arrangement
            .spacedBy(dimensionResource(R.dimen.padding_small)), // Espacio vertical entre las filas.
        columns = GridCells.Fixed(2), // Define que la cuadrícula tendrá 2 columnas de tamaño fijo.
    ) {
        // Itera sobre la lista de recomendaciones para crear un elemento de cuadrícula para cada una.
        items(
            items = recommendationList, // La lista de datos para la cuadrícula.
            span = null // 'span = null' indica que cada elemento ocupa una celda normal.
        ) {
            // Composable que representa una tarjeta de recomendación individual.
            RecommendationCard(
                recommendation = it, // Pasa el objeto Recommendation actual a la tarjeta.
                onCardClick = { onRecommendationCardPressed(it) }, // Define la acción al hacer clic en la tarjeta.
                modifier = Modifier.padding( // Aplica un relleno a cada tarjeta.
                    paddingValues = PaddingValues(
                        dimensionResource(id = R.dimen.padding_small) // Relleno uniforme de tamaño pequeño.
                    )
                )
            )
        }
    }
}