package com.tazmans_android.androidmytodo

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ToDoDao {
    @Query("SELECT * FROM todo_table")
    fun getAllData(): LiveData<List<ToDoData>>

    @Insert
    suspend fun insertData(toDoData: ToDoData)
}