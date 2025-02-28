package com.guptamansi.whattodo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(
    var todo: List<Todo>
): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    inner class TodoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tVTodoItem: TextView = itemView.findViewById(R.id.tVTodoItem)
        val cBTodo: AppCompatCheckBox = itemView.findViewById(R.id.cBTodo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return TodoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return todo.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val currentTodo = todo[position]
        holder.tVTodoItem.text = currentTodo.title
        holder.cBTodo.isChecked = currentTodo.isChecked
    }
}