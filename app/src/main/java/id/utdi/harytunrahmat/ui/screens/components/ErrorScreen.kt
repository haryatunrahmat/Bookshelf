package id.utdi.harytunrahmat.ui.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
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

// Komponen untuk menampilkan layar kesalahan.
@Composable
fun ErrorScreen(
    retryAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Menampilkan gambar kesalahan dengan skala kontennya disesuaikan agar memenuhi lebar layar.
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.ic_connection_error),
            contentDescription = null,
            contentScale = ContentScale.Fit
        )
        // Menampilkan teks pesan kesalahan dengan berat huruf tebal.
        Text(
            stringResource(R.string.failed_to_load_msg),
            fontWeight = FontWeight.Bold
        )
        // Menampilkan tombol "Try Again" yang akan menjalankan aksi retryAction ketika diklik.
        Button(onClick = retryAction) {
            Text(stringResource(R.string.btn_try_again))
        }
    }
}

// Contoh tampilan preview untuk komponen ErrorScreen.
@Preview(showSystemUi = true)
@Composable
fun ErrorScreenPreview() {
    BookshelfTheme {
        // Menampilkan preview komponen ErrorScreen.
        ErrorScreen(retryAction = { })
    }
}