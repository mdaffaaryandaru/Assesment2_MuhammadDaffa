package org.d3if4080.test_assesment2_muhammaddaffa6706204080.DataBase.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.Models.History

@Dao
 interface HistoryDao {
    @Insert
    suspend fun insertHistory(history:History)
    @Query ("SELECT * FROM table_resource")
    fun GetAllResource():LiveData <List <History>>
    @Query("DELETE FROM table_resource WHERE id = :id")
    suspend fun deleteHistory(id: Int)

}