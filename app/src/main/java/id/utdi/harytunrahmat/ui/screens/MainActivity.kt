package id.utdi.harytunrahmat.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import id.utdi.harytunrahmat.ui.BookshelfApp
import id.utdi.harytunrahmat.ui.theme.BookshelfTheme
//import com.google.android.material.color.DynamicColors

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setContent digunakan untuk menetapkan tata letak utama dari aktivitas dengan menggunakan Compose.
        setContent {
            // BookshelfTheme adalah tema yang diterapkan ke seluruh aplikasi menggunakan Compose.
            BookshelfTheme {
                // BookshelfApp() adalah komponen utama aplikasi yang menangani navigasi dan tata letak.
                BookshelfApp()
            }
        }
    }
}