package com.example.assignment1_niranjan_patidar.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment1_niranjan_patidar.dataClasses.Facilities
import com.example.assignment1_niranjan_patidar.repository.FacilityRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: FacilityRepository) : ViewModel()
{
    init {
        viewModelScope.launch (Dispatchers.IO){
            repository.getFacilities()
        }
    }
    val facilities:LiveData<Facilities>
     get() = repository.facilities

}