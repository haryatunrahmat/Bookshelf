package id.utdi.harytunrahmat.ui.screens.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import id.utdi.harytunrahmat.ui.theme.BookshelfTheme

// Komponen untuk menampilkan layar loading atau indikator kemajuan.
@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        // Menampilkan indikator putar sebagai tanda bahwa proses loading sedang berlangsung.
        CircularProgressIndicator()
    }
}

// Contoh tampilan preview untuk komponen LoadingScreen.
@Preview(showSystemUi = true)
@Composable
fun LoadingScreenPreview() {
    BookshelfTheme {
        // Menampilkan preview komponen LoadingScreen.
        LoadingScreen()
    }
}