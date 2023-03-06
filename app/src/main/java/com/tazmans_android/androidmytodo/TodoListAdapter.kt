package com.tazmans_android.androidmytodo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tazmans_android.androidmytodo.databinding.TodoItemBinding


class TodoListAdapter: RecyclerView.Adapter<TodoListAdapter.ViewHolder>() {
    val data = mutableListOf<String>("Test")

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     * это по сути наш class Item
     */
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val binding = TodoItemBinding.bind(view)

        fun setData(bindData : String) = with(binding) {
            tvText.text = bindData
        }
    }

    // Create new views (invoked by the layout manager) создание нового элемента на основе класса ViewHolder
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.todo_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager) наполнение элемента
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.setData(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun addNewItem(text: String) {
        data.add(text)
        notifyDataSetChanged()
    }
}