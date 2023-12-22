package id.utdi.harytunrahmat.ui.screens.detail_screen

import id.utdi.harytunrahmat.model.Book

// Sealed interface DetailsUiState digunakan untuk merepresentasikan berbagai status UI.
sealed interface DetailsUiState {
    // Kelas Success merepresentasikan status ketika pengambilan data buku berhasil.
    data class Success(val bookItem: Book) : DetailsUiState
    // Object Error merepresentasikan status ketika terjadi kesalahan dalam pengambilan data buku.
    object Error : DetailsUiState
    // Object Loading merepresentasikan status ketika aplikasi sedang dalam proses memuat data buku.
    object Loading : DetailsUiState
}