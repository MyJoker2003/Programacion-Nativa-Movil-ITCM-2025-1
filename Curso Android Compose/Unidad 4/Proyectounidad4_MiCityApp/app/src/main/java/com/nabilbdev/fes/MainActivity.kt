package com.nabilbdev.fes

import android.os.Bundle                                  // Import para Bundle, usado en el ciclo de vida de Android
import androidx.activity.ComponentActivity               // Clase base para actividades que usan Jetpack Compose
import androidx.activity.compose.setContent               // Función para establecer contenido Compose en Activity
import androidx.compose.foundation.layout.fillMaxSize      // Modifier para que un componente llene todo el espacio disponible
import androidx.compose.material3.MaterialTheme.colorScheme  // Para acceder a la paleta de colores del tema material3
import androidx.compose.material3.Surface                   // Componente Surface que representa una superficie UI con fondo y forma
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi  // Anotación para APIs experimentales
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass  // Enum para clases de tamaño de ventana (Compact, Medium, Expanded)
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass  // Función para calcular tamaño de ventana actual
import androidx.compose.runtime.Composable                 // Anotación para funciones composables
import androidx.compose.ui.Modifier                         // Para modificar apariencia o comportamiento de composables
import androidx.compose.ui.tooling.preview.Devices          // Dispositivos predefinidos para preview en Android Studio
import androidx.compose.ui.tooling.preview.Preview          // Anotación para previews de composables en Android Studio
import com.nabilbdev.fes.ui.FesApp                         // Composable principal de la app (definido en otro archivo)
import com.nabilbdev.fes.ui.theme.FesTheme                 // Tema personalizado para la app

/**
 * Actividad principal de la aplicación FES.
 *
 * Esta clase extiende [ComponentActivity] y es el punto de entrada para la interfaz de usuario
 * construida con Jetpack Compose. Configura el tema de la aplicación y maneja
 * la determinación del tamaño de la ventana para adaptar la UI a diferentes dispositivos.
 */
class MainActivity : ComponentActivity() {
    /**
     * Se anota con [OptIn] para indicar el uso de APIs experimentales relacionadas con el cálculo
     * del tamaño de la ventana de Material 3.
     */
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Llama al método onCreate de la superclase.

        // Establece el contenido de la UI utilizando Jetpack Compose.
        setContent {
            // Aplica el tema personalizado 'FesTheme' a toda la jerarquía de UI.
            FesTheme {
                // 'Surface' es un componente de UI que proporciona un fondo y una elevación.
                Surface(
                    modifier = Modifier.fillMaxSize(), // El modificador 'fillMaxSize' hace que 'Surface' ocupe todo el espacio disponible.
                    color = colorScheme.background // El color de fondo se obtiene del esquema de colores del tema.
                ) {
                    // Calcula la clase de tamaño de la ventana actual para una UI responsiva.
                    val windowSize = calculateWindowSizeClass(activity = this)

                    // Pasa la clase de tamaño de ancho de la ventana a la función composable principal de la aplicación.
                    FesApp(
                        windowSize = windowSize.widthSizeClass
                    )
                }
            }
        }
    }
}

// Previews para facilitar el diseño y pruebas desde Android Studio sin emular dispositivo real

/**
 * Vista previa para dispositivos con un ancho de pantalla 'Compact'.
 * Utilizada para teléfonos en orientación vertical.
 * @param showBackground Indica si se debe mostrar un fondo en la vista previa.
 */
@Preview(showBackground = true)
@Composable
fun FesAppCompactPreview() {
    FesTheme { // Aplica el tema de la aplicación a la vista previa.
        FesApp(
            windowSize = WindowWidthSizeClass.Compact // Simula un tamaño de ventana compacto.
        )
    }
}

/**
 * Vista previa para dispositivos con un ancho de pantalla 'Medium'.
 *
 * Adecuada para tablets pequeñas, plegables o teléfonos grandes en orientación horizontal.
 * @param device Especifica el tipo de dispositivo para la vista previa, en este caso, un dispositivo plegable.
 * @param showSystemUi Indica si se deben mostrar los elementos de la interfaz de usuario del sistema (barra de estado, etc.).
 */
@Preview(device = Devices.FOLDABLE, showSystemUi = true)
@Composable
fun FesAppMediumPreview() {
    FesTheme { // Aplica el tema de la aplicación a la vista previa.
        FesApp(
            windowSize = WindowWidthSizeClass.Medium // Simula un tamaño de ventana mediano.
        )
    }
}

/**
 * Vista previa para dispositivos con un ancho de pantalla 'Expanded'.
 *
 * Para tablets grandes o dispositivos de escritorio.
 * @param device Especifica el tipo de dispositivo para la vista previa, en este caso, un escritorio.
 * @param showSystemUi Indica si se deben mostrar los elementos de la interfaz de usuario del sistema (barra de estado, etc.).
 */
@Preview(device = Devices.DESKTOP, showSystemUi = true)
@Composable
fun FesAppExpandedPreview() {
    FesTheme { // Aplica el tema de la aplicación a la vista previa.
        FesApp(
            windowSize = WindowWidthSizeClass.Expanded // Simula un tamaño de ventana expandido.
        )
    }
}
