package com.example.catatankeuanganharian.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CatatanKeuanganDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(catatan: CatatanKeuangan)

    @Delete
    suspend fun delete(catatan: CatatanKeuangan)

    @Query("SELECT * FROM catatan_keuangan ORDER BY tanggal DESC")
    fun getAll(): Flow<List<CatatanKeuangan>>
}
