package id.utdi.harytunrahmat.model

import kotlinx.serialization.Serializable

@Serializable
data class QueryResponse(
    // Properti yang menyimpan daftar buku yang sesuai dengan kueri pencarian.
    val items: List<Book>?,
    // Properti yang menyimpan total jumlah buku yang ditemukan sesuai dengan kueri pencarian.
    val totalItems: Int,
    // Properti yang menyimpan jenis atau kategori dari respons.
    val kind: String,
)