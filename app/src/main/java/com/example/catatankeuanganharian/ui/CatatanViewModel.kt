package com.example.catatankeuanganharian.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catatankeuanganharian.data.CatatanKeuangan
import com.example.catatankeuanganharian.repository.CatatanRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class CatatanViewModel(private val repository: CatatanRepository) : ViewModel() {

    val catatanListState: StateFlow<List<CatatanKeuangan>> = repository.getAll()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    val totalPengeluaran: StateFlow<Double> = catatanListState
        .map { list -> list.sumOf { it.jumlah } }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = 0.0
        )

    fun tambahCatatan(judul: String, jumlah: Double, kategori: String) {
        viewModelScope.launch {
            val catatan = CatatanKeuangan(
                judul = judul,
                jumlah = jumlah,
                kategori = kategori,
                tanggal = System.currentTimeMillis()
            )
            repository.insert(catatan)
        }
    }

    fun hapusCatatan(catatan: CatatanKeuangan) {
        viewModelScope.launch {
            repository.delete(catatan)
        }
    }
}
