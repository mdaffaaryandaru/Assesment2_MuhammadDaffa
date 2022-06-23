package org.d3if4080.test_assesment2_muhammaddaffa6706204080.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.TemperatureApi
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.data.Temperature

class DataViewModel  : ViewModel() {
    private val data = MutableLiveData<List<Temperature>>()
    private val status = MutableLiveData<TemperatureApi.ApiStatus>()


    init {
        retrieveData()
    }

    private fun retrieveData() {
        viewModelScope.launch(Dispatchers.IO) {
            status.postValue(TemperatureApi.ApiStatus.LOADING)
            try {
                data.postValue(TemperatureApi.service.getTemperature())
                status.postValue(TemperatureApi.ApiStatus.SUCCESS)
                Log.d("dataviewmodel", TemperatureApi.service.toString())
            } catch (e: Exception) {
                Log.d("MainViewModel", "Failure: ${e.message}")
                status.postValue(TemperatureApi.ApiStatus.FAILED)
            }
        }
    }

    fun getData(): LiveData<List<Temperature>> = data

    fun getStatus(): LiveData<TemperatureApi.ApiStatus> = status
}