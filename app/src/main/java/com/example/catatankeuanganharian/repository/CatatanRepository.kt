package com.example.catatankeuanganharian.repository

import com.example.catatankeuanganharian.data.CatatanKeuangan
import com.example.catatankeuanganharian.data.CatatanKeuanganDao
import kotlinx.coroutines.flow.Flow

class CatatanRepository(private val catatanKeuanganDao: CatatanKeuanganDao) {

    fun getAll(): Flow<List<CatatanKeuangan>> = catatanKeuanganDao.getAll()

    suspend fun insert(catatan: CatatanKeuangan) {
        catatanKeuanganDao.insert(catatan)
    }

    suspend fun delete(catatan: CatatanKeuangan) {
        catatanKeuanganDao.delete(catatan)
    }
}
