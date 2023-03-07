package com.tazmans_android.androidmytodo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.tazmans_android.androidmytodo.adapters.TodoListAdapter
import com.tazmans_android.androidmytodo.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var todoAdapter: TodoListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        todoAdapter = TodoListAdapter()
        registerTodoListAdapter()
        return binding.root
    }

    private fun registerTodoListAdapter() = with(binding) {
        rvTodoList.layoutManager = LinearLayoutManager(activity)
        rvTodoList.adapter = todoAdapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}