package id.utdi.harytunrahmat

import android.app.Application
import id.utdi.harytunrahmat.di.AppContainer
import id.utdi.harytunrahmat.di.DefaultAppContainer
class BookshelfApplication : Application() {
    /** Instance AppContainer yang digunakan oleh kelas lain untuk mendapatkan dependensi */
    lateinit var container: AppContainer

    /**
     * Metode `onCreate` yang dipanggil saat aplikasi dimulai.
     * Di sini, instance `DefaultAppContainer` diinisialisasi dan disimpan dalam properti `container`.
     */
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}