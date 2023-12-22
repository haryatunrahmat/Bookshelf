package id.utdi.harytunrahmat.model

import kotlinx.serialization.Serializable

@Serializable
data class Book(
    val id: String,
    val description: String,
    val volumeInfo: VolumeInfo,
    val saleInfo: SaleInfo
) {
    // Fungsi untuk mendapatkan harga buku
    fun getPrice(): String {
        if (saleInfo.listPrice == null) {
            return ""
        }
        // Mengembalikan string yang berisi jumlah dan mata uang harga buku.
        return "${saleInfo.listPrice.amount} ${saleInfo.listPrice.currency}"
    }
}

@Serializable
data class VolumeInfo(
    val title: String,
    val subtitle: String,
    val description: String,
    val imageLinks: ImageLinks? = null,
    val authors: List<String>,
    val publisher: String,
    val publishedDate: String,
) {
    // Properti yang memberikan daftar semua pengarang buku
    val allAuthorsx: String
        get() = allAuthors()

    // Fungsi untuk menggabungkan semua pengarang buku menjadi satu
    fun allAuthors(): String {
        var x = ""
        for (author in authors) {
            x += "$author, "
        }
        return x.trimEnd(',', ' ')
    }
}

@Serializable
data class ImageLinks(
    val smallThumbnail: String,
    val thumbnail: String,
) {
    val httpsThumbnail: String
        get() = thumbnail.replace("http", "https")
}

@Serializable
data class SaleInfo(
    val country: String,
    val isEbook: Boolean,
    val listPrice: ListPrice?
) {
    val getPrice2: String
        get() = "${listPrice?.amount ?: "N/A"} ${listPrice?.currency ?: "N/A"}"
}

@Serializable
data class ListPrice(
    val amount: Float?,
    val currency: String? = ""
)