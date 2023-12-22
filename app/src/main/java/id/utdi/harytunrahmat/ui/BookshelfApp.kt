package id.utdi.harytunrahmat.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import id.utdi.harytunrahmat.AppDestinations
import id.utdi.harytunrahmat.BookshelfNavHost
import id.utdi.harytunrahmat.ui.screens.components.MyTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookshelfApp(
    modifier: Modifier = Modifier
) {
    // Set Nav Controller untuk mengelola navigasi antar layar
    val navController = rememberNavController()

    // Dapatkan entri stack kembali saat ini
    val backStackEntry by navController.currentBackStackEntryAsState()

    // Dapatkan nama layar saat ini dan cek apakah null
    val currentScreen = id.utdi.harytunrahmat.AppDestinations.valueOf(
        backStackEntry?.destination?.route ?: id.utdi.harytunrahmat.AppDestinations.QueryScreen.name
    )

    // Boolean untuk mengecek apakah dapat kembali ke layar sebelumnya
    val canNavigateBack = navController.previousBackStackEntry != null

    // Scaffold digunakan untuk menyusun elemen-elemen tata letak seperti AppBar dan content area.
    Scaffold(
        topBar = {
            // MyTopAppBar adalah komponen AppBar yang menampilkan judul layar dan tombol kembali jika mungkin.
            MyTopAppBar(
                currentScreen = currentScreen,
                canNavigateBack = canNavigateBack,
                onNavigateUpClicked = { navController.navigateUp() }
            )
        }
    ) {
        // Surface digunakan sebagai area konten utama dengan mengatur properti warna latar belakang.
        Surface(
            modifier = modifier
                .fillMaxSize()
                .padding(it),
            color = MaterialTheme.colorScheme.background
        ) {
            // BookshelfNavHost mengatur navigasi antar layar menggunakan Compose Navigation.
            BookshelfNavHost(
                navController = navController,
                modifier = modifier
            )
        }
    }
}