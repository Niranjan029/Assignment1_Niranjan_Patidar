package com.example.assignment1_niranjan_patidar.roomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserData::class], version = 1)
abstract class UserDatabase :RoomDatabase() {
    abstract fun userDataDao(): UserDataDao

    companion object{
        private var Instance: UserDatabase?=null
        fun getDatabase(context: Context): UserDatabase {
             if(Instance ==null)
             {
                    synchronized(this)
                    {
                        Instance = Room.databaseBuilder(
                            context,
                            UserDatabase::class.java,
                            "user_database"
                        ).build()
                    }

             }
            return Instance!!
        }
    }
}