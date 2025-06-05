package com.example.bookshelf
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bookshelf.ui.BookshelfApp
import com.example.bookshelf.ui.theme.BookshelfTheme

// Actividad principal de la app que hereda de ComponentActivity
class MainActivity : ComponentActivity() {
    // Método llamado al crear la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Activa el modo de pantalla completa borde a borde
        enableEdgeToEdge()
        // Establece el contenido Compose de la actividad
        setContent {
            // Aplica el tema personalizado BookshelfTheme a la UI
            BookshelfTheme {
                // Llama al composable principal de la app
                BookshelfApp()
            }
        }
    }
}
