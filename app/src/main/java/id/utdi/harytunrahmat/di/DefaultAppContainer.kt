package id.utdi.harytunrahmat.di

import id.utdi.harytunrahmat.data.BookshelfRepository
import id.utdi.harytunrahmat.data.DefaultBookshelfRepository
import id.utdi.harytunrahmat.network.BookshelfApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class DefaultAppContainer : AppContainer {
    // Properti untuk menyediakan instance dari layanan API BookshelfApiService.
    override val bookshelfApiService: BookshelfApiService by lazy {
        // Mengonfigurasi dan membangun objek Retrofit untuk berkomunikasi dengan API Bookshelf.
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BookshelfApiService.BASE_URL)
            .build()
            // Membuat instance dari layanan API BookshelfApiService menggunakan Retrofit.
            .create()
    }

    // Properti untuk menyediakan instance dari repositori BookshelfRepository.
    override val bookshelfRepository: BookshelfRepository by lazy {
        // Membuat instance dari repositori DefaultBookshelfRepository dengan menyediakan layanan API BookshelfApiService.
        DefaultBookshelfRepository(bookshelfApiService)
    }
}
