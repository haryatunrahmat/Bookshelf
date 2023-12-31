package id.utdi.harytunrahmat.ui.screens.favorite_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import id.utdi.harytunrahmat.R
import id.utdi.harytunrahmat.ui.screens.components.ErrorScreen
import id.utdi.harytunrahmat.ui.screens.components.LoadingScreen
import id.utdi.harytunrahmat.ui.screens.query_screen.*

@Composable
fun FavoritesScreen(
    viewModel: QueryViewModel,
    bookshelfUiState: QueryUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Menggunakan Column sebagai wadah utama untuk tata letak.
    Column {
        // Mengecek apakah daftar buku favorit tidak kosong.
        if (!viewModel.favoriteBooks.isEmpty()) {
            // Memeriksa status UI dari QueryUiState.
            when (bookshelfUiState) {
                // Jika dalam status Loading, tampilkan layar loading.
                is QueryUiState.Loading -> LoadingScreen(modifier)
                // Jika dalam status Success, tampilkan daftar buku menggunakan GridList.
                is QueryUiState.Success -> GridList(
                    bookshelfList = bookshelfUiState.bookshelfList,
                    viewModel = viewModel,
                    modifier = modifier,
                    onDetailsClick = { }
                )
                // Jika dalam status lainnya, tampilkan layar kesalahan dengan opsi untuk mengulangi.
                else -> ErrorScreen(retryAction, modifier)
            }
        } else {
            // Jika daftar buku favorit kosong, tampilkan pesan bahwa tidak ada buku favorit.
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(stringResource(R.string.NoFavoriteBooksText))
            }
        }
    }
}