package com.miso.appvinilos.presentacion.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.miso.appvinilos.data.model.Collector
import com.miso.appvinilos.data.repositories.CollectorRepository
import kotlinx.coroutines.launch

class CollectorViewModel(application: Application) : AndroidViewModel(application) {
    private val collectorRepository = CollectorRepository()
    private val _collectors = MutableLiveData<List<Collector>>()
    val collectors: LiveData<List<Collector>>
        get() = _collectors

    private val _collector = MutableLiveData<Collector>()
    val collector: LiveData<Collector>
        get() = _collector

    fun fetchCollectors() {
        viewModelScope.launch {
            try {
                val collectorsList = collectorRepository.getCollectors()
                _collectors.value = collectorsList
            } catch (e: Exception) {
                // Handle error
                e.printStackTrace()
            }
        }
    }

    fun fetchCollector(id: Int) {
        viewModelScope.launch {
            try {
                val foundCollector = collectorRepository.getCollector(id)
                _collector.value = foundCollector
            } catch (e: Exception) {
                // Handle error
                e.printStackTrace()
            }
        }
    }
}