package id.utdi.harytunrahmat.ui.screens.menu_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import id.utdi.harytunrahmat.R

@Composable
fun MenuScreen(
    onSearchClick: () -> Unit,
    onFavClick: () -> Unit
) {
    // Menggunakan Column sebagai wadah utama untuk tata letak.
    Column(
        modifier = Modifier.fillMaxSize().padding(top = 32.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Menampilkan tombol untuk melakukan pencarian buku dengan mengganti layar ke QueryScreen.
        Button(
            onClick = onSearchClick
        ) {
            Text(text = stringResource(R.string.btn_search))
        }
        // Menambahkan ruang kosong vertikal antara tombol pencarian dan tombol favorit.
        Spacer(modifier = Modifier.height(16.dp))
        // Menampilkan tombol untuk menampilkan daftar buku favorit dengan mengganti layar ke FavoriteScreen.
        Button(
            onClick = onFavClick
        ) {
            Text(text = stringResource(R.string.btn_favorite))
        }
    }
}