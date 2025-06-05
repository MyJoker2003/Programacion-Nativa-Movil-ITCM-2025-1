package com.example.androidpractices01

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
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.androidpractices01.ui.theme.AndroidPractices01Theme

class MainActivity : ComponentActivity() {
    /*
    ComponentActivity: Clase base que permite el uso de Jetpack
    Compose para construir la UI. Se encarga de administrar los
    estados del ciclo de vida.
    */
    override fun onCreate(savedInstanceState: Bundle?) {
        /*Se sobre escribe y se ejecuta la funcion on create desde la clase ComponentActivity
        * se declara como parametro un objeto de la clase Bundle y se especifica que este puede ser null.
        *
        * Bundle
        * */
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidPractices01Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Surface (color = Color.Gray){
        Text(
            text = "Hello World !!", //Contenido de text
            fontSize = 20.sp, // Tamanio de la letra
            fontWeight = FontWeight.Bold,
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidPractices01Theme {
        Greeting()
    }
}