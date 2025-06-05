package com.nabilbdev.fes.ui
import androidx.activity.compose.BackHandler                         // Para controlar el botón "back" en Compose
import androidx.compose.foundation.background                         // Para aplicar fondo a composables
import androidx.compose.foundation.layout.Box                         // Contenedor que permite apilar elementos
import androidx.compose.foundation.layout.Column                      // Layout vertical para apilar elementos
import androidx.compose.foundation.layout.fillMaxHeight               // Modifier para llenar toda la altura disponible
import androidx.compose.foundation.layout.offset                      // Modifier para desplazar un composable en X/Y
import androidx.compose.foundation.layout.padding                     // Modifier para agregar padding interno
import androidx.compose.foundation.layout.size                        // Modifier para establecer tamaño
import androidx.compose.foundation.layout.wrapContentWidth            // Modifier para ajustar ancho al contenido
import androidx.compose.foundation.rememberScrollState                // Para guardar estado del scroll
import androidx.compose.foundation.shape.CircleShape                   // Forma circular para recortar elementos
import androidx.compose.foundation.verticalScroll                     // Hacer que una columna sea scrollable verticalmente
import androidx.compose.material3.Icon                                // Componente icono material3
import androidx.compose.material3.MaterialTheme                       // Para usar colores y estilos del tema
import androidx.compose.material3.NavigationBar                       // Barra de navegación inferior (material3)
import androidx.compose.material3.NavigationBarItem                   // Elemento dentro de NavigationBar
import androidx.compose.material3.NavigationBarItemColors             // Colores para NavigationBarItem
import androidx.compose.material3.NavigationRail                      // Barra lateral de navegación (material3)
import androidx.compose.material3.Scaffold                            // Estructura básica con topBar, bottomBar y content
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass  // Para clasificar tamaño de ventana (Compact, Medium, Expanded)
import androidx.compose.runtime.Composable                            // Para funciones composables
import androidx.compose.runtime.collectAsState                       // Para convertir Flow en estado Compose
import androidx.compose.runtime.getValue                              // Para delegados "by"
import androidx.compose.ui.Alignment                                  // Para alinear elementos
import androidx.compose.ui.Modifier                                   // Para modificar apariencia o comportamiento
import androidx.compose.ui.draw.clip                                  // Para recortar con forma (clip)
import androidx.compose.ui.graphics.Color                            // Para usar colores
import androidx.compose.ui.res.dimensionResource                      // Para obtener dimensiones desde recursos
import androidx.compose.ui.res.painterResource                        // Para cargar imágenes vectoriales o drawables
import androidx.compose.ui.unit.dp                                    // Para unidades de medida (dp)
import androidx.lifecycle.viewmodel.compose.viewModel                 // Para obtener ViewModel en Compose
import androidx.navigation.NavGraph.Companion.findStartDestination    // Para encontrar el destino inicial del NavGraph
import androidx.navigation.compose.NavHost                            // Contenedor para la navegación Compose
import androidx.navigation.compose.composable                         // Para definir rutas composables en NavHost
import androidx.navigation.compose.currentBackStackEntryAsState      // Para obtener la entrada actual en el backstack
import androidx.navigation.compose.rememberNavController              // Para crear NavController en Compose
import com.nabilbdev.fes.R                                            // Recursos del proyecto (dimensiones, drawables, etc.)
import com.nabilbdev.fes.data.model.Recommendation                    // Modelo Recommendation para datos de recomendaciones
import com.nabilbdev.fes.ui.navigation.FesAppScreens                  // Enum o sealed class con pantallas de la app
import com.nabilbdev.fes.ui.navigation.navItemList                    // Lista de items para navegación
import com.nabilbdev.fes.ui.screens.bars.FesTopAppBar                 // Composable para la barra superior personalizada
import com.nabilbdev.fes.ui.screens.bars.NavRail                      // Composable para items en NavigationRail
import com.nabilbdev.fes.ui.screens.category.HotelCategoryScreen      // Pantalla para categoría Hotel
import com.nabilbdev.fes.ui.screens.category.LandmarkCategoryScreen   // Pantalla para categoría Landmark
import com.nabilbdev.fes.ui.screens.category.RestaurantCategoryScreen // Pantalla para categoría Restaurant
import com.nabilbdev.fes.ui.screens.feed.FeedScreen                    // Pantalla principal Feed
import com.nabilbdev.fes.ui.screens.recommendation.RecommendationScreen // Pantalla para detalle de recomendación
import com.nabilbdev.fes.ui.utils.FesNavigationType                    // Enum con tipos de navegación (BottomNav, NavRail, SplitNavRail)
import com.nabilbdev.fes.ui.viewmodel.FesViewModel                     // ViewModel principal

@Composable
fun FesApp(
    windowSize: WindowWidthSizeClass  // Parámetro que indica el tamaño de ventana para adaptar UI
) {

    val navController = rememberNavController()  // Controlador de navegación para Compose
    val backStackEntry by navController.currentBackStackEntryAsState() // Estado de la entrada actual del backstack
    val currentScreen = backStackEntry?.destination?.route ?: FesAppScreens.Feed.title
    // Obtiene la ruta de la pantalla actual o por defecto "Feed"

    val viewModel: FesViewModel = viewModel()    // Obtiene el ViewModel usando Compose
    val fesUiState by viewModel.uiState.collectAsState()  // Observa el estado UI como Compose State
    val currentRecommendation = fesUiState.currentSelectedRecommendation // Recomendación seleccionada actualmente

    // Define el tipo de navegación según el tamaño de la ventana
    val navigationType = when (windowSize) {
        WindowWidthSizeClass.Compact -> FesNavigationType.BOTTOM_NAVIGATION
        WindowWidthSizeClass.Medium -> FesNavigationType.NAVIGATION_RAIL
        WindowWidthSizeClass.Expanded -> FesNavigationType.SPLIT_NAV_RAIL
        else -> FesNavigationType.BOTTOM_NAVIGATION
    }

    Scaffold(
        topBar = {
            if (navigationType == FesNavigationType.BOTTOM_NAVIGATION) {
                FesTopAppBar(
                    currentScreen = currentScreen  // Muestra barra superior sólo si es navegación inferior
                )
            }
        },
        bottomBar = {
            if (navigationType == FesNavigationType.BOTTOM_NAVIGATION) {
                NavigationBar(           // Barra inferior de navegación
                    containerColor = Color.White,
                    tonalElevation = dimensionResource(id = R.dimen.padding_default)
                ) {
                    // Itera sobre cada item de navegación para crear los botones
                    navItemList.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = viewModel.isSelectingBottomNavItem(index),  // Selecciona el item según ViewModel
                            onClick = {
                                // Al pulsar un item actualiza estado y navega a la ruta correspondiente
                                viewModel
                                    .pickBottomNavItemAndUpdateGridListScreens(
                                        index = index,
                                        categoryOptions = item.route.uppercase()
                                    )
                                navController.navigate(item.route) {
                                    // Configura comportamiento para evitar múltiples instancias y guardar estado
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            icon = {
                                // Caja circular que rodea el icono, cambia color si está seleccionado
                                Box(
                                    modifier = Modifier
                                        .size(dimensionResource(id = R.dimen.icon_border_size))
                                        .clip(CircleShape)
                                        .background(
                                            color = if (viewModel.isSelectingBottomNavItem(index)) Color.Black else Color.Transparent
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        painter = painterResource(id = item.icon), // Icono del item
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(dimensionResource(id = R.dimen.icon_size))
                                            .padding(dimensionResource(id = R.dimen.padding_small))
                                    )
                                }
                            },
                            colors = NavigationBarItemColors(  // Colores personalizados para iconos y textos (transparentes para textos)
                                selectedIconColor = Color.White,
                                unselectedIconColor = Color.Black,
                                selectedIndicatorColor = Color.Transparent,
                                selectedTextColor = Color.Transparent,
                                unselectedTextColor = Color.Transparent,
                                disabledIconColor = Color.Transparent,
                                disabledTextColor = Color.Transparent
                            )
                        )
                    }
                }
            }
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = currentScreen,      // Pantalla inicial es la pantalla actual (por seguridad)
            modifier = when (navigationType) {     // Aplica padding a NavHost si hay NavigationRail
                FesNavigationType.NAVIGATION_RAIL, FesNavigationType.SPLIT_NAV_RAIL -> Modifier.padding(
                    start = 95.dp
                )
                else -> Modifier.padding(0.dp)
            },
        ) {
            // Definición de rutas y pantallas composables para navegación
            composable(route = FesAppScreens.Feed.title) {
                FeedScreen(
                    listByCategory = fesUiState.recommendationLists.entries.toList(),  // Lista de recomendaciones agrupadas
                    onRecommendationCardPressed = { recommendation: Recommendation ->  // Acción al pulsar una recomendación
                        viewModel.updateAndSelectDetailScreen(recommendation)
                    },
                    contentPadding = innerPadding
                )
            }
            composable(route = FesAppScreens.Landmark.title) {
                LandmarkCategoryScreen(
                    landmarksList = fesUiState.currentRecommendationList,  // Lista actual de landmarks
                    onRecommendationCardPressed = { recommendation: Recommendation ->
                        viewModel.updateAndSelectDetailScreen(recommendation)
                    },
                    contentPadding = innerPadding
                )
            }
            composable(route = FesAppScreens.Restaurant.title) {
                RestaurantCategoryScreen(
                    restaurantsList = fesUiState.currentRecommendationList,  // Lista actual de restaurantes
                    onRecommendationCardPressed = { recommendation: Recommendation ->
                        viewModel.updateAndSelectDetailScreen(recommendation)
                    },
                    contentPadding = innerPadding
                )
            }
            composable(route = FesAppScreens.Hotel.title) {
                HotelCategoryScreen(
                    hotelsList = fesUiState.currentRecommendationList,  // Lista actual de hoteles
                    onRecommendationCardPressed = { recommendation: Recommendation ->
                        viewModel.updateAndSelectDetailScreen(recommendation)
                    },
                    contentPadding = innerPadding
                )
            }
        }
    }

    // Si no se está mostrando el feed principal, muestra pantalla detalle de recomendación
    if (!fesUiState.isShowingFeed) {
        RecommendationScreen(
            recommendation = currentRecommendation,          // Recomendación seleccionada
            onBackButtonClicked = {                          // Acción al pulsar botón atrás
                viewModel.hideDetailScreen()
            },
            stars = viewModel.updateReviewStars(recommendation = currentRecommendation),  // Estrellas de valoración
            navigationType = navigationType                  // Tipo de navegación para ajustar UI
        )
        // Manejo del botón atrás nativo para ocultar la pantalla de detalle
        BackHandler(
            enabled = true,
            onBack = {
                viewModel.hideDetailScreen()
            }
        )
    }

    // Comportamiento de navegación lateral para tamaños Medium y Expanded
    when (navigationType) {

        FesNavigationType.NAVIGATION_RAIL, FesNavigationType.SPLIT_NAV_RAIL -> {
            NavigationRail(
                containerColor = Color.White,           // Color de fondo blanco para la barra lateral
                modifier = Modifier
                    .wrapContentWidth(align = Alignment.Start)  // Ajusta ancho al contenido, alineado al inicio
                    .background(MaterialTheme.colorScheme.inverseOnSurface)  // Fondo según tema
                    .offset((-1).dp)                  // Pequeño desplazamiento para corregir borde
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()               // Ocupa toda la altura disponible
                        .verticalScroll(rememberScrollState()) // Permite scroll vertical en la columna
                ) {
                    navItemList.forEachIndexed { index, item ->
                        NavRail(
                            selected = viewModel.isSelectingBottomNavItem(index),  // Indica si está seleccionado
                            onNavItemClicked = {
                                viewModel.hideDetailScreen()      // Oculta pantalla detalle
                                viewModel
                                    .pickBottomNavItemAndUpdateGridListScreens(
                                        index = index,
                                        categoryOptions = item.route.uppercase()
                                    )
                                navController.navigate(item.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            icon = painterResource(id = item.icon),  // Icono de item
                            label = item.label                         // Texto de item
                        )
                    }
                }
            }
        }

        else -> {
            // En otros casos (p.ej BottomNavigation) no hace nada aquí porque ya se maneja arriba
        }
    }
}
