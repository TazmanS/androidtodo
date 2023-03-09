package com.tazmans_android.androidmytodo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_table")
data class ToDoData (
    @PrimaryKey(autoGenerate = true)
    val id: Int?,

    val title: String
)