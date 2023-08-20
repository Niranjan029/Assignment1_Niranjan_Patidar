package com.example.assignment1_niranjan_patidar.api

import com.example.assignment1_niranjan_patidar.dataClasses.Facilities
import retrofit2.Response
import retrofit2.http.GET

interface FacilitiesApi {
    @GET("/iranjith4/ad-assignment/db")
    suspend fun getFacilities():Response<Facilities>
}