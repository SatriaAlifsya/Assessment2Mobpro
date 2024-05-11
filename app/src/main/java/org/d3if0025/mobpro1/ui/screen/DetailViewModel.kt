package org.d3if0025.mobpro1.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if0025.mobpro1.database.CuciDao
import org.d3if0025.mobpro1.model.Cuci


class DetailViewModel(private val dao: CuciDao) : ViewModel() {

    fun insert(nama: String, harga: String, jenis: String) {
        val sepatu = Cuci(
            nama = nama,
            harga = harga,
            jenis = jenis
        )
        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(sepatu)
        }
    }

    suspend fun getSepatu(id: Long): Cuci? {
        return dao.getTopupById(id)
    }

    fun update(id: Long, nama: String, harga: String, jenis: String) {
        val sepatu = Cuci(
            id = id,
            nama = nama,
            harga = harga,
            jenis = jenis
        )
        viewModelScope.launch(Dispatchers.IO) {
            dao.update(sepatu)
        }
    }

    fun delete(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteById(id)
        }
    }
}