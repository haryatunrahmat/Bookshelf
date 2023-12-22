package id.utdi.harytunrahmat.ui.screens.detail_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import id.utdi.harytunrahmat.BookshelfApplication
import id.utdi.harytunrahmat.data.BookshelfRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

// Kelas DetailsViewModel adalah turunan dari ViewModel dan bertanggung jawab untuk menangani logika bisnis tampilan detail buku.
class DetailsViewModel(
    private val bookshelfRepository: BookshelfRepository
) : ViewModel() {

    // MutableStateFlow digunakan untuk mengirimkan status UI terkini kepada bagian tampilan terkait.
    private val _uiStateDetail = MutableStateFlow<DetailsUiState>(DetailsUiState.Loading)
    // Sebuah StateFlow yang mengekspos _uiStateDetail agar dapat diakses secara aman dari luar kelas.
    val uiStateDetail = _uiStateDetail.asStateFlow()

    // Fungsi untuk mengambil dan menampilkan detail buku berdasarkan ID.
    fun getBook(id: String) {
        // Menggunakan viewModelScope untuk memastikan bahwa coroutine yang dijalankan bersifat terkait dengan siklus hidup ViewModel.
        viewModelScope.launch {
            // Menetapkan status Loading sebelum memulai pengambilan data buku.
            _uiStateDetail.value = DetailsUiState.Loading
            try {
                // Melakukan pengambilan data buku dari repository.
                val book = bookshelfRepository.getBook(id)
                // Memeriksa apakah buku berhasil diambil.
                if (book == null) {
                    // Menetapkan status Error jika buku tidak ditemukan.
                    _uiStateDetail.value = DetailsUiState.Error
                } else {
                    // Menetapkan status Success dan mengirimkan buku ke tampilan jika pengambilan berhasil.
                    _uiStateDetail.value = DetailsUiState.Success(book)
                }
            } catch (e: IOException) {
                // Menetapkan status Error jika terjadi IOException.
                _uiStateDetail.value = DetailsUiState.Error
            } catch (e: HttpException) {
                // Menetapkan status Error jika terjadi HttpException.
                _uiStateDetail.value = DetailsUiState.Error
            }
        }
    }

    /**
     * Factory for [DetailsViewModel] that takes [BookshelfRepository] as a dependency.
     */
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                // Mendapatkan instance BookshelfRepository dari container aplikasi.
                val application =
                    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as BookshelfApplication)
                val bookshelfRepository = application.container.bookshelfRepository
                // Membuat dan mengembalikan instance DetailsViewModel dengan BookshelfRepository sebagai dependency.
                DetailsViewModel(bookshelfRepository = bookshelfRepository)
            }
        }
    }
}