package com.nabilbdev.fes.ui.screens.bars

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.dimensionResource
import com.nabilbdev.fes.R


/**
 * Composable que representa un elemento de la barra de navegación lateral (Navigation Rail).
 *
 * Este componente es ideal para pantallas de ancho medio o grande, donde la navegación
 * principal se muestra verticalmente al costado del contenido.
 *
 * @param selected Indica si este elemento de navegación está actualmente seleccionado.
 * @param onNavItemClicked La función lambda que se invoca cuando se hace clic en el elemento.
 * @param icon El [Painter] del icono a mostrar para el elemento.
 * @param label El texto de la etiqueta que acompaña al icono.
 * @param modifier Un [Modifier] para aplicar a este composable.
 */
@Composable
fun NavRail(
    selected: Boolean,
    onNavItemClicked: () -> Unit,
    icon: Painter,
    label: String,
    modifier: Modifier = Modifier
) {
    // Componente principal de un elemento de Navigation Rail.
    NavigationRailItem(
        selected = selected, // Estado de selección del elemento.
        onClick = onNavItemClicked, // Manejador de clics.
        icon = {
            // Un Box para aplicar un fondo circular al icono cuando está seleccionado.
            Box(
                modifier = modifier
                    .size(dimensionResource(id = R.dimen.icon_border_size)) // Define el tamaño del contenedor del icono.
                    .clip(CircleShape) // Recorta el Box en forma de círculo.
                    .background( // Cambia el color de fondo según el estado de selección.
                        color = when (selected) {
                            true -> Color.Black // Fondo negro si está seleccionado.
                            else -> Color.Transparent // Fondo transparente si no está seleccionado.
                        },
                    ),
                contentAlignment = Alignment.Center, // Centra el contenido (el icono) dentro del Box.
            ) {
                // Icono del elemento de navegación.
                Icon(
                    painter = icon, // El objeto Painter para dibujar el icono.
                    contentDescription = null, // No se necesita una descripción de contenido para accesibilidad aquí.
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.icon_size)) // Tamaño del icono.
                        .padding(dimensionResource(id = R.dimen.padding_small)) // Relleno interno del icono.
                )
            }
        },
        label = {
            // Texto de la etiqueta del elemento de navegación.
            Text(
                text = label, // El texto a mostrar.
                style = MaterialTheme.typography.bodySmall, // Estilo de tipografía.
                color = if (selected) Color.Black else Color.Transparent, // Color del texto: negro si seleccionado, transparente si no.
                modifier = Modifier.padding(
                    bottom = dimensionResource(id = R.dimen.padding_very_small) // Pequeño relleno en la parte inferior.
                )
            )
        },
        // Configuración de colores personalizada para el elemento de Navigation Rail.
        colors = NavigationRailItemColors(
            selectedIconColor = Color.White, // Color del icono cuando está seleccionado.
            unselectedIconColor = Color.Black, // Color del icono cuando no está seleccionado.
            selectedIndicatorColor = Color.Transparent, // Color del indicador de selección (transparente para ocultarlo).
            selectedTextColor = Color.Transparent, // Color del texto cuando está seleccionado (transparente para ocultarlo, ya que el color se maneja en el Text composable).
            unselectedTextColor = Color.Transparent, // Color del texto cuando no está seleccionado (transparente para ocultarlo).
            disabledIconColor = Color.Transparent, // Color del icono cuando está deshabilitado.
            disabledTextColor = Color.Transparent // Color del texto cuando está deshabilitado.
        )
    )
}


/**
 * Composable que representa un elemento de un cajón de navegación permanente (Permanent Navigation Drawer).
 *
 * Este componente es adecuado para pantallas muy grandes, donde el cajón de navegación
 * siempre está visible en el lado de la pantalla.
 *
 * @param selected Indica si este elemento de navegación está actualmente seleccionado.
 * @param onNavItemClicked La función lambda que se invoca cuando se hace clic en el elemento.
 * @param icon El [Painter] del icono a mostrar para el elemento.
 * @param label El texto de la etiqueta que acompaña al icono.
 * @param modifier Un [Modifier] para aplicar a este composable.
 */
@Composable
fun PermanentNavDrawer(
    selected: Boolean,
    onNavItemClicked: () -> Unit,
    icon: Painter,
    label: String,
    modifier: Modifier = Modifier
) {
    // Componente principal de un elemento de Navigation Drawer.
    NavigationDrawerItem(
        selected = selected, // Estado de selección del elemento.
        onClick = onNavItemClicked, // Manejador de clics.
        icon = {
            // Un Box para aplicar un fondo circular al icono cuando está seleccionado.
            Box(
                modifier = modifier
                    .size(dimensionResource(id = R.dimen.icon_border_size)) // Define el tamaño del contenedor del icono.
                    .clip(CircleShape) // Recorta el Box en forma de círculo.
                    .background( // Cambia el color de fondo según el estado de selección.
                        color = when (selected) {
                            true -> Color.Black // Fondo negro si está seleccionado.
                            else -> Color.Transparent // Fondo transparente si no está seleccionado.
                        },
                    ),
                contentAlignment = Alignment.Center // Centra el contenido (el icono) dentro del Box.
            ) {
                // Icono del elemento de navegación.
                Icon(
                    painter = icon, // El objeto Painter para dibujar el icono.
                    contentDescription = null, // No se necesita una descripción de contenido para accesibilidad aquí.
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.icon_size)) // Tamaño del icono.
                        .padding(dimensionResource(id = R.dimen.padding_small)) // Relleno interno del icono.
                )
            }
        },
        label = {
            // Texto de la etiqueta del elemento de navegación.
            Text(
                text = label, // El texto a mostrar.
                style = MaterialTheme.typography.bodyMedium, // Estilo de tipografía.
                color = Color.Black, // El color del texto siempre es negro.
                modifier = Modifier.padding(
                    bottom = dimensionResource(id = R.dimen.padding_very_small) // Pequeño relleno en la parte inferior.
                )
            )
        },
        // Configuración de colores personalizada para el elemento de Navigation Drawer.
        colors = NavigationDrawerItemDefaults.colors(
            selectedIconColor = Color.White, // Color del icono cuando está seleccionado.
            unselectedIconColor = Color.Black, // Color del icono cuando no está seleccionado.
            selectedTextColor = Color.Transparent, // Color del texto cuando está seleccionado (transparente para ocultarlo).
            unselectedTextColor = Color.Transparent, // Color del texto cuando no está seleccionado (transparente para ocultarlo).
        )
    )
}