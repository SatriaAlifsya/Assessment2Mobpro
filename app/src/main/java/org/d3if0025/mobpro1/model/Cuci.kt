package org.d3if0025.mobpro1.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cuciDb")
data class Cuci(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val nama: String,
    val harga: String,
    val jenis: String
)

