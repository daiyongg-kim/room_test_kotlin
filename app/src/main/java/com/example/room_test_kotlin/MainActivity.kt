package com.example.room_test_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel : MainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.getAll().observe(this, Observer { todos ->
            result_text.text = todos.toString()
        })

        add_button.setOnClickListener{
            viewModel.insert(Todo(todo_edit.text.toString()))
        }

        remove_button.setOnClickListener {
            viewModel.deleteAll()
        }
    }
}