package org.d3if0025.mobpro1.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.d3if0025.mobpro1.model.Cuci


@Dao
interface CuciDao {
    @Insert
    suspend fun insert(cuci: Cuci)

    @Update
    suspend fun update(cuci: Cuci)

    @Query("SELECT * FROM cuciDb ORDER BY harga DESC")
    fun getTopup(): Flow<List<Cuci>>

    @Query("SELECT * FROM cuciDb WHERE id = :id")
    suspend fun getTopupById(id: Long): Cuci?

    @Query("DELETE FROM cuciDb WHERE id = :id")
    suspend fun deleteById(id: Long)
}
