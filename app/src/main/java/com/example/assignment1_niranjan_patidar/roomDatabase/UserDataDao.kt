package com.example.assignment1_niranjan_patidar.roomDatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.assignment1_niranjan_patidar.roomDatabase.UserData

@Dao
interface UserDataDao {
    @Query("SELECT * from UserChoice")
    fun getData():LiveData<List<UserData>>

    @Insert
    suspend fun insertData(userData: UserData)
}