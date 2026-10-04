package com.example.catatankeuanganharian

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.catatankeuanganharian.data.AppDatabase
import com.example.catatankeuanganharian.repository.CatatanRepository
import com.example.catatankeuanganharian.ui.CatatanKeuanganScreen
import com.example.catatankeuanganharian.ui.CatatanViewModel
import com.example.catatankeuanganharian.ui.CatatanViewModelFactory
import com.example.catatankeuanganharian.ui.theme.CatatanKeuanganHarianTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val database = AppDatabase.getDatabase(applicationContext)
        val repository = CatatanRepository(database.catatanKeuanganDao())
        val viewModelFactory = CatatanViewModelFactory(repository)

        setContent {
            CatatanKeuanganHarianTheme {
                val viewModel: CatatanViewModel = viewModel(factory = viewModelFactory)
                CatatanKeuanganScreen(viewModel = viewModel)
            }
        }
    }
}
