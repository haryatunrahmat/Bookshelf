package id.utdi.harytunrahmat.ui.screens.detail_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import id.utdi.harytunrahmat.R
import id.utdi.harytunrahmat.model.Book
import id.utdi.harytunrahmat.ui.screens.components.ErrorScreen
import id.utdi.harytunrahmat.ui.screens.components.LoadingScreen

// Komponen utama untuk menampilkan layar rinci (detail) buku.
@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    viewModel: DetailsViewModel,
    retryAction: () -> Unit,
) {
    // Mengambil nilai dari State berupa UI State yang berasal dari ViewModel.
    val uiStateDet = viewModel.uiStateDetail.collectAsState().value

    // Menentukan tampilan berdasarkan UI State.
    when (uiStateDet) {
        is DetailsUiState.Loading -> {
            LoadingScreen()
        }
        is DetailsUiState.Error -> {
            // Menampilkan layar kesalahan jika terjadi kesalahan dalam memuat data buku.
            ErrorScreen(
                retryAction = retryAction
            )
        }
        is DetailsUiState.Success -> {
            // Menampilkan informasi detail buku jika pengambilan data berhasil.
            BookDetails(uiStateDet.bookItem)
        }
    }
}

// Komponen untuk menampilkan detail buku.
@Composable
fun BookDetails(book: Book) {
    // Menggunakan Card untuk menyusun tata letak elemen-elemen detail buku.
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation()
    ) {
        // Column digunakan untuk menempatkan elemen-elemen detail secara vertikal.
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            // Menampilkan judul buku dengan menggunakan Typography titleLarge dari MaterialTheme.
            Text(
                text = "Title: " + book.volumeInfo.title,
                style = MaterialTheme.typography.titleLarge
            )
            // Menampilkan gambar buku menggunakan AsyncImage dengan placeholder, crossfade, dan error handling.
            AsyncImage(
                modifier = Modifier.fillMaxWidth(),
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(book.volumeInfo.imageLinks?.thumbnail)
                    .crossfade(true)
                    .build(),
                contentDescription = book.volumeInfo.title,
                contentScale = ContentScale.FillWidth,
                error = painterResource(id = R.drawable.ic_broken_image),
                placeholder = painterResource(id = R.drawable.loading_img),
            )
            Spacer(modifier = Modifier.height(24.dp))
            // Menampilkan subtitle buku dengan menggunakan Typography titleMedium dari MaterialTheme.
            Text(
                text = stringResource(R.string.book_subtitle, book.volumeInfo.subtitle),
                style = MaterialTheme.typography.titleMedium
            )
            // Menampilkan penulis buku dengan menggunakan Typography titleMedium dari MaterialTheme.
            Text(
                text = stringResource(R.string.book_authors, book.volumeInfo.allAuthors()),
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            // Menampilkan harga buku dengan menggunakan Typography titleMedium dari MaterialTheme.
            Text(
                text = stringResource(R.string.book_price, book.saleInfo.getPrice2),
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            // Menampilkan negara asal buku dengan menggunakan Typography titleMedium dari MaterialTheme.
            Text(
                text = "country: " + book.saleInfo.country,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            // Menampilkan harga buku dengan menggunakan Typography titleMedium dari MaterialTheme.
            Text(
                text = "listPrice: " + book.saleInfo.getPrice2,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            // Menampilkan deskripsi buku dengan menggunakan Typography bodyMedium dari MaterialTheme.
            Text(
                text = "description: " + book.volumeInfo.description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}