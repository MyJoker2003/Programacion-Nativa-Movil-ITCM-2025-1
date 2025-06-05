package com.nabilbdev.fes.ui.screens.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineBreak
import com.nabilbdev.fes.R
import com.nabilbdev.fes.data.model.CategoryOptions
import com.nabilbdev.fes.data.model.Recommendation
import com.nabilbdev.fes.ui.screens.bars.FesTopBanner

/**
 * Composable que representa la pantalla principal de "Feed".
 *
 * Muestra un banner en la parte superior y luego una serie de columnas verticales de recomendaciones,
 * agrupadas por categoría. La pantalla es desplazable verticalmente.
 *
 * @param listByCategory Una lista de pares que asocian una [CategoryOptions] con su respectiva lista de [Recommendation].
 * @param onRecommendationCardPressed La función lambda que se invoca cuando se presiona una tarjeta de recomendación.
 * @param contentPadding Los valores de relleno que se aplicarán al contenido, típicamente provistos por un Scaffold.
 * @param modifier Un [Modifier] para aplicar a este composable.
 */
@Composable
fun FeedScreen(
    listByCategory: List<Map.Entry<CategoryOptions, List<Recommendation>>>,
    onRecommendationCardPressed: (Recommendation) -> Unit,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    // Columna principal que permite el desplazamiento vertical.
    Column(
        modifier = modifier
            .padding(contentPadding) // Aplica el relleno del contenido.
            .verticalScroll(rememberScrollState()) // Habilita el desplazamiento vertical.
    ) {
        // Muestra el banner superior de la aplicación.
        FesTopBanner()
        // Itera sobre cada categoría y su lista de recomendaciones.
        listByCategory.forEach {
            // Muestra una columna vertical de recomendaciones para la categoría actual.
            RecommendationsVerticalColumn(
                categoryOption = it.key, // La categoría actual.
                categoryListSize = it.value.size, // El número de recomendaciones en esta categoría.
                recommendationList = it.value, // La lista de recomendaciones para la categoría.
                onRecommendationCardPressed = onRecommendationCardPressed // El manejador de clics para las tarjetas.
            )
        }
    }
}


/**
 * Composable que agrupa un título de categoría y una lista horizontal de recomendaciones.
 *
 * @param categoryOption La opción de categoría para la que se muestran las recomendaciones.
 * @param categoryListSize El número total de lugares en esta categoría.
 * @param recommendationList La lista de [Recommendation] a mostrar en esta sección.
 * @param onRecommendationCardPressed La función lambda que se invoca cuando se presiona una tarjeta.
 * @param modifier Un [Modifier] para aplicar a este composable.
 */
@Composable
fun RecommendationsVerticalColumn(
    categoryOption: CategoryOptions,
    categoryListSize: Int,
    recommendationList: List<Recommendation>,
    onRecommendationCardPressed: (Recommendation) -> Unit,
    modifier: Modifier = Modifier
) {
    // Muestra el título de la categoría y el número de lugares.
    CategoryTitle(
        categoryOption = categoryOption, // La opción de categoría.
        numberOfPlaces = categoryListSize, // El tamaño de la lista de categorías.
        modifier = modifier
            .padding(top = dimensionResource(id = R.dimen.padding_medium)) // Relleno superior.
    )
    // Muestra una lista de recomendaciones con desplazamiento horizontal.
    RecommendationHorizontalList(
        recommendationList = recommendationList, // Las recomendaciones a mostrar.
        onRecommendationCardPressed = onRecommendationCardPressed // El manejador de clics.
    )
}


/**
 * Composable que muestra una lista horizontal de tarjetas de recomendación.
 *
 * Esta lista permite el desplazamiento horizontal y muestra cada recomendación
 * como una [RecommendationCard].
 *
 * @param recommendationList La lista de [Recommendation] a mostrar.
 * @param onRecommendationCardPressed La función lambda que se invoca cuando se presiona una tarjeta.
 * @param modifier Un [Modifier] para aplicar a este composable.
 */
@Composable
fun RecommendationHorizontalList(
    recommendationList: List<Recommendation>,
    onRecommendationCardPressed: (Recommendation) -> Unit,
    modifier: Modifier = Modifier,
) {
    // Fila que permite el desplazamiento horizontal.
    Row(
        horizontalArrangement = Arrangement.SpaceAround, // Organiza los elementos con espacio alrededor.
        modifier = modifier
            .horizontalScroll(rememberScrollState()) // Habilita el desplazamiento horizontal.
    ) {
        // Itera sobre cada recomendación en la lista.
        recommendationList.forEach {
            // Muestra una tarjeta de recomendación individual.
            RecommendationCard(
                recommendation = it, // La recomendación actual.
                onCardClick = { onRecommendationCardPressed(it) }, // El manejador de clics para esta tarjeta.
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_small)) // Relleno alrededor de cada tarjeta.
            )
        }
    }
}



/**
 * Composable que muestra el título de una categoría y el número de lugares asociados.
 *
 * @param categoryOption La opción de categoría a mostrar.
 * @param numberOfPlaces El número de lugares (recomendaciones) en esta categoría.
 * @param modifier Un [Modifier] para aplicar a este composable.
 */
@Composable
fun CategoryTitle(
    categoryOption: CategoryOptions,
    numberOfPlaces: Int,
    modifier: Modifier = Modifier
) {
    // Fila que distribuye el espacio horizontalmente entre el título y el contador de lugares.
    Row(
        horizontalArrangement = Arrangement.SpaceBetween, // Espacio entre los elementos de la fila.
        verticalAlignment = Alignment.CenterVertically, // Alinea verticalmente los elementos al centro.
        modifier = modifier
            .fillMaxWidth() // La fila ocupa todo el ancho disponible.
            .padding(
                dimensionResource(id = R.dimen.padding_small) // Relleno general para la fila.
            )
    ) {
        // Texto para el nombre de la categoría.
        Text(
            text = categoryOption.name, // El nombre de la categoría.
            softWrap = true, // Permite que el texto se envuelva en varias líneas.
            style = MaterialTheme.typography.bodyLarge // Estilo de tipografía.
        )
        // Texto para mostrar el número de lugares.
        Text(
            text = "$numberOfPlaces Places", // Formato del texto.
            softWrap = true, // Permite que el texto se envuelva en varias líneas.
            style = MaterialTheme.typography.bodyMedium // Estilo de tipografía.
        )
    }
}



/**
 * Composable que representa una tarjeta de recomendación clickable.
 *
 * Al hacer clic en la tarjeta, se invoca la función [onCardClick].
 * Contiene una imagen con el nombre de la recomendación superpuesto.
 *
 * @param recommendation El objeto [Recommendation] a mostrar en la tarjeta.
 * @param onCardClick La función lambda que se invoca cuando se hace clic en la tarjeta.
 * @param modifier Un [Modifier] para aplicar a este composable.
 */
@Composable
fun RecommendationCard(
    recommendation: Recommendation,
    onCardClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Componente Card de Material Design.
    Card(
        shape = MaterialTheme.shapes.small, // Forma de la tarjeta.
        modifier = modifier
            .size( // Define el tamaño fijo de la tarjeta.
                height = dimensionResource(id = R.dimen.image_height),
                width = dimensionResource(id = R.dimen.image_width)
            ),
        onClick = onCardClick // Acción al hacer clic en la tarjeta.
    ) {
        // Muestra la imagen de la tarjeta con el nombre de la recomendación.
        ImageCard(
            recommendation = recommendation // La recomendación para la imagen.
        )
    }
}



/**
 * Composable que muestra una imagen con un nombre de recomendación superpuesto en la parte inferior.
 *
 * El nombre de la recomendación tiene un fondo degradado oscuro para mejorar la legibilidad.
 *
 * @param modifier Un [Modifier] para aplicar a este composable.
 * @param recommendation El objeto [Recommendation] que contiene la información de la imagen y el nombre.
 */
@Composable
fun ImageCard(
    modifier: Modifier = Modifier,
    recommendation: Recommendation
) {
    // Un Box permite superponer elementos. Aquí, la imagen es el fondo y el texto se superpone.
    Box(
        contentAlignment = Alignment.BottomStart, // Alinea el contenido (texto) a la parte inferior izquierda.
    ) {
        // Imagen de la recomendación.
        Image(
            painter = painterResource(id = recommendation.imageResourceId), // Carga la imagen desde los recursos.
            contentDescription = null, // No se necesita una descripción de contenido para accesibilidad en este caso.
            modifier = modifier.fillMaxSize(), // La imagen llena todo el tamaño del Box.
            contentScale = ContentScale.Crop, // Escala la imagen para que llene los límites recortando si es necesario.
        )
        // Texto con el nombre de la recomendación superpuesto.
        Text(
            text = recommendation.name, // El nombre de la recomendación.
            color = Color.White, // Color del texto.
            softWrap = true, // Permite que el texto se envuelva en varias líneas.
            style = MaterialTheme.typography.bodyMedium.copy( // Estilo de tipografía.
                lineBreak = LineBreak.Simple // Sugiere un tipo de salto de línea simple.
            ),
            modifier = Modifier
                .fillMaxWidth() // El texto ocupa todo el ancho disponible.
                .background( // Aplica un fondo degradado.
                    brush = Brush.verticalGradient( // Degradado vertical.
                        colors = listOf(
                            Color.Transparent, // Empieza transparente en la parte superior.
                            Color.Black // Termina en negro en la parte inferior.
                        )
                    )
                )
                .padding(dimensionResource(id = R.dimen.padding_small)) // Relleno alrededor del texto.
        )
    }
}