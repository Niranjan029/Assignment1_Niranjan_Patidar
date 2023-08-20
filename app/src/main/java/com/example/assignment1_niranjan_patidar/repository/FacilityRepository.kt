package com.example.assignment1_niranjan_patidar.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.assignment1_niranjan_patidar.api.FacilitiesApi
import com.example.assignment1_niranjan_patidar.dataClasses.Facilities

class FacilityRepository(private val facilitiesApi:FacilitiesApi) {

    private val facilityLiveData=MutableLiveData<Facilities>()
    val facilities:LiveData<Facilities>
    get() = facilityLiveData

    suspend fun getFacilities()
    {
        val result = facilitiesApi.getFacilities()
        if(result.body() != null)
        {
            facilityLiveData.postValue(result.body())
        }


    }

}