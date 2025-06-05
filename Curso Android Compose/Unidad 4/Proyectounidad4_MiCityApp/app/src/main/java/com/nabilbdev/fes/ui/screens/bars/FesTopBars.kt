package com.nabilbdev.fes.ui.screens.bars

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.nabilbdev.fes.R


/**
 * Composable que representa la barra superior de la aplicación FES.
 *
 * Esta barra superior está centrada y muestra el título de la pantalla actual.
 *
 * @param currentScreen El título de la pantalla actual que se mostrará en la barra superior.
 * @param modifier Un [Modifier] para aplicar a este composable.
 */
@OptIn(ExperimentalMaterial3Api::class) // Se utiliza una API experimental de Material 3 para TopAppBar.
@Composable
fun FesTopAppBar(
    currentScreen: String,
    modifier: Modifier = Modifier
) {
    // Componente de barra superior centrada.
    CenterAlignedTopAppBar(
        title = {
            // Texto que muestra el título de la pantalla actual con un estilo de tipografía de encabezado grande.
            Text(
                text = currentScreen,
                style = MaterialTheme.typography.headlineLarge
            )
        },
        modifier = modifier,
    )
}


/**
 * Composable que muestra un banner en la parte superior de la pantalla,
 * ideal para secciones de 'feed' o introducción.
 *
 * Consiste en una [Card] que contiene una [Row] con dos columnas:
 * una para texto descriptivo y otra para una imagen.
 */
@Composable
fun FesTopBanner() {
    // Una Card de Material Design con esquinas redondeadas.
    Card(
        shape = MaterialTheme.shapes.medium, // Aplica un shape mediano definido en el tema.
        modifier = Modifier
            .fillMaxWidth() // La tarjeta ocupa todo el ancho disponible.
            .height(dimensionResource(id = R.dimen.image_height)) // Altura fija definida en los recursos.
            .padding( // Relleno alrededor de la tarjeta.
                start = dimensionResource(id = R.dimen.padding_small),
                top = dimensionResource(id = R.dimen.padding_medium),
                end = dimensionResource(id = R.dimen.padding_small),
                bottom = dimensionResource(id = R.dimen.padding_medium)
            )
    ) {
        // Una fila que organiza sus elementos con espacio alrededor.
        Row(
            horizontalArrangement = Arrangement.SpaceAround, // Espacio equitativo entre los elementos hijos.
            modifier = Modifier
                .fillMaxWidth() // La fila ocupa todo el ancho de la tarjeta.
                .padding(dimensionResource(id = R.dimen.padding_small)), // Relleno interno de la fila.
        ) {
            // Columna para el contenido de texto.
            Column(
                modifier = Modifier
                    .weight(1f), // Ocupa un peso de 1f, compartiendo espacio con la imagen.
                horizontalAlignment = Alignment.CenterHorizontally, // Centra el contenido horizontalmente.
                verticalArrangement = Arrangement.SpaceEvenly // Distribuye el espacio verticalmente de manera uniforme.
            ) {
                // Título del banner.
                Text(
                    text = stringResource(id = R.string.feed_top_title), // Texto obtenido de recursos.
                    softWrap = true, // Permite que el texto se envuelva en varias líneas.
                    textAlign = TextAlign.Justify, // Justifica el texto.
                    style = MaterialTheme.typography.bodyLarge.copy( // Estilo de tipografía.
                        lineBreak = LineBreak.Heading // Sugiere un tipo de salto de línea para encabezados.
                    )
                )
                // Descripción del banner.
                Text(
                    text = stringResource(id = R.string.feed_top_description), // Texto obtenido de recursos.
                    softWrap = true, // Permite que el texto se envuelva en varias líneas.
                    textAlign = TextAlign.Left, // Alinea el texto a la izquierda.
                    overflow = TextOverflow.Clip, // Corta el texto si excede los límites.
                    style = MaterialTheme.typography.bodySmall.copy( // Estilo de tipografía.
                        lineBreak = LineBreak.Paragraph // Sugiere un tipo de salto de línea para párrafos.
                    ),
                    modifier = Modifier.padding( // Relleno específico para la descripción.
                        bottom = dimensionResource(id = R.dimen.padding_very_small),
                        top = dimensionResource(id = R.dimen.padding_very_small),
                        start = dimensionResource(id = R.dimen.padding_small),
                        end = dimensionResource(id = R.dimen.padding_small)
                    )
                )
            }
            // Imagen del banner.
            Image(
                painter = painterResource(id = R.drawable.fes_banner), // Carga la imagen desde recursos.
                contentDescription = null, // No se necesita descripción de contenido para accesibilidad en este caso.
                modifier = Modifier
                    .clip(MaterialTheme.shapes.medium) // Recorta la imagen con el mismo shape que la tarjeta.
                    .weight(1f), // Ocupa un peso de 1f, compartiendo espacio con el texto.
                contentScale = ContentScale.Crop // Escala la imagen para que llene los límites recortando si es necesario.
            )
        }
    }
}