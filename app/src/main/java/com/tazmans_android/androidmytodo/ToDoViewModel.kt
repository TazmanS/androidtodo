package com.tazmans_android.androidmytodo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class ToDoViewModel(application: Application): AndroidViewModel(application) {

    private val toDoDao = ToDoDataBase.getDataBase(application).toDoDao()
    private val repository: ToDoRepository

    private val getAllData: LiveData<List<ToDoData>>

    init {
        repository = ToDoRepository(toDoDao)
        getAllData = repository.getAllData
    }

    suspend fun insertData(doToDoData: ToDoData) {
        repository.insertData(doToDoData)
    }

    fun getAllData(): LiveData<List<ToDoData>> {
        return getAllData
    }

}