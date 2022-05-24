package org.d3if4080.test_assesment2_muhammaddaffa6706204080.DataBase.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.Models.History

@Database(
    entities = [
        History::class,
    ],
    version = 1,
    exportSchema = false
)
abstract class RoomDb : RoomDatabase() {

    abstract val HistoryDao: HistoryDao

    companion object {
        @Volatile
        private var INSTANCE: RoomDb? = null

        fun getInstance(context: Context): RoomDb {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        RoomDb::class.java,
                        "tes.db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}