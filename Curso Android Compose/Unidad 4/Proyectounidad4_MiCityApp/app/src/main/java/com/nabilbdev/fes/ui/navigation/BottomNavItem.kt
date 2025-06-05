package com.nabilbdev.fes.ui.navigation

import androidx.compose.runtime.Stable
import com.nabilbdev.fes.R

/**
 * Representa un elemento de navegación para la barra de navegación inferior (Bottom Navigation Bar).
 *
 * @param route La ruta de navegación asociada a este elemento. Se utiliza para la navegación
 * entre pantallas.
 * @param label La etiqueta de texto que se muestra para este elemento en la UI.
 * @param icon El ID del recurso drawable que se usará como icono para este elemento.
 */
@Stable // Indica que esta clase es estable para optimizaciones de Compose.
data class BottomNavItem(
    val route: String,
    val label: String,
    val icon: Int
)


/**
 * Lista predefinida de elementos de navegación para la barra de navegación inferior de la aplicación FES.
 *
 * Cada elemento define una ruta, una etiqueta de visualización y un icono asociado.
 */
val navItemList = listOf(
    // Elemento para la pantalla principal (Feed).
    BottomNavItem(
        route = FesAppScreens.Feed.title, // La ruta se obtiene del título de la pantalla Feed.
        label = "Home", // Etiqueta visible en la UI.
        icon = R.drawable.feed // Icono asociado al Feed.
    ),
    // Elemento para la pantalla de puntos de interés (Landmark).
    BottomNavItem(
        route = FesAppScreens.Landmark.title, // La ruta se obtiene del título de la pantalla Landmark.
        label = "Land", // Etiqueta visible en la UI.
        icon = R.drawable.emoji_flags, // Icono asociado a Landmark.
    ),
    // Elemento para la pantalla de hoteles (Hotel).
    BottomNavItem(
        route = FesAppScreens.Hotel.title, // La ruta se obtiene del título de la pantalla Hotel.
        label = "Hotel", // Etiqueta visible en la UI.
        icon = R.drawable.hotel, // Icono asociado a Hotel.
    ),
    // Elemento para la pantalla de restaurantes (Restaurant).
    BottomNavItem(
        route = FesAppScreens.Restaurant.title, // La ruta se obtiene del título de la pantalla Restaurant.
        label = "Resto", // Etiqueta visible en la UI.
        icon = R.drawable.restaurant, // Icono asociado a Restaurant.
    )
)