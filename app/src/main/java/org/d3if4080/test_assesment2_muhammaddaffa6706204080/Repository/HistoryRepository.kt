package org.d3if4080.test_assesment2_muhammaddaffa6706204080.Repository

import androidx.lifecycle.LiveData
import androidx.room.Query
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.DataBase.dao.HistoryDao
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.Models.History

class HistoryRepository(val dao: HistoryDao )  {
    suspend fun insertCelcius (history: History){
        dao.insertHistory(history)
    }

    suspend fun deleteHistory (id: Int){
        dao.deleteHistory(id)
    }
    fun GetAllResource(): LiveData<List<History>> = dao.GetAllResource()

}