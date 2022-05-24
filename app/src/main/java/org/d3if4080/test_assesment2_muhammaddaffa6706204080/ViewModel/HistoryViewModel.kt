package org.d3if4080.test_assesment2_muhammaddaffa6706204080.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.Models.History
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.Repository.HistoryRepository

class HistoryViewModel(val repo: HistoryRepository) : ViewModel() {
    val getAllResource: LiveData<List<History>> = repo.GetAllResource()
    fun InsertHistory(history: History) = viewModelScope.launch(Dispatchers.IO) {
        repo.insertCelcius(history)
    }

    fun deleteHistory(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        repo.deleteHistory(id)
    }
}