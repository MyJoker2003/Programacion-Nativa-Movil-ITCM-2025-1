
package com.example.affirmations.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// Define el esquema de colores para el tema oscuro con colores personalizados.
private val DarkColorScheme = darkColorScheme(
    surfaceVariant = md_theme_dark_surfaceVariant,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant,
    background = md_theme_dark_background
)

// Define el esquema de colores para el tema claro con colores personalizados.
private val LightColorScheme = lightColorScheme(
    surfaceVariant = md_theme_light_surfaceVariant,
    onSurfaceVariant = md_theme_light_onSurfaceVariant,
    background = md_theme_light_background
)

/**
 * [AffirmationsTheme] es un composable que aplica el tema de Material Design a la interfaz de usuario de la aplicación.
 * Permite cambiar entre un tema claro y oscuro, y opcionalmente soporta colores dinámicos en dispositivos Android 12+.
 *
 * @param darkTheme Determina si el tema oscuro debe ser aplicado. Por defecto, usa la configuración del sistema.
 * @param dynamicColor Si es `true`, intenta usar colores dinámicos basados en el fondo de pantalla del usuario en Android 12 (API 31) o superior.
 * @param content El contenido de la interfaz de usuario al que se aplicará este tema.
 */
@Composable
fun AffirmationsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(), // Detecta si el sistema está en modo oscuro por defecto.
    dynamicColor: Boolean = false, // Controla si se deben usar colores dinámicos (Android 12+).
    content: @Composable () -> Unit // El contenido Composable que recibe el tema.
) {
    // Selecciona el esquema de color a usar:
    // 1. Si `dynamicColor` es verdadero y la versión de Android es S (API 31) o superior, usa colores dinámicos.
    // 2. Si `darkTheme` es verdadero, usa el esquema de colores predefinido para el tema oscuro.
    // 3. De lo contrario, usa el esquema de colores predefinido para el tema claro.
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val view = LocalView.current // Obtiene la vista actual.

    // Ejecuta un efecto secundario si no estamos en modo de edición (ej. en un preview de Android Studio).
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            // Establece el color de la barra de estado al color de fondo definido en el esquema de colores.
            window.statusBarColor = colorScheme.background.toArgb()
            // Ajusta la apariencia de los íconos de la barra de estado (claro u oscuro) para que contrasten con el fondo.
            // Si el tema es oscuro, los íconos deben ser claros; si el tema es claro, los íconos deben ser oscuros.
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    // Aplica el esquema de colores y el contenido dentro del MaterialTheme.
    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
