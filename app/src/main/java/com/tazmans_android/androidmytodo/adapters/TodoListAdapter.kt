package com.tazmans_android.androidmytodo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tazmans_android.androidmytodo.R
import com.tazmans_android.androidmytodo.databinding.TodoItemBinding
import com.tazmans_android.androidmytodo.entities.NoteItem


class TodoListAdapter: RecyclerView.Adapter<TodoListAdapter.ViewHolder>() {
    val data = mutableListOf<NoteItem>(NoteItem("test", "test3222"))

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val binding = TodoItemBinding.bind(view)

        fun setData(noteItem: NoteItem) = with(binding) {
            tvText.text = noteItem.title
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.todo_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.setData(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun addNewItem(text: String) {
        data.add(NoteItem(text, text))
        notifyDataSetChanged()
    }
}