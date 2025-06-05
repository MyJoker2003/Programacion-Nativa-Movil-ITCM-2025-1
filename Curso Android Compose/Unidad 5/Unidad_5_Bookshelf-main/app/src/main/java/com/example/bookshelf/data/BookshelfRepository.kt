package com.example.bookshelf.data

import com.example.bookshelf.model.BooksList
import com.example.bookshelf.network.BookshelfApiService

// Interfaz que define las operaciones del repositorio para obtener datos de libros
interface BookshelfRepository {
    // Función suspendida para obtener la lista de libros (operación asíncrona)
    suspend fun getBooksData(): BooksList
}

// Implementación del repositorio que obtiene datos a través de la red usando BookshelfApiService
class NetworkBookshelfRepository(
    private val bookshelfApiService: BookshelfApiService
) : BookshelfRepository {
    // Obtiene la lista de libros llamando al servicio API
    override suspend fun getBooksData(): BooksList = bookshelfApiService.getBooksData()
}
