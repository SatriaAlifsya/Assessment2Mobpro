package org.d3if0025.mobpro1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.d3if0025.mobpro1.model.Cuci


@Database(entities = [Cuci::class], version = 1, exportSchema = false)
abstract class CuciDb : RoomDatabase() {
    abstract val dao: CuciDao

    companion object {
        @Volatile
        private var INSTANCE: CuciDb? = null

        fun getInstance(context: Context): CuciDb {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CuciDb::class.java,
                        "topup.db"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}