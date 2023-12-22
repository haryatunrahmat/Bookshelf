package id.utdi.harytunrahmat.ui.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import id.utdi.harytunrahmat.R
import id.utdi.harytunrahmat.ui.theme.BookshelfTheme

// Komponen untuk menampilkan layar ketika tidak ada hasil yang ditemukan.
@Composable
fun NothingFoundScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Menampilkan gambar "Not Found" dengan skala kontennya disesuaikan agar memenuhi lebar layar.
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.ic_not_found),
            contentDescription = null,
            contentScale = ContentScale.Fit
        )
        // Menampilkan teks pesan bahwa tidak ada catatan yang ditemukan dengan berat huruf tebal.
        Text(
            stringResource(R.string.no_records_found_msg),
            fontWeight = FontWeight.Bold
        )
    }
}

// Contoh tampilan preview untuk komponen NothingFoundScreen.
@Preview(showSystemUi = true)
@Composable
fun NothingFoundScreenPreview() {
    BookshelfTheme {
        // Menampilkan preview komponen NothingFoundScreen.
        NothingFoundScreen()
    }
}