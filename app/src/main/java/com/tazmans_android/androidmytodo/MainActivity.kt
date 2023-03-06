package com.tazmans_android.androidmytodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.tazmans_android.androidmytodo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var todoAdapter = TodoListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerTodoListAdapter()
    }

    private fun registerTodoListAdapter() = with(binding) {
        rvTodoList.layoutManager = LinearLayoutManager(this@MainActivity)
        rvTodoList.adapter = todoAdapter

        addNewListItem()
    }

    fun addNewListItem() {
        binding.bAdd.setOnClickListener {
            val text = binding.etNewItem.text.toString()
            todoAdapter.addNewItem(text)
        }
    }
}