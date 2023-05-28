package com.example.room_test_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).allowMainThreadQueries()
            .build()

        result_text.text = db.todoDao().getAll().toString()

        add_button.setOnClickListener{
            db.todoDao().insert(Todo(todo_edit.text.toString()))
            result_text.text = db.todoDao().getAll().toString()
        }

        remove_button.setOnClickListener {
            db.todoDao().deleteAll()
            result_text.text = db.todoDao().getAll().toString()
        }

    }
}