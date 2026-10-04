package com.example.catatankeuanganharian.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "catatan_keuangan")
data class CatatanKeuangan(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val judul: String,
    val jumlah: Double,
    val kategori: String,
    val tanggal: Long // Timestamp (System.currentTimeMillis())
)
