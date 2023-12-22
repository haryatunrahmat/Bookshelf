package id.utdi.harytunrahmat

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import id.utdi.harytunrahmat.ui.screens.detail_screen.DetailScreen
import id.utdi.harytunrahmat.ui.screens.detail_screen.DetailsViewModel
import id.utdi.harytunrahmat.ui.screens.favorite_screen.FavoritesScreen
import id.utdi.harytunrahmat.ui.screens.query_screen.QueryScreen
import id.utdi.harytunrahmat.ui.screens.query_screen.QueryViewModel
import id.utdi.harytunrahmat.ui.screens.menu_screen.MenuScreen

// Program di bawah ini adalah fungsi komposisi utama yang bertanggung jawab untuk menampilkan layar-layar aplikasi Bookshelf.
// Program di bawah ini menggunakan Compose Navigation untuk menangani perpindahan antar layar.

@Composable
fun BookshelfNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    // Program di bawah ini Mendeklarasikan dan menginisialisasi ViewModel untuk layar QueryScreen menggunakan Compose ViewModel.
    val viewModel: QueryViewModel = viewModel(factory = QueryViewModel.Factory)

    // Program di bawah ini Menentukan struktur navigasi antar layar menggunakan NavHost.
    NavHost(
        navController = navController,
        startDestination = AppDestinations.MenuScreen.name,
        modifier = modifier
    ) {

        // Program di bawah ini untuk Komposisi layar MenuScreen, menavigasi ke layar QueryScreen atau FavoriteScreen.
        composable(route = AppDestinations.MenuScreen.name) {
            MenuScreen(
                onSearchClick = {
                    navController.navigate(AppDestinations.QueryScreen.name)
                },
                onFavClick = {
                    navController.navigate(AppDestinations.FavoriteScreen.name)
                }
            )
        }

        // Program di bawah ini untuk komposisi layar QueryScreen dan menampilkan daftar buku yang memungkinkan navigasi ke layar DetailScreen.
        composable(route = AppDestinations.QueryScreen.name) {
            QueryScreen(
                viewModel = viewModel,
                retryAction = { viewModel.getBooks() },
                onDetailsClick = {
                    viewModel.selectedBookId = it.id
                    navController.navigate(AppDestinations.DetailScreen.name)
                },
            )
        }

        // Program di bawah ini untuk komposisi  layar FavoriteScreen, menampilkan daftar buku favorit.
        composable(route = AppDestinations.FavoriteScreen.name) {
            FavoritesScreen(
                viewModel = viewModel,
                retryAction = { viewModel.getBooks() },
                bookshelfUiState = viewModel.favoritesfUiState
            )
        }

        // Program di bawah ini untuk komposisi layar DetailScreen, menampilkan detail buku tertentu.
        composable(route = AppDestinations.DetailScreen.name) {
            // Mendeklarasikan dan menginisialisasi ViewModel untuk layar DetailScreen menggunakan Compose ViewModel.
            val detailViewModel: DetailsViewModel = viewModel(factory = DetailsViewModel.Factory)
            detailViewModel.getBook(viewModel.selectedBookId)

            DetailScreen(
                viewModel = detailViewModel,
                retryAction = { detailViewModel.getBook(viewModel.selectedBookId) },
            )
        }
    }
}
