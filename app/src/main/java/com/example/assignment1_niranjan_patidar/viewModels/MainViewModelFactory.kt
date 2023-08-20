package com.example.assignment1_niranjan_patidar.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.assignment1_niranjan_patidar.repository.FacilityRepository

class MainViewModelFactory(private val repository: FacilityRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }

} 