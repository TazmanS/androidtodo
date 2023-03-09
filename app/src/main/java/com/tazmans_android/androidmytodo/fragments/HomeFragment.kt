package com.tazmans_android.androidmytodo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.tazmans_android.androidmytodo.ToDoViewModel
import com.tazmans_android.androidmytodo.adapters.TodoListAdapter
import com.tazmans_android.androidmytodo.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var todoAdapter: TodoListAdapter

    private val mToDoViewModel: ToDoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        registerTodoListAdapter()

        return binding.root
    }

    private fun registerTodoListAdapter() = with(binding) {
        val data = mToDoViewModel.getAllData()
        todoAdapter = TodoListAdapter()
        rvTodoList.layoutManager = LinearLayoutManager(activity)
        rvTodoList.adapter = todoAdapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}