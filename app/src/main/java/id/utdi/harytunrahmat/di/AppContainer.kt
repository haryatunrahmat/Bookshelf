package id.utdi.harytunrahmat.di

import id.utdi.harytunrahmat.data.BookshelfRepository
import id.utdi.harytunrahmat.network.BookshelfApiService

/**
 * Dependency Injection container at the application level.
 */
interface AppContainer {
    // Properti untuk menyediakan instance dari layanan API BookshelfApiService.
    val bookshelfApiService: BookshelfApiService

    // Properti untuk menyediakan instance dari repositori BookshelfRepository.
    val bookshelfRepository: BookshelfRepository
}