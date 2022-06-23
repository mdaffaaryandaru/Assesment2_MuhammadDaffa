package org.d3if4080.test_assesment2_muhammaddaffa6706204080.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class DataViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DataViewModel::class.java)){
            return DataViewModel() as T
        }
        throw IllegalArgumentException("Class dataviemodel Tidak Di Temukan")
    }
}