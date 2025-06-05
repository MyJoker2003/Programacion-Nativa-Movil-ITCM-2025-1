package com.example.bookshelf
import android.app.Application
import com.example.bookshelf.data.AppContainer
import com.example.bookshelf.data.DefaultAppContainer

// Clase Application personalizada para inicializar dependencias globales
class BookshelfApplication : Application() {
    // Variable para contener la instancia del contenedor de dependencias
    lateinit var container: AppContainer

    // Método llamado al iniciar la aplicación
    override fun onCreate() {
        super.onCreate()
        // Inicializa el contenedor de dependencias con una implementación por defecto
        container = DefaultAppContainer()
    }
}
