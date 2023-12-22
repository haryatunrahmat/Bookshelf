package id.utdi.harytunrahmat.ui.screens.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import id.utdi.harytunrahmat.AppDestinations
import id.utdi.harytunrahmat.R

// Komponen AppBar kustom yang menerima parameter berupa tujuan layar saat ini, status kemampuan navigasi kembali, dan aksi navigasi kembali.
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(
    currentScreen: AppDestinations,
    canNavigateBack: Boolean,
    onNavigateUpClicked: () -> Unit
) {
    // Membuat dan menyesuaikan komponen TopAppBar dari Material3.
    TopAppBar(
        // Menampilkan judul AppBar sesuai dengan judul layar saat ini.
        title = { Text(text = currentScreen.title) },
        // Menampilkan ikon tombol kembali jika kemampuan navigasi kembali diaktifkan.
        navigationIcon = {
            if (canNavigateBack) {
                // Menampilkan tombol kembali sebagai IconButton.
                IconButton(
                    onClick = onNavigateUpClicked
                ) {
                    // Menampilkan ikon panah kembali.
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = stringResource(id = R.string.btn_try_again)
                    )
                }
            }
        }
    )
}