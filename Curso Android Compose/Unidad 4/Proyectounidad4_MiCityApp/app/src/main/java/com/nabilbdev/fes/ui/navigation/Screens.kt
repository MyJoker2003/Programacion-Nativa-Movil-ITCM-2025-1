package com.nabilbdev.fes.ui.navigation

/**
 * Enumera las diferentes pantallas (o destinos de navegación) disponibles en la aplicación FES.
 *
 * Cada constante de este enum representa una pantalla única y asocia un título con ella.
 * Este título puede ser utilizado para la barra superior, la navegación, o como identificador.
 *
 * @property title El título descriptivo de la pantalla, que también sirve como su ruta de navegación.
 */
enum class FesAppScreens(val title: String) {
    /**
     * Representa la pantalla principal o de 'Feed'.
     * El título asociado es "Fes".
     */
    Feed("Fes"),

    /**
     * Representa la pantalla de 'Puntos de Interés' (Landmarks).
     * El título asociado es "Landmarks".
     */
    Landmark("Landmarks"),

    /**
     * Representa la pantalla de 'Hoteles'.
     * El título asociado es "Hotels".
     */
    Hotel("Hotels"),

    /**
     * Representa la pantalla de 'Restaurantes'.
     * El título asociado es "Restaurants".
     */
    Restaurant("Restaurants"),
}