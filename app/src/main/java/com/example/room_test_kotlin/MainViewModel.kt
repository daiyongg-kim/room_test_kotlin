package com.example.room_test_kotlin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application){
    val db = Room.databaseBuilder(
        application,
        AppDatabase::class.java, "database-name"
    ).allowMainThreadQueries()
        .build()

    fun getAll(): LiveData<List<Todo>> {
        return db.todoDao().getAll()
    }

    fun insert(todo: Todo) {
        CoroutineScope(Dispatchers.IO).launch {
            db.todoDao().insert(todo)
        }
    }

    fun deleteAll() {
        CoroutineScope(Dispatchers.IO).launch {
            db.todoDao().deleteAll()
        }
    }

}