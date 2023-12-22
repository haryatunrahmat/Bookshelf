package id.utdi.harytunrahmat.ui.screens.query_screen

import id.utdi.harytunrahmat.model.Book

sealed interface QueryUiState {
    data class Success(val bookshelfList: List<Book>) : QueryUiState
    object Error : QueryUiState
    object Loading : QueryUiState
}