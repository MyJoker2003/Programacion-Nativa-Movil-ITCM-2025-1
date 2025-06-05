package com.example.bookshelf.data
import com.example.bookshelf.network.BookshelfApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Interfaz que define un contenedor de dependencias con un repositorio
interface AppContainer {
    val repository: BookshelfRepository
}

// Implementación por defecto del contenedor de dependencias
class DefaultAppContainer : AppContainer {
    // URL base para las peticiones a la API de Google Books
    private val BASE_URL = "https://www.googleapis.com/books/v1/volumes/"

    // Configura Retrofit con Gson para manejar la comunicación HTTP con la API
    val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    // Servicio de Retrofit para definir los endpoints de la API, creado perezosamente
    private val retrofitService: BookshelfApiService by lazy {
        retrofit.create(BookshelfApiService::class.java)
    }

    // Repositorio que maneja la lógica de datos, usando el servicio Retrofit, creado perezosamente
    override val repository: BookshelfRepository by lazy {
        NetworkBookshelfRepository(retrofitService)
    }
}
