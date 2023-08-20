package com.example.assignment1_niranjan_patidar.roomDatabase

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "UserChoice")
data class UserData(
    @PrimaryKey(autoGenerate = true)
    val user_id:Int,
    val property_id:Int,
    val rooms_id:Int,
    val other_faci_id:Int
)
