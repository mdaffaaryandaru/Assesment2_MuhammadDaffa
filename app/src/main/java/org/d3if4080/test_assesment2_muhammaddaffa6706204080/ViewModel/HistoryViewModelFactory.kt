package org.d3if4080.test_assesment2_muhammaddaffa6706204080.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.Repository.HistoryRepository
import java.lang.IllegalArgumentException

class HistoryViewModelFactory(val repo:HistoryRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HistoryViewModel::class.java)){
            return HistoryViewModel(repo) as T

        }
        throw IllegalArgumentException("Class Tidak Di Temukan")
    }
}